package dev.arzak21st.resumebuilder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_profiles_languages")
public class UserProfileLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int languageId;
    private String language;
    private String level;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public String toString() {
        return "UserProfileLanguage{" + "languageId=" + languageId + ", language=" + language + ", level=" + level + '}';
    }
}
