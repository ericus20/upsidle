package com.developersboard;

import java.util.Collections;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * This class holds common test functionalities to be used with other Test.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
public class TestUtils {

  protected static final String ANONYMOUS_USER = "anonymousUser";
  protected static final String ANONYMOUS_ROLE = "ROLE_ANONYMOUS";
  protected static final String ROLE_USER = "ROLE_USER";
  protected static final String SYSTEM_USER = "system";

  public static void setAnonymousAuthentication(final String username) {
    setAuthentication(username, ANONYMOUS_ROLE);
  }

  /**
   * Sets the authentication object for unit testing purposes.
   *
   * @param username the user to authenticate
   * @param role the role to be assigned
   */
  public static void setAuthentication(final String username, final String role) {
    var authorities = Collections.singletonList(new SimpleGrantedAuthority(role));
    Authentication auth;
    var user =
        User.builder().username(username).password(username).authorities(authorities).build();
    if (username.equals(ANONYMOUS_USER)) {
      auth = new AnonymousAuthenticationToken(username, user, authorities);
    } else {
      auth = new UsernamePasswordAuthenticationToken(user, null, authorities);
    }
    SecurityContextHolder.getContext().setAuthentication(auth);
  }
}
