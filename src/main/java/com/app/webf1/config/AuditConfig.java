package com.app.webf1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(modifyOnCreate = false)
public class AuditConfig {
    @Bean
    public AuditorAware<Long> AuditorAware() {

        return ()-> Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(authentication -> (CustomUserDetails) authentication.getPrincipal())
                .map(CustomUserDetails::getId);
    }
}
