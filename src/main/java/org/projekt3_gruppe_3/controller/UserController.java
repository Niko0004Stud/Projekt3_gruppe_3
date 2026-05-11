package org.projekt3_gruppe_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @PostMapping("opretBruger")
    public String cCreateUser(@RequestParam("username")String username,
                              @RequestParam("password")String password,
                              @RequestParam("sysRole")String sysRole){

        return "redirect:/userpage";
    }
}
