package com.workshop.springbootapp.client;

import com.workshop.springbootapp.config.SecretServiceUserConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SecretServiceClient {

    private SecretServiceUserConfig secretServiceUserConfig;

    public SecretServiceClient(SecretServiceUserConfig secretServiceUserConfig) {
        this.secretServiceUserConfig = secretServiceUserConfig;
        System.out.println("Created SecretServiceClient with following config: " + this.secretServiceUserConfig);
    }
}
