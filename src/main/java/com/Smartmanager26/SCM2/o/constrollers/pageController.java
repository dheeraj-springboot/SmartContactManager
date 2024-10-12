package com.Smartmanager26.SCM2.o.constrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Smartmanager26.SCM2.o.Entities.User;
import com.Smartmanager26.SCM2.o.forms.UserForm;
import com.Smartmanager26.SCM2.o.services.userService;


import jakarta.validation.Valid;







@Controller
public class pageController {
    @Autowired
    private userService userservicepage;

    @RequestMapping("/homes")
    public String home(Model model){
        model.addAttribute("home","Dheeraj is here !");
        System.out.println("Home page handler");
        return "home";
    }  
    @RequestMapping("/about")
    public String aboutPageString() {
        return "Form";
    }
    
    @RequestMapping("/service")
    public String ServiceMapping() {
        return "services";
    }
    @RequestMapping("/contact")
    public String contactManager() {
        return "contact";
    }

    @RequestMapping("/login")
    public String Login() {
        return "Login";
    }
    @RequestMapping("/register")
    public String Registering(Model model) {
        UserForm userForm=new UserForm();
        //userForm.setName("Dheeraj");
       // userForm.setPhoneNumber("70023");

        model.addAttribute("username", userForm);
        return "register";

    }
    //proccessiong register 
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String ProcessingRegistor(
        @Valid @ModelAttribute("username") UserForm userMan, // Ensure model attribute name matches the form binding in Thymeleaf
        BindingResult rbinding,
        Model model // Inject Model to pass back the UserForm object if there are errors
    ) {
        // Debugging the submitted user form data
        System.out.println(userMan);
    
        // Check for validation errors
        if (rbinding.hasErrors()) {
            // Re-add the UserForm object to the model so Thymeleaf can re-render the form
            model.addAttribute("username", userMan);
            return "register"; // Return back to the registration page if errors exist
        }
    
        // Process the form data when there are no validation errors
        User user = new User();
        user.setName(userMan.getName());
        user.setAbout(userMan.getAbout());
        user.setEmail(userMan.getEmail());
        user.setPassword(userMan.getPassword());
        user.setPhoneNumber(userMan.getPhoneNumber());
    
        // Save the user data to the database using the service
        userservicepage.saveUser(user);
    
        // Return the success message page
        return "message";
    }
    
  


}
