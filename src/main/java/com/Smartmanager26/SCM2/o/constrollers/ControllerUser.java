package com.Smartmanager26.SCM2.o.constrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.Smartmanager26.SCM2.o.Entities.User;
import com.Smartmanager26.SCM2.o.Helpers.Helper;
import com.Smartmanager26.SCM2.o.services.userService;

@ControllerAdvice
public class ControllerUser {
    @Autowired
    private userService userserviceman;
    @ModelAttribute
    public void AddLoggedinUser(Model model, Authentication authen){
        if(authen == null){
            return ;

        }
         String name= Helper.getEmailOfLoggedinUser(authen);
        System.out.println(name);
        User userman=userserviceman.getuserbyemail(name);
        System.out.println("svkjfbvkjbfxvkjsfkvjfxkjvksfjxnvkjsfxbkvj,sfkvkv      "+userman.getName());
        model.addAttribute("loggedInUser", userman);


    }

}
