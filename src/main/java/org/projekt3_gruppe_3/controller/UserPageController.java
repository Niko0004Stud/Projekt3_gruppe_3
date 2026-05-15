package org.projekt3_gruppe_3.controller;

import jakarta.servlet.http.HttpSession;
import org.projekt3_gruppe_3.model.SuperUser;
import org.projekt3_gruppe_3.model.User;
import org.projekt3_gruppe_3.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;


@Controller
public class UserPageController {

    private final UserService userService;

    public UserPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getCreatePage")
    public String cGetCreatePage(@RequestParam("opretPageType") String opretPageType, Model model){
        model.addAttribute("opretPageType", opretPageType);

        return "opretPage";
    }

//    @GetMapping("getUserPageData")
//    public String cGetUserPage(HttpSession session, Model model){
//        User user = (User) session.getAttribute("user");
//
//        userService.getUserPageData(user, model);
//        model.addAttribute("user",user);
//
//        return "userPage";
//    }
}
