package dev.arzak21st.resumebuilder.controllers;

import dev.arzak21st.resumebuilder.models.User;
import dev.arzak21st.resumebuilder.services.RegisterService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @GetMapping("/register")
    public String getRegister() {

        System.out.println();
        System.out.println(" ========== getRegister() ========== ");

        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@RequestParam Map<String, String> formData, Model model) {

        System.out.println();
        System.out.println(" ========== postRegister() ========== ");

        String username = formData.get("username");
        String password = formData.get("password");
        String firstName = formData.get("firstName");
        String lastName = formData.get("lastName");

        System.out.println(username + " " + password + " " + firstName + " " + lastName);

        User user = registerService.registerUser(username, password, firstName, lastName);
        if(user != null) {
            model.addAttribute("registered", user);
        }
        else{
            model.addAttribute("duplicated", username);
        }

        return "register";
    }
}
