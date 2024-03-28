package dev.arzak21st.resumebuilder.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_profiles_summaries")
public class UserProfileSummary {

    @Id
    private int userId;

    private String firstName;
    private String lastName;
    private String title;
    private String description;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public String toString() {
        return "UserProfileSummary{" + "userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title + ", description=" + description + '}';
    }
}
