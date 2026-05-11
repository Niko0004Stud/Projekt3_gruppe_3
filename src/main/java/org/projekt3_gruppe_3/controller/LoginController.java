package org.projekt3_gruppe_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/tryLogin")
    public String tryLogin(@RequestParam("username") String username,
                           @RequestParam("password") String password){



        return "redirect:/userpage";
    }
}
