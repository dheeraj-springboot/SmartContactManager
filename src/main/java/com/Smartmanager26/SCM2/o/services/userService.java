package com.Smartmanager26.SCM2.o.services;

import java.util.Optional;
import java.util.List;
//import com.Smartmanager26.SCM2.o.Entities.List;
import com.Smartmanager26.SCM2.o.Entities.User;

public interface userService {
    User saveUser(User user);
    User getuserbyid(String id);
    Optional<User> Updateuser(User user);
    void deleteUser(String id);
    boolean isUserExist(String userid);
    List<User> getalluser();
    User getuserbyemail(String email);


}
