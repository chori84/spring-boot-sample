package com.chori.springbootsecurity;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEventHandler {
    @EventListener
    public void handleBadCredential(AuthenticationFailureBadCredentialsEvent event) {
        System.out.println(event.getAuthentication().getPrincipal() + " 인증 시도 중...");
        System.out.println("비번이 틀렸습니다.");
    }
}
