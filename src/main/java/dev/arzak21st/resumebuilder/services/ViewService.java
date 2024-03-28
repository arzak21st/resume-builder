package dev.arzak21st.resumebuilder.services;

import dev.arzak21st.resumebuilder.models.User;
import dev.arzak21st.resumebuilder.models.UserProfile;
import dev.arzak21st.resumebuilder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewService {

    @Autowired
    UserRepository userRepository;

    public String findDefaultTemplate() {

        String defaultTemplate = "template_1";
        return defaultTemplate;
    }

    public UserProfile findUserProfile(String username) {

        UserProfile userProfile = null;

        System.out.println();
        User user = userRepository.findUserByUsername(username);
        if(user != null) {
            userProfile = user.getUserProfile();
        }

        return userProfile;
    }

}
