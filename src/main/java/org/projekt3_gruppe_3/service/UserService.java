package org.projekt3_gruppe_3.service;

import org.projekt3_gruppe_3.model.SuperUser;
import org.projekt3_gruppe_3.model.User;
import org.projekt3_gruppe_3.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public void sCreateUser(String username, String password, String sysRole){

        userRepo.rCreateUser(new User(username, password, sysRole));
    }
}
