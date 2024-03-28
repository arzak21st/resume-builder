
package dev.arzak21st.resumebuilder.repositories;

import dev.arzak21st.resumebuilder.models.UserProfile;
import dev.arzak21st.resumebuilder.models.UserProfileEducation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileEducationRepository extends JpaRepository<UserProfileEducation, Integer>{

    UserProfileEducation findUserProfileEducationByEducationId(int educationId);
    List<UserProfileEducation> findUserProfileEducationsByUserProfile(UserProfile userProfile);
}
