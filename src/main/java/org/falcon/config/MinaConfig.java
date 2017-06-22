package org.falcon.config;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.integration.beans.InetSocketAddressEditor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.falcon.mina.ServerHandler;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.beans.PropertyEditor;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lihuibing on 2017/6/19.
 */
@Configuration
public class MinaConfig implements EnvironmentAware {

    private Environment environment;
    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
        this.propertyResolver = new RelaxedPropertyResolver(environment,"socket.");
    }

    @Bean
    public ServerHandler serverHandler(){
        return new ServerHandler();
    }


    @Bean
    public CustomEditorConfigurer customEditorConfigurer(){
        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
        Map<Class<?>, Class<? extends PropertyEditor>> customEditors = new HashMap<>();
        customEditors.put(SocketAddress.class, InetSocketAddressEditor.class);
        customEditorConfigurer.setCustomEditors(customEditors);
        return customEditorConfigurer;
    }

    @Bean(initMethod = "bind",destroyMethod = "unbind")
    public NioSocketAcceptor nioSocketAcceptor(){
        NioSocketAcceptor nioSocketAcceptor = new NioSocketAcceptor();
        nioSocketAcceptor.setDefaultLocalAddress(new InetSocketAddress(Integer.valueOf(propertyResolver.getProperty("port"))));
        nioSocketAcceptor.setFilterChainBuilder(defaultIoFilterChainBuilder());
        nioSocketAcceptor.setHandler(serverHandler());
        return nioSocketAcceptor;
    }

    @Bean
    public LoggingFilter loggingFilter(){
        return new LoggingFilter();
    }

    @Bean
    public DefaultIoFilterChainBuilder defaultIoFilterChainBuilder(){
        DefaultIoFilterChainBuilder builder = new DefaultIoFilterChainBuilder();
        Map<String, IoFilterAdapter> filters = new LinkedHashMap<>();
        filters.put("logger",loggingFilter());
        builder.setFilters(filters);
        return builder;
    }


}
