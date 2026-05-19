package org.projekt3_gruppe_3.service;

import jakarta.servlet.http.HttpSession;
import org.projekt3_gruppe_3.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginRepo loginRepo;

    public String sTryLogin(String username, String password, HttpSession session){
        if(loginRepo.rTryLogin(username, password)!=null){
            session.setAttribute("user", loginRepo.rTryLogin(username, password));
            return "redirect:/getUserPageData";
        }
        return "redirect:/";
    }
}
