package profiles.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import profiles.domain.ProfileDao;
import profiles.models.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    public Profile findByUsername(String username);

    @Query(nativeQuery = true,
        value = "DELETE FROM profile WHERE username = ?1"
    )
    public void deleteByUsername(String username);

}
