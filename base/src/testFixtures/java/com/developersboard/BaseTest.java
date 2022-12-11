package com.developersboard;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.testcontainers.shaded.org.apache.commons.lang3.ArrayUtils;

/**
 * This class holds common test functionalities to be used with other Test.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
public class BaseTest {

  protected static final String ANONYMOUS_USER = "anonymousUser";
  protected static final String ANONYMOUS_ROLE = "ROLE_ANONYMOUS";
  protected static final String ROLE_USER = "ROLE_USER";
  protected static final String SYSTEM_USER = "system";

  private static final String[] IGNORED_FIELDS = {
    "id", "createdAt", "createdBy", "updatedAt", "updatedBy"
  };
  private static final String[] BASE_EQUALS_AND_HASH_CODE_FIELDS = {"version", "publicId"};
  private static final String[] USER_EQUALS_FIELDS = {"publicId", "username", "email"};

  public static Collection<String> getBaseEqualsAndHashCodeFields() {
    return List.of(BASE_EQUALS_AND_HASH_CODE_FIELDS);
  }

  public static Collection<String> getIgnoredFields() {
    return Collections.unmodifiableCollection(Arrays.asList(IGNORED_FIELDS));
  }

  public static String[] getEntityEqualsFields(String... fields) {
    return ArrayUtils.addAll(getBaseEqualsAndHashCodeFields().toArray(new String[0]), fields);
  }

  public static Collection<String> getUserEqualsFields() {
    var userEquals = ArrayUtils.addAll(BASE_EQUALS_AND_HASH_CODE_FIELDS, USER_EQUALS_FIELDS);
    return List.of(userEquals);
  }

  /**
   * Sets the authentication object for unit testing purposes.
   *
   * @param username the user to authenticate
   * @param role the role to be assigned
   */
  protected void setAuthentication(final String username, final String role) {
    var authorities = Collections.singletonList(new SimpleGrantedAuthority(role));

    Authentication auth;
    var user =
        User.builder().username(username).password(username).authorities(authorities).build();
    if (ANONYMOUS_USER.equals(username)) {
      auth = new AnonymousAuthenticationToken(username, user, authorities);
    } else {
      auth = new UsernamePasswordAuthenticationToken(user, null, authorities);
    }
    SecurityContextHolder.getContext().setAuthentication(auth);
  }
}
