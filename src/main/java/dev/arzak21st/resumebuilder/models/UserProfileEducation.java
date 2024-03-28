package dev.arzak21st.resumebuilder.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users_profiles_educations")
public class UserProfileEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int educationId;

    private String school;
    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private String position;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    public int getEducationId() {
        return educationId;
    }

    public void setEducationId(int educationId) {
        this.educationId = educationId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getFormattedStartDate() {
        if(startDate != null) return startDate.format(DateTimeFormatter.ofPattern("MMM yyyy"));
        return "";
    }

    public String getFormattedEndDate() {
        if(endDate != null) return endDate.format(DateTimeFormatter.ofPattern("MMM yyyy"));
        return "";
    }

    @Override
    public String toString() {
        return "UserProfileEducation{" + "educationId=" + educationId + ", school=" + school + ", address=" + address + ", startDate=" + startDate + ", endDate=" + endDate + ", position=" + position + ", description=" + description + '}';
    }
}
