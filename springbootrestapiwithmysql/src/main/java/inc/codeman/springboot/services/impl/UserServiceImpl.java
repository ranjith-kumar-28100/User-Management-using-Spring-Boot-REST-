package inc.codeman.springboot.services.impl;

import inc.codeman.springboot.Mapper.AutoUserMapper;
import inc.codeman.springboot.Mapper.UserMapper;
import inc.codeman.springboot.dto.UserDto;
import inc.codeman.springboot.entity.User;
import inc.codeman.springboot.exception.EmailAlreadyExistException;
import inc.codeman.springboot.exception.ResourceNotFoundException;
import inc.codeman.springboot.repository.UserRepository;
import inc.codeman.springboot.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository repository;
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        //User user = modelMapper.map(userDto,User.class);
        Optional<User> optionalUser = repository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()) {
            throw new EmailAlreadyExistException("Email Already Exist");
        }
        User user = AutoUserMapper.MAPPER.mapToUser(userDto);
        User savedUser = repository.save(user);
        //return modelMapper.map(savedUser,UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id) {
        User foundUser = repository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("User","id",id)
        );
        //return modelMapper.map(foundUser,UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(foundUser);
    }

    @Override
    public List<UserDto> getUsers() {

        List<User> users= repository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        //users.forEach(item->userDtoList.add(modelMapper.map(item,UserDto.class)));
        users.forEach(item->userDtoList.add(AutoUserMapper.MAPPER.mapToUserDto(item)));
        return userDtoList;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        Optional<User> optionalUser = repository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()) {
            throw new EmailAlreadyExistException("Email Already Exist");
        }
        User existingUser  = repository.findById(userDto.getId()).orElseThrow(()->new ResourceNotFoundException("User","id", userDto.getId()));
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        User updatedUser = repository.save(existingUser);
        //return modelMapper.map(updatedUser,UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User existingUser  = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id", id));
        repository.deleteById(id);
    }
}
