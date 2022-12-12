package com.developersboard;

import com.developersboard.constant.ErrorConstants;
import com.developersboard.dto.user.RoleDto;
import com.developersboard.dto.user.UserDto;
import com.developersboard.dto.user.UserRoleDto;
import com.developersboard.enums.RoleType;

/**
 * User utility class that holds methods used across application.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
public final class UserUtils extends BaseUtils {

  /** Maximum password length for the password generation. */
  public static final int PASSWORD_MAX_LENGTH = 15;

  /** Minimum password length for the password generation. */
  private static final int PASSWORD_MIN_LENGTH = 4;

  private UserUtils() {
    throw new AssertionError(ErrorConstants.NOT_INSTANTIABLE);
  }

  /**
   * Create a user.
   *
   * @return a user
   */
  public static UserDto createUser() {
    return createUser(FAKER.name().username());
  }

  /**
   * Create a test user with flexibility.
   *
   * @param enabled if the user should be enabled or disabled
   * @return the user
   */
  public static UserDto createUser(final boolean enabled) {
    return createUser(
        FAKER.name().username(),
        FAKER.internet().password(PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH),
        FAKER.internet().emailAddress(),
        enabled);
  }

  /**
   * Create a user with some flexibility.
   *
   * @param username username used to create user.
   * @param roleType the role type
   * @return a user
   */
  public static UserDto createUser(String username, RoleType roleType) {
    var userDto = createUser(username);
    userDto.getUserRoles().add(new UserRoleDto(userDto, new RoleDto(roleType)));

    return userDto;
  }

  /**
   * Create a user with some flexibility.
   *
   * @param username username used to create user.
   * @return a user
   */
  public static UserDto createUser(String username) {
    return createUser(
        username,
        FAKER.internet().password(PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH),
        FAKER.internet().emailAddress());
  }

  /**
   * Create a user with some flexibility.
   *
   * @param username username used to create user
   * @param password password used to create user.
   * @param email email used to create user.
   * @return a user
   */
  public static UserDto createUser(String username, String password, String email) {
    return createUser(username, password, email, false);
  }

  /**
   * Create user with some flexibility.
   *
   * @param username username used to create user.
   * @param password password used to create user.
   * @param email email used to create user.
   * @param enabled boolean value used to evaluate if user enabled.
   * @return a user
   */
  public static UserDto createUser(
      String username, String password, String email, boolean enabled) {
    var userDto = new UserDto();
    userDto.setUsername(username);
    userDto.setPassword(password);
    userDto.setEmail(email);
    userDto.setName(FAKER.name().fullName());
    userDto.setPhone(FAKER.phoneNumber().cellPhone());

    if (enabled) {
      userDto.setEnabled(true);
      userDto.setAccountNonExpired(true);
      userDto.setAccountNonLocked(true);
      userDto.setCredentialsNonExpired(true);
    }
    return userDto;
  }
}
