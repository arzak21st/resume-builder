package dev.arzak21st.resumebuilder.services;

import dev.arzak21st.resumebuilder.models.User;
import dev.arzak21st.resumebuilder.models.UserProfile;
import dev.arzak21st.resumebuilder.models.UserProfileEducation;
import dev.arzak21st.resumebuilder.models.UserProfileExperience;
import dev.arzak21st.resumebuilder.models.UserProfileLanguage;
import dev.arzak21st.resumebuilder.models.UserProfileSkill;
import dev.arzak21st.resumebuilder.repositories.UserProfileEducationRepository;
import dev.arzak21st.resumebuilder.repositories.UserProfileExperienceRepository;
import dev.arzak21st.resumebuilder.repositories.UserProfileLanguageRepository;
import dev.arzak21st.resumebuilder.repositories.UserProfileRepository;
import dev.arzak21st.resumebuilder.repositories.UserProfileSkillRepository;
import dev.arzak21st.resumebuilder.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    UserProfileExperienceRepository userProfileExperienceRepository;

    @Autowired
    UserProfileEducationRepository userProfileEducationRepository;

    @Autowired
    UserProfileSkillRepository userProfileSkillRepository;

    @Autowired
    UserProfileLanguageRepository userProfileLanguageRepository;

    public User findUser(String username) {

        System.out.println();
        User user = userRepository.findUserByUsername(username);
        return user;
    }

    public UserProfile findUserProfile(int userId) {

        System.out.println();
        UserProfile userProfile = userProfileRepository.findUserProfileByUserId(userId);
        return userProfile;
    }

    public UserProfile validateUserProfile(UserProfile userProfile) {

        List<UserProfileExperience> userProfileExperiences = userProfile.getUserProfileExperiences();
        if(userProfileExperiences != null) {

            for(int index = 0; index < userProfileExperiences.size(); index++) {

                UserProfileExperience userProfileExperience = userProfileExperiences.get(index);
                if(userProfileExperience.getCompany().equals("") || userProfileExperience.getAddress().equals("") || userProfileExperience.getPosition().equals("") || userProfileExperience.getDescription().equals("")) {
                    userProfileExperiences.remove(userProfileExperiences.get(index));
                }
            }
        }

        List<UserProfileEducation> userProfileEducations = userProfile.getUserProfileEducations();
        if(userProfileEducations != null) {

            for(int index = 0; index < userProfileEducations.size(); index++) {

                UserProfileEducation userProfileEducation = userProfileEducations.get(index);
                if(userProfileEducation.getSchool().equals("") || userProfileEducation.getAddress().equals("") || userProfileEducation.getPosition().equals("") || userProfileEducation.getDescription().equals("")) {
                    userProfileEducations.remove(userProfileEducations.get(index));
                }
            }
        }

        List<UserProfileSkill> userProfileSkills = userProfile.getUserProfileSkills();
        if(userProfileSkills != null) {

            for(int index = 0; index < userProfileSkills.size(); index++) {

                UserProfileSkill userProfileSkill = userProfileSkills.get(index);
                if(userProfileSkill.getSkill().equals("")) {
                    userProfileSkills.remove(userProfileSkills.get(index));
                }
            }
        }

        List<UserProfileLanguage> userProfileLanguages = userProfile.getUserProfileLanguages();
        if(userProfileLanguages != null) {

            for(int index = 0; index < userProfileLanguages.size(); index++) {

                UserProfileLanguage userProfileLanguage = userProfileLanguages.get(index);
                if(userProfileLanguage.getLanguage().equals("")) {
                    userProfileLanguages.remove(userProfileLanguages.get(index));
                }
            }
        }

        UserProfile validatedUserProfile = userProfile;
        return validatedUserProfile;
    }

    public UserProfile updateUserProfile(UserProfile savedUserProfile, UserProfile validatedUserProfile) {

        savedUserProfile.setUserProfileTemplate(validatedUserProfile.getUserProfileTemplate());
        savedUserProfile.setUserProfileSummary(validatedUserProfile.getUserProfileSummary());
        savedUserProfile.setUserProfileContact(validatedUserProfile.getUserProfileContact());
        savedUserProfile.setUserProfileExperiences(validatedUserProfile.getUserProfileExperiences());
        savedUserProfile.setUserProfileEducations(validatedUserProfile.getUserProfileEducations());
        savedUserProfile.setUserProfileSkills(validatedUserProfile.getUserProfileSkills());
        savedUserProfile.setUserProfileLanguages(validatedUserProfile.getUserProfileLanguages());

        validatedUserProfile.getUserProfileTemplate().setUserProfile(savedUserProfile);
        validatedUserProfile.getUserProfileSummary().setUserProfile(savedUserProfile);
        validatedUserProfile.getUserProfileContact().setUserProfile(savedUserProfile);

        validatedUserProfile.getUserProfileExperiences().forEach(experience -> {
            experience.setUserProfile(savedUserProfile);
        });
        validatedUserProfile.getUserProfileEducations().forEach(education -> {
            education.setUserProfile(savedUserProfile);
        });
        validatedUserProfile.getUserProfileSkills().forEach(skill -> {
            skill.setUserProfile(savedUserProfile);
        });
        validatedUserProfile.getUserProfileLanguages().forEach(language -> {
            language.setUserProfile(savedUserProfile);
        });

        UserProfile updatedUserProfile = savedUserProfile;
        return updatedUserProfile;
    }

    public UserProfile saveUserProfile(UserProfile userProfile) {

        System.out.println();
        UserProfile savedUserProfile = userProfileRepository.save(userProfile);
        return savedUserProfile;
    }

    public void removeExperience(int experienceId) {

        System.out.println();
        UserProfileExperience userProfileExperience = userProfileExperienceRepository.findUserProfileExperienceByExperienceId(experienceId);
        if(userProfileExperience != null) {
            userProfileExperienceRepository.delete(userProfileExperience);
        }
    }

    public void removeEducation(int educationId) {

        System.out.println();
        UserProfileEducation userProfileEducation = userProfileEducationRepository.findUserProfileEducationByEducationId(educationId);
        if(userProfileEducation != null) {
            userProfileEducationRepository.delete(userProfileEducation);
        }
    }

    public void removeSkill(int skillId) {

        System.out.println();
        UserProfileSkill userProfileSkill = userProfileSkillRepository.findUserProfileSkillBySkillId(skillId);
        if(userProfileSkill != null) {
            userProfileSkillRepository.delete(userProfileSkill);
        }
    }

    public void removeLanguage(int languageId) {

        System.out.println();
        UserProfileLanguage userProfileLanguage = userProfileLanguageRepository.findUserProfileLanguageByLanguageId(languageId);
        if(userProfileLanguage != null) {
            userProfileLanguageRepository.delete(userProfileLanguage);
        }
    }
}
