package dev.arzak21st.resumebuilder.controllers;

import dev.arzak21st.resumebuilder.models.UserProfile;
import dev.arzak21st.resumebuilder.services.ViewService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {

    @Autowired
    ViewService viewService;

    @GetMapping("/view/{username}")
    public String getView(@PathVariable String username, Principal principal, Model model) {

        System.out.println();
        System.out.println(" ========== view() ========== ");

        String template = "template_1";

        UserProfile userProfile = viewService.findUserProfile(username);
        if(userProfile != null) {

            System.out.println(userProfile);

            model.addAttribute("userProfile", userProfile);
            model.addAttribute("principal", principal);

            template = userProfile.getUserProfileTemplate().getTemplate();
        }
        else {
            return "redirect:/home";
        }

        return template + "/view";
    }
}
