package org.projekt3_gruppe_3.service;

import org.projekt3_gruppe_3.model.User;
import org.projekt3_gruppe_3.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public void sCreateUser(User user){
        userRepo.rCreateUser(user);
    }
}
