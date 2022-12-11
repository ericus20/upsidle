package com.developersboard;

import com.developersboard.constant.ErrorConstants;
import com.developersboard.dto.user.UserDto;
import net.datafaker.Faker;

/**
 * User utility class that holds methods used across application.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
public final class UserUtils {

  private static final Faker FAKER = new Faker();

  private UserUtils() {
    throw new AssertionError(ErrorConstants.NOT_INSTANTIABLE);
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
    var user = new UserDto();
    user.setUsername(username);
    user.setPassword(password);
    user.setEmail(email);
    user.setPhone(FAKER.phoneNumber().cellPhone());

    if (enabled) {
      user.setEnabled(true);
      user.setAccountNonExpired(true);
      user.setAccountNonLocked(true);
      user.setCredentialsNonExpired(true);
    }
    return user;
  }
}
