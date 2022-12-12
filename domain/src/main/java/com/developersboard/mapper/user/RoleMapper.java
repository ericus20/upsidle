package com.developersboard.mapper.user;

import com.developersboard.dto.user.RoleDto;
import com.developersboard.entity.user.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * The RoleMapper class outlines the supported conversions between Role entity and other data
 * transfer objects.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

  /** The mapper instance. */
  RoleMapper MAPPER = Mappers.getMapper(RoleMapper.class);

  /**
   * Convert and populate a role to roleDto object.
   *
   * @param role Role
   * @return the RoleDto
   */
  RoleDto toUserDto(Role role);

  /**
   * Convert and populate a roleDto to role object.
   *
   * @param roleDto the roleDto
   * @return the Role
   */
  Role toUserDto(RoleDto roleDto);
}
