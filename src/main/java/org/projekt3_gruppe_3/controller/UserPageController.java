package org.projekt3_gruppe_3.controller;

import jakarta.servlet.http.HttpSession;
import org.projekt3_gruppe_3.model.SuperUser;
import org.projekt3_gruppe_3.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserPageController {

    @GetMapping("/userpage")
    public String cUserpage(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);

        return "userpage";
    }

    @GetMapping("/getCreatePage")
    public String cGetCreatePage(@RequestParam("opretPageType") String opretPageType, Model model){
        model.addAttribute("opretPageType", opretPageType);

        return "opretPage";
    }

    @GetMapping("/getOverviewPage")
    public String cGetOverviewPage(@RequestParam("oversigtPageType") String oversigtPageType, Model model){

        return "oversigtPage";
    }
}
