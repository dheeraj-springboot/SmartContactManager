package com.Smartmanager26.SCM2.o.config;

import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.Smartmanager26.SCM2.o.Entities.Providers;
import com.Smartmanager26.SCM2.o.Entities.User;
import com.Smartmanager26.SCM2.o.Repositroes.UserREpo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class OAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(OAuthenticationSuccessHandler.class);

    @Autowired
    private UserREpo userREpo;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        logger.info("Authentication successful for user: {}", authentication.getName());

        //identify the provider
        var oauthproviderman=(OAuth2AuthenticationToken) authentication;
        String authorizationschemeid=oauthproviderman.getAuthorizedClientRegistrationId();
        var oauthuser = (DefaultOAuth2User) authentication.getPrincipal();
        oauthuser.getAttributes().forEach((key,value)->{
            logger.info("{}=>{}",key,value);
        });
        User user1=new User();
        user1.setPhoneNumber("7410258963");
        user1.setUserid(UUID.randomUUID().toString());
        
        if(authorizationschemeid.equalsIgnoreCase("google")){
       
        String email=oauthuser.getAttribute("email").toString();
        String name=oauthuser.getAttribute("name").toString();
        String picture=oauthuser.getAttribute("picture").toString();
        //String phone=user.getAttribute("phone").toString();
       
        user1.setEmail(email);
        user1.setName(name);
        user1.setProfilePic(picture);
        user1.setUserid(authorizationschemeid);
        
        user1.setProvider(Providers.Google);

        }
        else if (authorizationschemeid.equalsIgnoreCase("github")) {
            String email = oauthuser.getAttribute("email") != null ? oauthuser.getAttribute("email").toString()
                    : oauthuser.getAttribute("login").toString() + "@gmail.com";
            String picture = oauthuser.getAttribute("avatar_url").toString();
            String name = oauthuser.getAttribute("login").toString();
            String providerUserId = oauthuser.getName();

            user1.setEmail(email);
            user1.setProfilePic(picture);
            user1.setName(name);
            //user1.setProviderUserId(providerUserId);
            user1.setProvider(Providers.GitHub);

            user1.setAbout("This account is created using github");
        }

        //  You can redirect or send a response after successful login here
        // response.sendRedirect("/homes"); // Example redirectio
        
        //user1.setPhoneNumber(phone);  
        User user2=userREpo.findByemail(user1.getEmail()).orElse(null);
        if(user2==null){
            userREpo.save(user1);
        }

        new DefaultRedirectStrategy().sendRedirect(request, response, "/user/profile");
    }
}
