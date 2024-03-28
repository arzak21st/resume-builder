package dev.arzak21st.resumebuilder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_profiles_skills")
public class UserProfileSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int skillId;
    private String skill;
    private String level;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
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
        return "UserProfileSkill{" + "skillId=" + skillId + ", skill=" + skill + ", level=" + level + '}';
    }
}
