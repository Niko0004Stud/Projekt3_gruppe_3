package org.projekt3_gruppe_3.service;

import org.projekt3_gruppe_3.model.User;
import org.projekt3_gruppe_3.repository.BilRepo;
import org.projekt3_gruppe_3.repository.LejeaftaleRepo;
import org.projekt3_gruppe_3.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    BilRepo bilRepo;
    @Autowired
    LejeaftaleRepo lejeaftaleRepo;

    public void sCreateUser(String username, String password, String sysRole){

        userRepo.rCreateUser(new User(username, password, sysRole));
    }
// getdata lavet af sebastian
    public void getUserPageData(User user, Model model){
        System.out.println(bilRepo.getAll());
        switch(user.getSysRole()){
            case "admin":
                model.addAttribute("biler",bilRepo.getAll());
                model.addAttribute("lejeaftaler",lejeaftaleRepo.readAllLejeaftaler());
                model.addAttribute("users", userRepo.getAll());

                break;

            case "dataregistrerer":
                model.addAttribute("biler", bilRepo.getAll());
                model.addAttribute("lejeaftaler", lejeaftaleRepo.readAllLejeaftaler());
                //der skal laves en specific get på biler med specifik status

                break;

            case "forretningsudvikler":
                model.addAttribute("biler", bilRepo.getAll());
                model.addAttribute("lejeaftaler", lejeaftaleRepo.readAllLejeaftaler());
                //der skal laves en specific get på biler med specifik status -
                // og en specifik attribut.

                break;

            case "biltech":
                    //der skal laves en specific get på biler med specifik status

        }
    }
}
