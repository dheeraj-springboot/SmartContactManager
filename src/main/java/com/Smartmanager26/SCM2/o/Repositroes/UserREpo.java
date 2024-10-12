package com.Smartmanager26.SCM2.o.Repositroes;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Smartmanager26.SCM2.o.Entities.User;


@Repository
public interface UserREpo extends JpaRepository<User,String> {
    //extra method db relate operations 
    //custom query methods
    //custom finder methods
    Optional <User> findByemail(String email);
    


}
