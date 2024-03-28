
package dev.arzak21st.resumebuilder.repositories;

import dev.arzak21st.resumebuilder.models.UserProfile;
import dev.arzak21st.resumebuilder.models.UserProfileSkill;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileSkillRepository extends JpaRepository<UserProfileSkill, Integer>{

    UserProfileSkill findUserProfileSkillBySkillId(int skillId);
    List<UserProfileSkill> findUserProfileSkillsByUserProfile(UserProfile userProfile);
}
