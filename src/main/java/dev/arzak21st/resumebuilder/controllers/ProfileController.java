package dev.arzak21st.resumebuilder.controllers;

import dev.arzak21st.resumebuilder.models.User;
import dev.arzak21st.resumebuilder.models.UserProfile;
import dev.arzak21st.resumebuilder.models.UserProfileEducation;
import dev.arzak21st.resumebuilder.models.UserProfileExperience;
import dev.arzak21st.resumebuilder.models.UserProfileLanguage;
import dev.arzak21st.resumebuilder.models.UserProfileSkill;
import dev.arzak21st.resumebuilder.services.ProfileService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/profile")
    public String getProfile(Principal principal, Model model) {

        System.out.println();
        System.out.println(" ========== getProfile() ========== ");

        String username = principal.getName();
        User user = profileService.findUser(username);
        if(user != null) {

            UserProfile userProfile = user.getUserProfile();
            userProfile.getUserProfileExperiences().add(new UserProfileExperience());
            userProfile.getUserProfileEducations().add(new UserProfileEducation());
            userProfile.getUserProfileSkills().add(new UserProfileSkill());
            userProfile.getUserProfileLanguages().add(new UserProfileLanguage());

            /*
            Adding a new empty object for each of the above lists is needed
            so that there always an empty row for adding
             */

            model.addAttribute("userProfile", userProfile);
        }

        return "profile";
    }

    @PostMapping("/save")
    public String saveProfile(@ModelAttribute UserProfile userProfile) {

        System.out.println();
        System.out.println(" ========== saveProfile() ========== ");

        System.out.println();
        UserProfile validatedUserProfile = profileService.validateUserProfile(userProfile);
        UserProfile savedUserProfile = profileService.findUserProfile(validatedUserProfile.getUserId());
        UserProfile updatedUserProfile = null;
        if(savedUserProfile != null) {
            updatedUserProfile = profileService.updateUserProfile(savedUserProfile, validatedUserProfile);
        }

        profileService.saveUserProfile(updatedUserProfile);

        return "redirect:/profile";
    }

    @GetMapping("/remove/experience/{experienceId}")
    public String removeProfileExperience(@PathVariable int experienceId) {

        System.out.println();
        System.out.println(" ========== removeExperience() ========== ");

        profileService.removeExperience(experienceId);

        return "redirect:/profile";
    }

    @GetMapping("/remove/education/{educationId}")
    public String removeProfileEducation(@PathVariable int educationId) {

        System.out.println();
        System.out.println(" ========== removeEducation() ========== ");

        profileService.removeEducation(educationId);

        return "redirect:/profile";
    }

    @GetMapping("/remove/skill/{skillId}")
    public String removeProfileSkill(@PathVariable int skillId) {

        System.out.println();
        System.out.println(" ========== removeSkill() ========== ");

        profileService.removeSkill(skillId);

        return "redirect:/profile";
    }

    @GetMapping("/remove/language/{languageId}")
    public String removeProfileLanguage(@PathVariable int languageId) {

        System.out.println();
        System.out.println(" ========== removeLanguage() ========== ");

        profileService.removeLanguage(languageId);

        return "redirect:/profile";
    }
}
