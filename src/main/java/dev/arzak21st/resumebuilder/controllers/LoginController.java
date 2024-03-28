package dev.arzak21st.resumebuilder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin() {

        System.out.println();
        System.out.println(" ========== getLogin() ========== ");

        return "login";
    }
}
