package org.projekt3_gruppe_3.controller;



import org.projekt3_gruppe_3.model.User;
import org.projekt3_gruppe_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("opretUser")
    public String cCreateUser(@RequestParam("username")String username,
                              @RequestParam("password")String password,
                              @RequestParam("sysRole")String sysRole){
        userService.sCreateUser(username, password, sysRole);

//        User user = new User(username, password, sysRole);
//        userService.sCreateUser(user);
        return "redirect:/userpage";
    }
}
