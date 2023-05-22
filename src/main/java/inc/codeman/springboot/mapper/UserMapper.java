package inc.codeman.springboot.mapper;

import inc.codeman.springboot.dto.UserDto;
import inc.codeman.springboot.entity.User;


public class UserMapper {
	public static User userDtoToJpa(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());	
		return user;		
	}
	
	public static UserDto userJpaToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		return userDto;
	}

}
