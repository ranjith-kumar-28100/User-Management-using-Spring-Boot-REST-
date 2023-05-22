package inc.codeman.springboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import inc.codeman.springboot.dto.UserDto;
import inc.codeman.springboot.entity.User;

@Mapper
public interface AutoUserMapper {
	User userDtoToJpa(UserDto userDto);
	UserDto userJpaToDto(User user);	
	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

}
