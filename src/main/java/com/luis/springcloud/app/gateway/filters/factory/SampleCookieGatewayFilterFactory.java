package com.luis.springcloud.app.gateway.filters.factory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import com.luis.springcloud.app.gateway.filters.factory.configuration.ConfigurationCookie;

import reactor.core.publisher.Mono;

@Component
public class SampleCookieGatewayFilterFactory extends AbstractGatewayFilterFactory<ConfigurationCookie>{

    private final Logger logger = LoggerFactory.getLogger(SampleCookieGatewayFilterFactory.class);

    public SampleCookieGatewayFilterFactory(){
        super(ConfigurationCookie.class);
    }

    @Override
    public GatewayFilter apply(ConfigurationCookie config) {
        return new OrderedGatewayFilter((exchange, chain) -> {
            
            logger.info("Ejecutando pre Gateway filter factory: " + config.getMessage());

            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                Optional.ofNullable(config.getValue()).ifPresent(cookie -> {
                    exchange.getResponse().addCookie(ResponseCookie.from(config.getName(), cookie).build());
                });
                logger.info("Ejecutando post Gateway filter factory: " + config.getMessage());
            }));
        }, 100);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("message", "name", "value");
    }

    @Override
    public String name() {
        // Sufijo de la clase "alias"
        return "EjemploCookie";
    }
    
    
}
