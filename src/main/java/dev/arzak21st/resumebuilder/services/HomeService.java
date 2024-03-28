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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    UserRepository userRepository;

    public void registerDefaultUser(String username, String password, String firstName, String lastName) {

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

            // UserProfileTemplate
            UserProfileTemplate userProfileTemplate = new UserProfileTemplate();
            userProfileTemplate.setTemplate("template_1");
            userProfileTemplate.setUserProfile(userProfile);
            userProfile.setUserProfileTemplate(userProfileTemplate);

            // UserProfileSummary
            UserProfileSummary userProfileSummary = new UserProfileSummary();
            userProfileSummary.setFirstName(firstName);
            userProfileSummary.setLastName(lastName);
            userProfileSummary.setTitle("Java Developer");
            userProfileSummary.setDescription("I am a Java developer with more than 3 years of experience building Java web applications.");
            userProfileSummary.setUserProfile(userProfile);
            userProfile.setUserProfileSummary(userProfileSummary);

            // UserProfileContact
            UserProfileContact userProfileContact = new UserProfileContact();
            userProfileContact.setEmail(username + "@gmail.com");
            userProfileContact.setPhone("+212 614 124 869");
            userProfileContact.setUserProfile(userProfile);
            userProfile.setUserProfileContact(userProfileContact);

            // UserProfileExperiences
            UserProfileExperience userProfileExperience1 = new UserProfileExperience();
            userProfileExperience1.setCompany("Google");
            userProfileExperience1.setAddress("1440 Broadway, 21st floor New York, NY 10018");
            userProfileExperience1.setStartDate(LocalDate.parse("2021-05-01"));
            userProfileExperience1.setEndDate(LocalDate.parse("2021-12-01"));
            userProfileExperience1.setPosition("Java Developer");
            userProfileExperience1.setDescription("I have done this, and that, and these, and those");
            userProfileExperience1.setUserProfile(userProfile);

            UserProfileExperience userProfileExperience2 = new UserProfileExperience();
            userProfileExperience2.setCompany("Amazon");
            userProfileExperience2.setAddress("410 Terry Ave N, Seattle 98109, WA");
            userProfileExperience2.setStartDate(LocalDate.parse("2022-05-01"));
            userProfileExperience2.setEndDate(LocalDate.parse("2022-12-01"));
            userProfileExperience2.setPosition("Java Developer");
            userProfileExperience2.setDescription("I have done this, and that, and these, and those");
            userProfileExperience2.setUserProfile(userProfile);

            List<UserProfileExperience> userProfileExperiences = new ArrayList<>();
            userProfileExperiences.add(userProfileExperience1);
            userProfileExperiences.add(userProfileExperience2);
            userProfile.setUserProfileExperiences(userProfileExperiences);

            // UserProfileEducations
            UserProfileEducation userProfileEducation1 = new UserProfileEducation();
            userProfileEducation1.setSchool("ISTA NTIC 2");
            userProfileEducation1.setAddress("SIDI-MAAROUF CASABLANCA");
            userProfileEducation1.setStartDate(LocalDate.parse("2018-09-01"));
            userProfileEducation1.setEndDate(LocalDate.parse("2020-06-01"));
            userProfileEducation1.setPosition("Student");
            userProfileEducation1.setDescription("I have learned this, and that, and these, and those");
            userProfileEducation1.setUserProfile(userProfile);

            UserProfileEducation userProfileEducation2 = new UserProfileEducation();
            userProfileEducation2.setSchool("HASSAN 2 Heigh school");
            userProfileEducation2.setAddress("EL-WAFAE DEROUA");
            userProfileEducation2.setStartDate(LocalDate.parse("2016-09-01"));
            userProfileEducation2.setEndDate(LocalDate.parse("2018-06-01"));
            userProfileEducation2.setPosition("Student");
            userProfileEducation2.setDescription("I have learned this, and that, and these, and those");
            userProfileEducation2.setUserProfile(userProfile);

            List<UserProfileEducation> userProfileEducations = new ArrayList<>();
            userProfileEducations.add(userProfileEducation1);
            userProfileEducations.add(userProfileEducation2);
            userProfile.setUserProfileEducations(userProfileEducations);

            // UserProfileSkills
            UserProfileSkill userProfileSkill1 = new UserProfileSkill();
            userProfileSkill1.setSkill("Java");
            userProfileSkill1.setLevel("GOD TIER");
            userProfileSkill1.setUserProfile(userProfile);

            UserProfileSkill userProfileSkill2 = new UserProfileSkill();
            userProfileSkill2.setSkill("Spring");
            userProfileSkill2.setLevel("Senior");
            userProfileSkill2.setUserProfile(userProfile);

            List<UserProfileSkill> userProfileSkills = new ArrayList<>();
            userProfileSkills.add(userProfileSkill1);
            userProfileSkills.add(userProfileSkill2);
            userProfile.setUserProfileSkills(userProfileSkills);

            // UserProfileLanguages
            UserProfileLanguage userProfileLanguage1 = new UserProfileLanguage();
            userProfileLanguage1.setLanguage("English");
            userProfileLanguage1.setLevel("B1");
            userProfileLanguage1.setUserProfile(userProfile);

            UserProfileLanguage userProfileLanguage2 = new UserProfileLanguage();
            userProfileLanguage2.setLanguage("Japanese");
            userProfileLanguage2.setLevel("C2");
            userProfileLanguage2.setUserProfile(userProfile);

            List<UserProfileLanguage> userProfileLanguages = new ArrayList<>();
            userProfileLanguages.add(userProfileLanguage1);
            userProfileLanguages.add(userProfileLanguage2);
            userProfile.setUserProfileLanguages(userProfileLanguages);

            user.setUserProfile(userProfile);

            System.out.println();
            userRepository.save(user);
        }
    }
}
