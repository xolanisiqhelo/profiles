package profiles.mapper;

import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import profiles.domain.LoginDao;
import profiles.domain.ProfileDao;
import profiles.models.Profile;

@Mapper(
        withIgnoreMissing = IgnoreMissing.ALL,
        withIgnoreNullValue = true
)
public interface LoginMapper {
            Profile updateUser(ProfileDao in,Profile out);
            LoginDao asLoginDao(Profile in);
            Profile asProfile(ProfileDao in);
            ProfileDao asProfileDao(Profile in);


}


