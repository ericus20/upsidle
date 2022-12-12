package com.developersboard.mapper.user;

import com.developersboard.dto.user.UserDto;
import com.developersboard.entity.user.User;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * The UserMapper class outlines the supported conversions between User entity and other data
 * transfer objects.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
@Mapper(
    uses = {UserHistoryMapper.class},
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

  /** The mapper instance. */
  UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

  /**
   * Convert and populate a user to userDto object.
   *
   * @param user the user
   * @return the userDto
   */
  UserDto toUserDto(User user);

  /**
   * Convert and populate users to list of userDto objects.
   *
   * @param users the users
   * @return the list of userDto
   */
  List<UserDto> toUserDto(List<User> users);

  /**
   * Convert and populate a userDto to User object.
   *
   * @param userDto the userDto
   * @return the user
   */
  User toUser(UserDto userDto);

  /**
   * Convert and populate list of userDtos to Users.
   *
   * @param userDtos List<UserDto>
   * @return List<User>
   */
  List<User> toUser(List<UserDto> userDtos);
}
