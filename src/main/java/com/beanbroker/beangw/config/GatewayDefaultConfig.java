package com.beanbroker.beangw.config;

import brave.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class GatewayDefaultConfig {

    private final Tracer tracer;



    public GatewayDefaultConfig(Tracer tracer) {
        this.tracer = tracer;

    }

    private static final Logger logger = LoggerFactory.getLogger(GatewayDefaultConfig.class);


    @Bean
    public GlobalFilter lifeLandGlobalFilter() {


        return (exchange, chain) -> chain.filter(exchange).then(Mono.fromRunnable(() -> {


            String tracerId = tracer.currentSpan().context().traceIdString();

//                exchange.getResponse().getHeaders().set("X-BEANBROKER-TRACE", tracerId);


        }));
    }

}