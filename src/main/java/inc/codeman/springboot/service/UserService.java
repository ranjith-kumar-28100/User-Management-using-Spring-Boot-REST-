package inc.codeman.springboot.service;

import java.util.List;

import inc.codeman.springboot.dto.UserDto;
import inc.codeman.springboot.entity.User;

public interface UserService {
UserDto createUser(UserDto userDto);
UserDto getUser(Long id);
List<UserDto> getUsers();
UserDto updateUser(UserDto userDto);
void deleteUser(Long id);
}
