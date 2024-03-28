
package dev.arzak21st.resumebuilder.repositories;

import dev.arzak21st.resumebuilder.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer>{

    UserProfile findUserProfileByUserId(int userId);
}
