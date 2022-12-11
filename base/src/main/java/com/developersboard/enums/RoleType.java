package com.developersboard.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Roles supported to be used in authorization.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
@Getter
@RequiredArgsConstructor
public enum RoleType {

  /** This role gives access to all the features of the application. */
  ROLE_ADMIN(1, "ROLE_ADMIN"),

  /** This role gives access to most basic functionalities of the application. */
  ROLE_USER(2, "ROLE_USER");

  private final int id;
  private final String name;
}
