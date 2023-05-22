package inc.codeman.springboot.controller;


import java.time.LocalDateTime;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import inc.codeman.springboot.dto.UserDto;
import inc.codeman.springboot.exception.ErrorDetails;
import inc.codeman.springboot.exception.ResourceNotFoundException;
import inc.codeman.springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;



@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/users")
@Tag(name = "CRUD REST API for User Resource",description="CREATE USER, UPDATE USER, GET USER, GET ALL USERS, DELETE USER")
public class UserController {
	private UserService userService;
	
	@Operation(summary ="Create User REST API",description = "Creating a new user with given First Name, Last Name, Email")
	@ApiResponse(responseCode="201",description="User Created Sucessfully")
	@PostMapping("/createUser")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){	
		UserDto createdUserDto = userService.createUser(userDto);				
		return new ResponseEntity<UserDto>(createdUserDto,HttpStatus.CREATED);
	}
	
	@Operation(summary ="GET User by Id REST API",description = "Fetching user with given Id")
	@ApiResponse(responseCode="200",description="User Fetched Sucessfully")
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
		UserDto fetchedUserDto = userService.getUser(id);
		return new ResponseEntity<UserDto>(fetchedUserDto,HttpStatus.OK);
	}
	
	@Operation(summary ="GET All Users",description = "Fetching all users")
	@ApiResponse(responseCode="200",description="Users Fetched Sucessfully")
	@GetMapping
	public ResponseEntity<List<UserDto>> getUsers(){
		List<UserDto> fetchedUsers = userService.getUsers();
		return new ResponseEntity<List<UserDto>>(fetchedUsers,HttpStatus.OK);
	}
	
	@Operation(summary ="Update User REST API",description = "Updating an existing user with given First Name, Last Name, Email")
	@ApiResponse(responseCode="200",description="User Updated Sucessfully")
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Long id,@Valid @RequestBody UserDto userDto){
		userDto.setId(id);
		UserDto updatedUserDto = userService.updateUser(userDto);
		return new ResponseEntity<UserDto>(updatedUserDto,HttpStatus.OK);
	}
	
	@Operation(summary ="Delete User With given Id REST API",description = "Deleting the user with given Id")
	@ApiResponse(responseCode="200",description="User Deleted Sucessfully")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return new ResponseEntity<String>("User Sucessfully Deleted.",HttpStatus.OK);
	}
	
//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest webRequest){
//		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),exception.getMessage(),webRequest.getDescription(false),"USER_NOT_FOUND");
//		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
//	}
	

}
