package com.developersboard.mapper.user;

import com.developersboard.dto.user.UserRoleDto;
import com.developersboard.entity.user.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * The UserRoleMapper class outlines the supported conversions between UserRole entity and other
 * data transfer objects.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = {UserMapper.class, RoleMapper.class})
public interface UserRoleMapper {

  /** The {@code UserRoleMapper} instance to provide access to the mapper implementation. */
  UserRoleMapper MAPPER = Mappers.getMapper(UserRoleMapper.class);

  /**
   * Convert and populate a userRole to userRoleDto object.
   *
   * @param userRole the UserRole
   * @return the UserRoleDto
   */
  UserRoleDto toUserRoleDto(UserRole userRole);

  /**
   * Convert and populate a userRoleDto to userRole object.
   *
   * @param userRoleDto UserRoleDto
   * @return UserRole
   */
  UserRole toUserRole(UserRoleDto userRoleDto);
}
