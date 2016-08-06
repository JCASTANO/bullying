package com.bullying;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.bullyng.controller.MensajeController;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
    	register(AppExceptionMapper.class);
        register(MensajeController.class);
    }
}
