package com.app.webf1.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, DEV;

    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
