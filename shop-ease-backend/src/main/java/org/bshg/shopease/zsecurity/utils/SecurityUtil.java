package org.bshg.shopease.zsecurity.utils;

import org.bshg.shopease.Application;
import org.bshg.shopease.zsecurity.entity.AppUser;
import org.bshg.shopease.zsecurity.service.facade.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;


@Service
public class SecurityUtil {

    private SecurityUtil() {
    }

    public static AppUser getCurrentUser() {
        UserService userService = Application.getCtx().getBean(UserService.class);

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Object user = securityContext.getAuthentication().getPrincipal();
        System.out.println(user);
        if (user instanceof String s) {
            return userService.findByUsername((String) user);
        } else if (user instanceof AppUser) {
            return (AppUser) user;
        } else {
            return null;
        }
    }

    public static boolean isCurrentUserInRole(String authority) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null &&
                getAuthorities(authentication).anyMatch(authority::equals);
    }

    private static Stream<String> getAuthorities(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority);
    }

}
