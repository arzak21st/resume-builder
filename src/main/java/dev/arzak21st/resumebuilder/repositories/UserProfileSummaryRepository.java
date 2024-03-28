
package dev.arzak21st.resumebuilder.repositories;

import dev.arzak21st.resumebuilder.models.UserProfileSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileSummaryRepository extends JpaRepository<UserProfileSummary, Integer>{

    UserProfileSummary findUserProfileSummaryByUserId(int userId);
}
