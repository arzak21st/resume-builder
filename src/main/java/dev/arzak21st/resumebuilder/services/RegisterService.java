
package dev.arzak21st.resumebuilder.services;

import dev.arzak21st.resumebuilder.models.User;
import dev.arzak21st.resumebuilder.models.UserProfile;
import dev.arzak21st.resumebuilder.models.UserProfileContact;
import dev.arzak21st.resumebuilder.models.UserProfileEducation;
import dev.arzak21st.resumebuilder.models.UserProfileExperience;
import dev.arzak21st.resumebuilder.models.UserProfileLanguage;
import dev.arzak21st.resumebuilder.models.UserProfileSkill;
import dev.arzak21st.resumebuilder.models.UserProfileSummary;
import dev.arzak21st.resumebuilder.models.UserProfileTemplate;
import dev.arzak21st.resumebuilder.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    UserRepository userRepository;

    public User registerUser(String username, String password, String firstName, String lastName) {

        System.out.println();
        User savedUser = userRepository.findUserByUsername(username);
        if(savedUser == null) {

            // User
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setActive(true);
            user.setAuthority("ROLE_USER");

            // UserProfile
            UserProfile userProfile = new UserProfile();
            userProfile.setUser(user);
            user.setUserProfile(userProfile);

            // UserProfileTemplate
            UserProfileTemplate userProfileTemplate = new UserProfileTemplate();
            userProfileTemplate.setTemplate("template_1");
            userProfileTemplate.setUserProfile(userProfile);
            userProfile.setUserProfileTemplate(userProfileTemplate);

            // UserProfileSummary
            UserProfileSummary userProfileSummary = new UserProfileSummary();
            userProfileSummary.setFirstName(firstName);
            userProfileSummary.setLastName(lastName);
            userProfileSummary.setTitle("");
            userProfileSummary.setDescription("");
            userProfileSummary.setUserProfile(userProfile);
            userProfile.setUserProfileSummary(userProfileSummary);

            // UserProfileContact
            UserProfileContact userProfileContact = new UserProfileContact();
            userProfileContact.setEmail("");
            userProfileContact.setPhone("");
            userProfileContact.setUserProfile(userProfile);
            userProfile.setUserProfileContact(userProfileContact);

            // UserProfileExperiences
            List<UserProfileExperience> userProfileExperiences = new ArrayList<>();
            userProfile.setUserProfileExperiences(userProfileExperiences);

            // UserProfileEducations
            List<UserProfileEducation> userProfileEducations = new ArrayList<>();
            userProfile.setUserProfileEducations(userProfileEducations);

            // UserProfileSkills
            List<UserProfileSkill> userProfileSkills = new ArrayList<>();
            userProfile.setUserProfileSkills(userProfileSkills);

            // UserProfileLanguages
            List<UserProfileLanguage> userProfileLanguages = new ArrayList<>();
            userProfile.setUserProfileLanguages(userProfileLanguages);

            System.out.println();
            return userRepository.save(user);
        }

        return null;
    }
}
