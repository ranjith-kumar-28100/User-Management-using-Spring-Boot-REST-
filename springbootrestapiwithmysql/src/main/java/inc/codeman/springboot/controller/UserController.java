package inc.codeman.springboot.controller;

import inc.codeman.springboot.dto.UserDto;
import inc.codeman.springboot.entity.User;
import inc.codeman.springboot.exception.ErrorDetails;
import inc.codeman.springboot.exception.ResourceNotFoundException;
import inc.codeman.springboot.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "CRUD REST APIs for User Resource",description = "CRUD REST APIs: Create User, Get User, Get all Users, Update User, Delete User")
@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @Operation(summary = "Create User Rest API",description = "Create User REST API is used to save user details into the database")
    @ApiResponse(responseCode = "201",description = "HTTP Status 201 Created")
    @PostMapping("createUser")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Get User by Id Rest API",description = "Get User by Id REST API is used to retrieve  user detail from the database")
    @ApiResponse(responseCode = "200",description = "HTTP Status 200 Sucess")
    @GetMapping("getUser/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }


    @Operation(summary = "Get All Users Rest API",description = "Get All Users REST API is used to retrieve  all users detail from the database")
    @ApiResponse(responseCode = "200",description = "HTTP Status 200 Sucess")
    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
    }

    @Operation(summary = "Update User  Rest API",description = "Update User  REST API is used to update  user detail in the database")
    @ApiResponse(responseCode = "200",description = "HTTP Status 200 Sucess")
    @PutMapping("updateUser")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto user){
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @Operation(summary = "Delete User with Id Rest API",description = "Delete User with Id REST API is used to remove  user detail from the database")
    @ApiResponse(responseCode = "200",description = "HTTP Status 200 Sucess")
    @DeleteMapping("removeUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User Deleted Sucessfully");
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFound(ResourceNotFoundException exception, WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(), webRequest.getDescription(false),"USER_NOT_FOUND");
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//    }
}
