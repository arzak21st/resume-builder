package dev.arzak21st.resumebuilder.controllers;

import dev.arzak21st.resumebuilder.services.HomeService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping(path = {"/", "/home"})
    public String getHome(Principal principal, Model model) {

        System.out.println();
        System.out.println(" ========== getHome() ========== ");

        String username = "user";
        String password = "4869";
        String firstName = "Wassim";
        String lastName = "Arzak";
        homeService.registerDefaultUser(username, password, firstName, lastName);

        if(principal != null) {
            model.addAttribute("principal", principal);
        }

        return "home";
    }
}
