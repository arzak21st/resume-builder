
package dev.arzak21st.resumebuilder.repositories;

import dev.arzak21st.resumebuilder.models.UserProfile;
import dev.arzak21st.resumebuilder.models.UserProfileExperience;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileExperienceRepository extends JpaRepository<UserProfileExperience, Integer>{

    UserProfileExperience findUserProfileExperienceByExperienceId(int experienceId);
    List<UserProfileExperience> findUserProfileExperiencesByUserProfile(UserProfile userProfile);
}
