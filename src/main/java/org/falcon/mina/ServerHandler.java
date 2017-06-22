package org.falcon.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.falcon.light.constants.LightOperationConstants;
import org.falcon.light.model.LightInfo;
import org.falcon.light.model.LightOperationLog;
import org.falcon.light.service.ILightInfoService;
import org.falcon.light.service.ILightOperationLogService;
import org.falcon.utils.ByteUtils;
import org.falcon.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by lihuibing on 2017/6/9.
 */
@Component
public class ServerHandler extends IoHandlerAdapter {

    @Autowired
    private ILightInfoService lightInfoService;

    @Autowired
    private ILightOperationLogService lightOperationLogService;

    private Map<Long,IoSession> sessions = new ConcurrentHashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public Map<Long,IoSession> getSessions(){
        lock.readLock().lock();
        Map<Long,IoSession> sessions = this.sessions;
        lock.readLock().unlock();
        return sessions;
    }

    public void putSession(IoSession ioSession){
        lock.writeLock().lock();
        this.sessions.put(ioSession.getId(),ioSession);
        lock.writeLock().unlock();
    }

    public void removeSession(IoSession ioSession){
        lock.writeLock().lock();
        this.sessions.remove(ioSession.getId());
        lock.writeLock().unlock();
    }


    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        IoBuffer buffer = (IoBuffer) message;
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes,buffer.position(),buffer.limit());
        String convertMessage = ByteUtils.bytesToString(bytes);
        handlerReceiveMessage(session, convertMessage);
    }


    /**
     * 处理接受的消息
     * @param session socket 会话
     * @param convertMessage 转换后的消息
     * @throws LightNotFoundException 路灯不存在异常
     * @throws MessageException 消息异常
     */
    private void handlerReceiveMessage(IoSession session, String convertMessage) throws LightNotFoundException, MessageException {
        String [] messageArray = convertMessage.split("AA");
        if(messageArray.length > 0){
            for(int i =0; i < messageArray.length; i++){
                String messageStr = messageArray[i] + "AA";
                String [] contents = messageStr.split(" ");
                if(contents.length > 12 ){
                    String shortIp = contents[7] + " " + contents[8];
                    List<LightInfo> lightInfos = lightInfoService.findByShortIp(shortIp);
                    if( lightInfos.size()>0 ){
                        LightInfo lightInfo = lightInfos.get(0);
                        LightOperationLog lightOperationLog = new LightOperationLog();
                        lightOperationLog.setMessage(messageStr);
                        lightOperationLog.setId(UUID.randomUUID().toString());
                        lightOperationLog.setLightInfo(lightInfo);
                        lightOperationLog.setType(LightOperationConstants.LIGHT_OPERATION_RECEIVED);
                        lightOperationLog.setInsertTime(DateUtils.getCurrentDateTime());
                        lightOperationLogService.save(lightOperationLog);
                    } else {
                        throw new LightNotFoundException("unknown light,the short ip is :" + shortIp +",please check it");
                    }
                }
            }
        } else {
            throw new MessageException("get a wrong message from client:" + session.getId());
        }
    }


    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        removeSession(session);
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {

    }

    /**
     * 推送消息
     * @param message 消息内容
     */
    public void pushMessage(Object message){
        sessions.forEach((key,session) ->{
            session.write(IoBuffer.wrap((byte[])message));
        });
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        removeSession(session);
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        putSession(session);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {

    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {

    }
}
