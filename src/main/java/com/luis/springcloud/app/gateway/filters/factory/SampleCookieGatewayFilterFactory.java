package com.luis.springcloud.app.gateway.filters.factory;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import com.luis.springcloud.app.gateway.filters.factory.configuration.ConfigurationCookie;

import reactor.core.publisher.Mono;

@Component
public class SampleCookieGatewayFilterFactory extends AbstractGatewayFilterFactory<ConfigurationCookie>{

    public SampleCookieGatewayFilterFactory(){
        super(ConfigurationCookie.class);
    }

    @Override
    public GatewayFilter apply(ConfigurationCookie config) {
        return (exchange, chain) -> {

            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                
            }));
        };
    }
}
