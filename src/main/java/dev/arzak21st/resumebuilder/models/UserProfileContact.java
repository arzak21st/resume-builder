package dev.arzak21st.resumebuilder.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_profiles_contacts")
public class UserProfileContact {

    @Id
    private int userId;

    private String email;
    private String phone;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public String toString() {
        return "UserProfileContact{" + "userId=" + userId + ", email=" + email + ", phone=" + phone + '}';
    }
}
