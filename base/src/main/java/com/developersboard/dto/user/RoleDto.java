package com.developersboard.dto.user;

import com.developersboard.enums.RoleType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The RoleDto transfers role from outside into the application and vice versa.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RoleDto {

  private Integer id;

  @EqualsAndHashCode.Include private String name;

  /**
   * The Role class creates a role for the user.
   *
   * @param roleType assigns the role properties.
   */
  public RoleDto(RoleType roleType) {
    this.id = roleType.getId();
    this.name = roleType.getName();
  }
}
