package dev.arzak21st.resumebuilder.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_profiles_templates")
public class UserProfileTemplate {

    @Id
    private int userId;

    private String template;

    @OneToOne
    @JoinColumn(name = "user_id")
    @MapsId // Tells Hibernate to use the Id (userId) as both the primary key and the foreign key
    private UserProfile userProfile;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public String toString() {
        return "UserProfileTemplate{" + "userId=" + userId + ", template=" + template + '}';
    }
}
