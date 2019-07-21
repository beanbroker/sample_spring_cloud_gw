package com.beanbroker.beangw.config;


import com.beanbroker.beangw.handler.HelloWorldHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@EnableWebFlux
public class RouterConfig implements WebFluxConfigurer {

    @Bean
    public RouterFunction<ServerResponse> routes(HelloWorldHandler handler) {
        return route(GET("/"), handler::helloWorld);
    }

}
