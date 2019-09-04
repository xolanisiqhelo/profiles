package profiles.services;

import fr.xebia.extras.selma.Selma;
import profiles.domain.LoginDao;
import profiles.domain.ProfileDao;
import profiles.mapper.LoginMapper;
import profiles.models.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import profiles.reposetory.ProfileRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProfileRepository profileRepository;
    private LoginMapper mapper = Selma.builder(LoginMapper.class).build();

    public Object loginUser(String username, String password) {
        Profile user = profileRepository.findByUsername(username);

        logger.debug("login response " + user);
        if(user.getUsername().equals(username) && user.getPassword().equals(password)){
            LoginDao loginDao = mapper.asLoginDao(user);
            loginDao.setLoginStatus(true);

            return loginDao;
        }else{
            return false;
        }

    }

    public Object registerProfile(ProfileDao profile){
        Profile pro = mapper.asProfile(profile);

        Profile savedProfile = profileRepository.save(pro);

        if(savedProfile != null){
            return mapper.asProfileDao(savedProfile);
        }else{
            return false;
        }

    }

public List<ProfileDao> ListAllUsers()
{
    List<Profile> profiles =  profileRepository.findAll();
    List<ProfileDao> listProfileDaos = new ArrayList<>();

    if(profiles != null){
        for(Profile pro: profiles){
            ProfileDao profileDao = mapper.asProfileDao(pro);
            listProfileDaos.add(profileDao);
        }
        return listProfileDaos;
    }else{
        return null;
    }
}


    public ProfileDao updateUser(Integer id, ProfileDao profile){

        Optional<Profile> prod = profileRepository.findById(id);

        if(prod.isPresent() && prod != null){
            Profile updateProd = mapper.updateUser(profile, prod.get());
            logger.debug("updateUser called "+ updateProd);

            Profile savedProfile = profileRepository.save(updateProd);

            ProfileDao updateDao= mapper.asProfileDao(savedProfile);

            return updateDao;
        }else{
            return null;
        }

    }
    public boolean deleteUser(String id) {
        logger.debug("deleteUser called");
        //profileRepository.deleteByUsername(username);
        profileRepository.deleteById(Integer.parseInt(id));
//        if(this.getProductById(id).isPresent())
            //return false;
//        else
            return true;

    }

}
