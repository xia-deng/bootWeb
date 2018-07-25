package com.lindeng.security.model;

import org.springframework.security.core.GrantedAuthority;

public class MemoryAuthority implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "USER";
    }
}
