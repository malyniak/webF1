package com.app.webf1.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, DEV;

    @Override
    public String getAuthority() {
        return name();
    }
}
