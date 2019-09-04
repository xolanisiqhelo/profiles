package profiles.controllers;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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



    @ApiOperation(value = "View a list of available products",response = ProfileDao.class)
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


    @ApiOperation(value = "Search a product with an ID",response = Profile.class)
    @RequestMapping(value = "", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> showProduct(@RequestParam(name = "username") String username, @RequestParam(name = "password") String pass){
        try{
            return new ResponseEntity<>(profileService.loginUser(username, pass), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @ApiOperation(value = "Create profile", response = ProfileDao.class)
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created profile", response = ProfileDao.class),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    public ResponseEntity<Object> saveProduct(@RequestBody(required = true) ProfileDao data){
        try{
            return new ResponseEntity<>(profileService.registerProfile(data), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @ApiOperation(value = "Update a product")
    @PatchMapping(value = "/update/{id}", produces = "application/json")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody ProfileDao profile){
        try{
            return new ResponseEntity<Object>(profileService.updateUser(id,profile), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

//    @ApiOperation(value = "Delete a product")
//    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
//    public ResponseEntity<Object> delete(@PathVariable Integer id){
//
//        try{
//            return new ResponseEntity<>(Profile.deleteUser(id), HttpStatus.OK);
//        }catch(Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
//        }



    //}



}
