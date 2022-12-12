package com.developersboard.dto.user;

import com.developersboard.dto.BaseDto;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The UserRoleDto transfers userRole from outside into the application and vice versa.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserRoleDto extends BaseDto implements Serializable {

  @Serial private static final long serialVersionUID = -2923588235485168311L;

  @ToString.Exclude private UserDto user;

  @ToString.Exclude private RoleDto role;

  /**
   * Constructor for UserRoleDto.
   *
   * @param userDto UserDto
   * @param roleDto RoleDto
   */
  public UserRoleDto(UserDto userDto, RoleDto roleDto) {
    this.user = userDto;
    this.role = roleDto;
  }
}
