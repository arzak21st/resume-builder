
package dev.arzak21st.resumebuilder.repositories;

import dev.arzak21st.resumebuilder.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    User findUserByUsername(String username);
}
