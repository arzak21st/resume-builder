
package dev.arzak21st.resumebuilder.repositories;

import dev.arzak21st.resumebuilder.models.UserProfileTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileTemplateRepository extends JpaRepository<UserProfileTemplate, Integer>{

    UserProfileTemplate findUserProfileTemplateByUserId(int userId);
}
