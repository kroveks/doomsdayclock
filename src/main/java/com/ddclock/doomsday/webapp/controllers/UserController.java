package com.ddclock.doomsday.webapp.controllers;


import com.ddclock.doomsday.models.dto.UserDto;
import com.ddclock.doomsday.models.dto.UserProfileDto;
import com.ddclock.doomsday.models.entity.User;
import com.ddclock.doomsday.service.abstracts.dto.UserDtoService;
import com.ddclock.doomsday.service.abstracts.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Validated
@RequestMapping("/api/user/")
//@Api(value = "UserApi")
public class UserController {

    private final UserService userService;
    private final UserDtoService userDtoService;
    private static final int MAX_ITEMS_ON_PAGE = 100;

    @Autowired
    public UserController(UserService userService, UserDtoService userDtoService) {
        this.userService = userService;
        this.userDtoService = userDtoService;
    }


    // Examples for Swagger
    @GetMapping("{id}")
    //@ApiOperation(value = "Return message(Object)", response = String.class)
    /*@ApiResponses({
            @ApiResponse(code = 200, message = "Returns the object.", response = UserDto.class),
            @ApiResponse(code = 400, message = "Wrong ID",response = String.class)
    })*/
    public ResponseEntity<?> getUserById(
         //   @ApiParam(name="id",value="type Long(or other descriped)", required = true, example="0")
            @PathVariable Long id) {
        Optional<UserDto> userDto = userDtoService.getUserDtoById(id);
        return userDto.isPresent() ? ResponseEntity.ok().body(userDto.get()):
                ResponseEntity.badRequest()
                        .body("User with id " + id + " not found");
    }

    @GetMapping("{id}/profile")
    public ResponseEntity<?> getUserProfileById(
           // @ApiParam(....)
           @PathVariable Long id) {

        Optional<UserProfileDto> userDto = userDtoService.getUserProfileDtoById(id);
        return userDto.isPresent() ? ResponseEntity.ok().body(userDto.get()):
                ResponseEntity.badRequest()
                        .body("User with id " + id + " not found");
    }

    @DeleteMapping("{id}")
    /*@ApiOperation(value = "Set up user's field isDeleted to true", response = String.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "User deleted successfully", response = String.class),
            @ApiResponse(code = 400, message = "Something goes wrong",response = String.class),
            @ApiResponse(code = 400, message = "The user has already been deleted!",response = String.class)
    })*/
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {

        Optional<User> userObj = userService.getById(id);
        if (userObj.isPresent()) {
            User user = userObj.get();
            try {
                userService.deleteWithDictionaryById(user.getId());
                return ResponseEntity.badRequest().body("User and his dictionary has been deleted");
            }
            catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.badRequest().body("The user has already been deleted!");
            }
        }
        return ResponseEntity.badRequest().body("Something goes wrong");
    }
}
