package com.Smartmanager26.SCM2.o.constrollers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class usercontroller {

    @RequestMapping("/dashbord")
    public String userDash(){
        return"user/dashbord";
    }
    @RequestMapping("/profile")
    public String profilesa(Model model,Authentication authen ){

        // String name=prince.getName();
      
        return"user/profile";
    }

}
