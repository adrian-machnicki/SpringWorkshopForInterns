package com.workshop.springbootapp.config;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("secret.service.user")
@Data
@NoArgsConstructor
public class SecretServiceUserConfig {
    private String name;
    private String key;
    private List<String> roles;
}
