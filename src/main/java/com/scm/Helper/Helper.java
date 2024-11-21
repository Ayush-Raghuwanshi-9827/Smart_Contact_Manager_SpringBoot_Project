package com.scm.Helper;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.security.Principal;

public class Helper {

    public static String getEmailOfLoggedInUser(Authentication authentication){

        if (authentication instanceof OAuth2AuthenticationToken){
            //          singin with github
            //          singin with github with google

            var aOAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
            var clientId = aOAuth2AuthenticationToken.getAuthorizedClientRegistrationId();
            var aoauth2User = (OAuth2User) authentication.getPrincipal();
            String username = "";

           if (clientId.equalsIgnoreCase("google")){
               username = aoauth2User.getAttribute("email").toString();

           }else if (clientId.equalsIgnoreCase("github")){
               username = aoauth2User.getAttribute("email") != null ? aoauth2User.getAttribute("email").toString() : aoauth2User.getAttribute("login").toString()+"@gmail.com";
           }
           return username;

        }else {
            //        Login by email password
            return authentication.getName();
        }
    }
}
