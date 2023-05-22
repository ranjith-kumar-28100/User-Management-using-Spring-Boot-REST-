package inc.codeman.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import inc.codeman.springboot.dto.UserDto;
import inc.codeman.springboot.entity.User;
import inc.codeman.springboot.exception.EmailAlreadyExistException;
import inc.codeman.springboot.exception.ResourceNotFoundException;
import inc.codeman.springboot.mapper.AutoUserMapper;
import inc.codeman.springboot.mapper.UserMapper;
import inc.codeman.springboot.repository.UserRepository;
import inc.codeman.springboot.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;	
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		//User user = modelMapper.map(userDto, User.class);
		//User user = UserMapper.userDtoToJpa(userDto);	
		if(userRepository.findByEmail(userDto.getEmail()).isPresent())
			throw new EmailAlreadyExistException(String.format("Email: %s not available", userDto.getEmail()));
		User user = AutoUserMapper.MAPPER.userDtoToJpa(userDto);			
		User createdUser = userRepository.save(user);				
		//UserDto createdUserDto = UserMapper.userJpaToDto(createdUser);
		//UserDto createdUserDto = modelMapper.map(createdUser, UserDto.class);
		UserDto createdUserDto = AutoUserMapper.MAPPER.userJpaToDto(createdUser);
		return createdUserDto;
	}

	@Override
	public UserDto getUser(Long id) {
		User fetchedUser = (userRepository.findById(id)).orElseThrow(()->new ResourceNotFoundException("User", "Id", id));
		//UserDto fetchedUserDto = UserMapper.userJpaToDto(fetchedUser);
		//UserDto fetchedUserDto = modelMapper.map(fetchedUser, UserDto.class);
		UserDto fetchedUserDto = AutoUserMapper.MAPPER.userJpaToDto(fetchedUser);
		return fetchedUserDto;
	}

	@Override
	public List<UserDto> getUsers() {
		List<User> users = userRepository.findAll();
		List<UserDto> usersDto = new ArrayList<UserDto>();
		//users.forEach((u)->usersDto.add(modelMapper.map(u,UserDto.class)));
		users.forEach((u)->usersDto.add(AutoUserMapper.MAPPER.userJpaToDto(u)));
		return usersDto;
	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		User fetchedUser = (userRepository.findById(userDto.getId())).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userDto.getId()));
		fetchedUser.setFirstName(userDto.getFirstName());
		fetchedUser.setLastName(userDto.getLastName());
		fetchedUser.setEmail(userDto.getEmail());
		User updatedUser = userRepository.save(fetchedUser);
		//UserDto updatedUserDto = UserMapper.userJpaToDto(updatedUser);
		//UserDto updatedUserDto = modelMapper.map(updatedUser, UserDto.class);
		UserDto updatedUserDto = AutoUserMapper.MAPPER.userJpaToDto(updatedUser);
		return updatedUserDto;
	}

	@Override
	public void deleteUser(Long id) {	
		User fetchedUser = (userRepository.findById(id)).orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
		userRepository.deleteById(id);		
	}

}
