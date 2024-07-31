package com.app.webf1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(modifyOnCreate = false)
public class AuditConfig {
//    @Bean
////    public AuditorAware<Long> AuditorAware() {
////
////        return ()-> Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
////                .map(authentication -> (CustomUserDetails) authentication.getPrincipal())
////                .map(CustomUserDetails::getId);
////    }
}
