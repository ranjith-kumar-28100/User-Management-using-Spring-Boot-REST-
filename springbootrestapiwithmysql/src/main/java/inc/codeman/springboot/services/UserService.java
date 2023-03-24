package inc.codeman.springboot.services;

import inc.codeman.springboot.dto.UserDto;
import inc.codeman.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    List<UserDto> getUsers();
    UserDto updateUser(UserDto userDto);

    void deleteUser(Long id);
}
