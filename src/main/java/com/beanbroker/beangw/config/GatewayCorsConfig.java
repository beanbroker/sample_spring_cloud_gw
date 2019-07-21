package com.beanbroker.beangw.config;

import org.springframework.web.cors.CorsConfiguration;

public class GatewayCorsConfig extends CorsConfiguration {



    @Override
    public String checkOrigin(String requestOrigin) {
        return super.checkOrigin(requestOrigin);
    }
}
