package com.developersboard.security;

import com.developersboard.constant.ErrorConstants;
import java.util.Objects;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * This utility class holds custom operations on security used in the application.
 *
 * @author Stephen
 * @version 1.0
 * @since 1.0
 */
public final class SecurityUtils {

  private SecurityUtils() {
    throw new AssertionError(ErrorConstants.NOT_INSTANTIABLE);
  }

  /**
   * Returns true if the user is authenticated.
   *
   * @param authentication the authentication object
   * @return if user is authenticated
   */
  public static boolean isAuthenticated(Authentication authentication) {
    return Objects.nonNull(authentication)
        && authentication.isAuthenticated()
        && !(authentication instanceof AnonymousAuthenticationToken);
  }

  /**
   * Returns true if the user is authenticated.
   *
   * @return if user is authenticated
   */
  public static boolean isAuthenticated() {
    return isAuthenticated(getAuthentication());
  }

  /**
   * Retrieve the authentication object from the current session.
   *
   * @return authentication
   */
  public static Authentication getAuthentication() {
    return SecurityContextHolder.getContext().getAuthentication();
  }
}
