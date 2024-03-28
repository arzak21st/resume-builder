
package dev.arzak21st.resumebuilder.repositories;

import dev.arzak21st.resumebuilder.models.UserProfile;
import dev.arzak21st.resumebuilder.models.UserProfileLanguage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileLanguageRepository extends JpaRepository<UserProfileLanguage, Integer>{

    UserProfileLanguage findUserProfileLanguageByLanguageId(int languageId);
    List<UserProfileLanguage> findUserProfileLanguagesByUserProfile(UserProfile userProfile);
}
