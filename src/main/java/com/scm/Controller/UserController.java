package com.scm.Controller;

import com.scm.Helper.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {


    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/dashboard")
    public String userDashboard(){
        return "user/dashboard";
    }


    @GetMapping("/profile")
    public String userProfile(Authentication authentication){
        String username = Helper.getEmailOfLoggedInUser(authentication);
        logger.info("User Logged In : " + username);
        return "user/profile";
    }

}
