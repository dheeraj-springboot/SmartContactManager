package com.Smartmanager26.SCM2.o.constrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user/contact")
public class ContactController {
    //add contact page:handler
    @RequestMapping("/add") 
    public String addContactview(){
        return "user/add-contact";
    }

}
