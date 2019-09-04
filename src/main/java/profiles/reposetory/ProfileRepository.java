package profiles.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import profiles.models.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    public Profile findByUsername(String username);
}
