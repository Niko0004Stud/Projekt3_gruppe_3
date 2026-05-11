package org.projekt3_gruppe_3.controller;

import jakarta.servlet.http.HttpSession;
import org.projekt3_gruppe_3.model.SuperUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserPageController {

    @GetMapping("/userpage")
    public String cUserpage(HttpSession session){
        //Hvad er der med den her?
        //SuperUser user = (SuperUser) session.getAttribute("user");

        return "userpage";
    }

    @GetMapping("/getCreatePage")
    public String cGetCreatePage(@RequestParam("opretPageType") String opretPageType){

        return "/opretPage";
    }
}
