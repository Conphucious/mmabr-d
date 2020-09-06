package com.ngu_software.mmabr.controller;

import com.ngu_software.mmabr.entity.user.User;
import com.ngu_software.mmabr.entity.user.Ip;
import com.ngu_software.mmabr.service.UserServiceImpl;
import com.ngu_software.mmabr.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {

    private UserServiceImpl userServiceImpl;
    private UserUtils userUtils;

    @Autowired
    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Autowired
    public void setUserUtils(UserUtils userUtils) {
        this.userUtils = userUtils;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/handle")
    public ModelAndView handleUser(HttpServletRequest request, @RequestParam(value = "login", required = false) Boolean loginFlag) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (loginFlag && !authentication.getPrincipal().toString().equals("anonymousUser")) {
            String ipAddress = request.getRemoteAddr();
            User user = userUtils.getUser();
            Ip ip = new Ip(ipAddress);
            userServiceImpl.handleTransaction(user, ip);
        }
        return new ModelAndView("redirect:" + "/");
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
