package com.Smartmanager26.SCM2.o.services.impl;

import java.util.Optional;
import java.util.UUID;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.Smartmanager26.SCM2.o.Entities.List;
import com.Smartmanager26.SCM2.o.Entities.User;
import com.Smartmanager26.SCM2.o.Helpers.AppConstants;
import com.Smartmanager26.SCM2.o.Repositroes.UserREpo;
import com.Smartmanager26.SCM2.o.services.userService;

@Service
public class UserServiceImpl implements userService {

    @Autowired
    private UserREpo userreposi;
    @Autowired
    private PasswordEncoder passwordboya;
    
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        logger.info("Saving user: {}", user);
        String userid=UUID.randomUUID().toString();
        user.setUserid(userid);
        user.setPassword(passwordboya.encode(user.getPassword()));
        //set the user role

        user.setRolelist(List.of(AppConstants.ROLE_USER));
        return userreposi.save(user);
    }

    @Override
    public User getuserbyid(String id) {
        logger.info("Fetching user by ID: {}", id);
        return userreposi.findById(id).orElse(null);
    }

    @Override
    public Optional<User> Updateuser(User user) {
        logger.info("Updating user: {}", user);
        User user2 = userreposi.findById(user.getUserid()).orElseThrow(()->new ResosourceNotFound("usernot found"));
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        User save= userreposi.save(user2);
        return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String id) {
        logger.info("Deleting user with ID: {}", id);
        userreposi.deleteById(id);
    }

    @Override
    public boolean isUserExist(String userid) {
        logger.info("Checking if user exists: {}", userid);
        return userreposi.existsById(userid);
    }

    @Override
    public List<User> getalluser() {
        logger.info("Fetching all users");
        return (List<User>) userreposi.findAll();
    }

    @Override
    public User getuserbyemail(String email) {
        // TODO Auto-generated method stub
        System.out.println("Dheeraj boy is it hard         "+userreposi.findByemail(email));
        return userreposi.findByemail(email).orElse(null);
        //throw new UnsupportedOperationException("Unimplemented method 'getuserbyemail'");
    }
}
