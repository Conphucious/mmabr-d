package com.ngu_software.mmabr.utils;

import com.ngu_software.mmabr.entity.user.User;
import com.ngu_software.mmabr.model.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserUtils {

    public UserPrincipal getUserPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return PrincipalUtils.getPrincipalObject(authentication.getPrincipal().toString());
    }

    public User getUser() {
        UserPrincipal userPrincipal = getUserPrincipal();
        String id = userPrincipal.getId();
        String username = userPrincipal.getUsername();
        String email = userPrincipal.getEmail();
        return new User(id, username, email);
    }

    public String getIpAddress() {
//        String ip = ((WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getRemoteAddress();
        return false ? "" : "";
    }

}
