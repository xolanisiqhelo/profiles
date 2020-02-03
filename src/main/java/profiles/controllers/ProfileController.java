package profiles.controllers;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import profiles.domain.ProfileDao;
import profiles.models.Profile;
import profiles.services.ProfileService;

@RestController
@RequestMapping("profile")
@Api(value="profile", description="users profile details")
public class ProfileController {


    @Autowired
    private ProfileService profileService;



    @ApiOperation(value = "View a list of available users",response = ProfileDao.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list", response = ProfileDao.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> list(){
        try{
            return new ResponseEntity<>(profileService.ListAllUsers(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }


    @ApiOperation(value = "Search a user with an username and password",response = Profile.class)
    @RequestMapping(value = "get/user", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> showUser(@RequestParam(name = "username") String username, @RequestParam(name = "password") String pass){
        System.out.println("username"+username);
        System.out.println("password"+pass);
        try{
            return new ResponseEntity<>(profileService.loginUser(username, pass), HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @ApiOperation(value = "Create profile", response = ProfileDao.class)
    @RequestMapping(value = "post/user", method = RequestMethod.POST, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created profile", response = ProfileDao.class),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    public ResponseEntity<Object> saveUser(@RequestBody(required = true) ProfileDao data){
        try{
            return new ResponseEntity<>(profileService.registerProfile(data), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @ApiOperation(value = "Update a user")
    @PatchMapping(value = "/update/{id}", produces = "application/json")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody ProfileDao profile){
        try{
            return new ResponseEntity<Object>(profileService.updateUser(id,profile), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @ApiOperation(value = "Delete a user")
    @RequestMapping(value="delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Object> delete(@PathVariable(name ="id", required = true) String username){

        try{
            return new ResponseEntity<>(profileService.deleteUser(username), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }



    }



}
