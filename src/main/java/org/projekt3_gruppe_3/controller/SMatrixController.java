package org.projekt3_gruppe_3.controller;

import jakarta.servlet.http.HttpSession;
import org.projekt3_gruppe_3.model.SkadeMatrix;
import org.projekt3_gruppe_3.model.User;
import org.projekt3_gruppe_3.repository.BilRepo;
import org.projekt3_gruppe_3.repository.SMatrixRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

//estera
@Controller
public class SMatrixController {

    @Autowired
    SMatrixRepo sMatrixRepo;

    @Autowired
    BilRepo bilrepo;

//    @GetMapping("/getAllSkader")
//    public String getAll(Model model){
//        model.addAttribute("skade", skadeRepo.getAll());
//        System.out.println(skadeRepo.getAll());
//        return "redirect:/userpage";
//    }

    @GetMapping("/oversigtPage")
    public String cGetOversigtPage(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "redirect:/getUserPageData";
    }
    @PostMapping("/opretSkadeMatrix")
    public String cCreateSkadeMatrix(
            @RequestParam("bilId") int bilId,
            @RequestParam("omkostninger") double omkostninger,
            @RequestParam("registreringsDate")LocalDate registreringsDate,
            Model model){
        SkadeMatrix skadeMatrix = new SkadeMatrix();
        skadeMatrix.setBilId(bilId);
        skadeMatrix.setOmkostninger(omkostninger);
        skadeMatrix.setRegistreringsDate(registreringsDate);

        sMatrixRepo.create(skadeMatrix);
        bilrepo.updateStatusBil(bilId, "salgsKlar");


        return "redirect:/oversigtPage";
    }
}
