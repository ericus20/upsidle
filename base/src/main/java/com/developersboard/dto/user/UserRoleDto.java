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

  /**
   * The user whom this role is associated with.
   *
   * @see UserDto
   */
  @ToString.Exclude private UserDto user;

  /**
   * The particular role assigned to the user.
   *
   * @see RoleDto
   */
  @ToString.Exclude private RoleDto role;

  /** Creates a new {@code UserRoleDto} instance. */
  public UserRoleDto() {}

  /**
   * Constructor for UserRoleDto.
   *
   * @param userDto UserDto
   * @param roleDto RoleDto
   */
  public UserRoleDto(UserDto userDto, RoleDto roleDto) {
    this();
    this.user = userDto;
    this.role = roleDto;
  }
}
