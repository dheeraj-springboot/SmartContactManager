package com.Smartmanager26.SCM2.o.Helpers;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

public class Helper {

    public static String getEmailOfLoggedinUser(Authentication authen) {
        if (authen instanceof OAuth2AuthenticationToken) {
            var oauthproviderman = (OAuth2AuthenticationToken) authen;
            String authorizationschemeid = oauthproviderman.getAuthorizedClientRegistrationId();
            var oauthuser = (DefaultOAuth2User) authen.getPrincipal();
            String username = "";

            if (authorizationschemeid.equalsIgnoreCase("google")) {  // Fixed missing parentheses here
                System.out.println("Getting From google");
                username = oauthuser.getAttribute("email").toString();
            } else if (authorizationschemeid.equalsIgnoreCase("github")) {  // Fixed missing parentheses here
                System.out.println("Getting email from github");
                username = oauthuser.getAttribute("email") != null ? oauthuser.getAttribute("email").toString()
                        : oauthuser.getAttribute("login").toString() + "@gmail.com";
            }
            System.out.println("d,fxdbbscvb sjhbsbh     "+username);
            return username;
        } else {
            return authen.getName();
        }
    }
}
