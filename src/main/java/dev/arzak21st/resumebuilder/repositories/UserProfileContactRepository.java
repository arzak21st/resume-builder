
package dev.arzak21st.resumebuilder.repositories;

import dev.arzak21st.resumebuilder.models.UserProfileContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileContactRepository extends JpaRepository<UserProfileContact, Integer>{

    UserProfileContact findUserProfileContactByUserId(int userId);
}
