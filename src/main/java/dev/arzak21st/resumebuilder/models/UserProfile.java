package dev.arzak21st.resumebuilder.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_profiles")
public class UserProfile {

    @Id
    private int userId;

    @OneToOne
    @JoinColumn(name = "user_id")
    @MapsId // Tells Hibernate to use the Id (userId) as both the primary key and the foreign key
    private User user;

    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private UserProfileTemplate userProfileTemplate;

    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private UserProfileSummary userProfileSummary;

    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private UserProfileContact userProfileContact;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private List<UserProfileExperience> userProfileExperiences;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private List<UserProfileEducation> userProfileEducations;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private List<UserProfileSkill> userProfileSkills;

    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private List<UserProfileLanguage> userProfileLanguages;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserProfileTemplate getUserProfileTemplate() {
        return userProfileTemplate;
    }

    public void setUserProfileTemplate(UserProfileTemplate userProfileTemplate) {
        this.userProfileTemplate = userProfileTemplate;
    }

    public UserProfileSummary getUserProfileSummary() {
        return userProfileSummary;
    }

    public void setUserProfileSummary(UserProfileSummary userProfileSummary) {
        this.userProfileSummary = userProfileSummary;
    }

    public UserProfileContact getUserProfileContact() {
        return userProfileContact;
    }

    public void setUserProfileContact(UserProfileContact userProfileContact) {
        this.userProfileContact = userProfileContact;
    }

    public List<UserProfileExperience> getUserProfileExperiences() {
        return userProfileExperiences;
    }

    public void setUserProfileExperiences(List<UserProfileExperience> userProfileExperiences) {
        this.userProfileExperiences = userProfileExperiences;
    }

    public List<UserProfileEducation> getUserProfileEducations() {
        return userProfileEducations;
    }

    public void setUserProfileEducations(List<UserProfileEducation> userProfileEducations) {
        this.userProfileEducations = userProfileEducations;
    }

    public List<UserProfileSkill> getUserProfileSkills() {
        return userProfileSkills;
    }

    public void setUserProfileSkills(List<UserProfileSkill> userProfileSkills) {
        this.userProfileSkills = userProfileSkills;
    }

    public List<UserProfileLanguage> getUserProfileLanguages() {
        return userProfileLanguages;
    }

    public void setUserProfileLanguages(List<UserProfileLanguage> userProfileLanguages) {
        this.userProfileLanguages = userProfileLanguages;
    }

    @Override
    public String toString() {
        return "UserProfile{" + "userId=" + userId + ", user=" + user + ", userProfileTemplate=" + userProfileTemplate + ", userProfileSummary=" + userProfileSummary + ", userProfileContact=" + userProfileContact + ", userProfileExperiences=" + userProfileExperiences + ", userProfileEducations=" + userProfileEducations + ", userProfileSkills=" + userProfileSkills + ", userProfileLanguages=" + userProfileLanguages + '}';
    }
}
