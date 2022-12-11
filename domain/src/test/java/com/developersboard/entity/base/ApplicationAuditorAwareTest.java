package com.developersboard.entity.base;

import com.developersboard.DomainTestUtils;
import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import java.util.Optional;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.security.core.context.SecurityContextHolder;

class ApplicationAuditorAwareTest extends DomainTestUtils {

  @BeforeEach
  void setUp() {
    SecurityContextHolder.clearContext();
  }

  @Test
  void shouldReturnSystemWhenNoUserIsAuthenticated() {
    Assertions.assertEquals(SYSTEM_USER, getAuditor());
  }

  /**
   * When a user is anonymously authenticated, the authentication object is set to be authenticated
   * with the anonymous role.
   *
   * <p>We are explicitly setting the authenticated user to false.
   *
   * <p>We do not allow anonymous access so system is expected.
   */
  @Test
  void shouldReturnSystemWhenUserIsAnonymousAndNotAuthenticated() {
    DomainTestUtils.setAnonymousAuthentication(DomainTestUtils.ANONYMOUS_USER);

    var authentication = SecurityContextHolder.getContext().getAuthentication();
    Assertions.assertTrue(authentication.isAuthenticated());

    authentication.setAuthenticated(false);
    Assertions.assertEquals(SYSTEM_USER, getAuditor());
  }

  /**
   * When a user is anonymously authenticated, the authentication object is set to be authenticated
   * with the anonymous role. We do not allow anonymous access so system is expected.
   */
  @Test
  void shouldReturnSystemWhenAuthenticatedUserIsAnonymous() {
    DomainTestUtils.setAnonymousAuthentication(DomainTestUtils.ANONYMOUS_USER);

    var authentication = SecurityContextHolder.getContext().getAuthentication();
    Assertions.assertAll(
        () -> {
          Assertions.assertNotNull(authentication);
          Assertions.assertTrue(authentication.isAuthenticated());
          Assertions.assertEquals(SYSTEM_USER, getAuditor());
        });
  }

  @Test
  void getCurrentAuditorWithAuthenticatedUser(TestInfo testInfo) {
    DomainTestUtils.setAuthentication(testInfo.getDisplayName(), DomainTestUtils.ROLE_USER);
    Assertions.assertEquals(testInfo.getDisplayName(), getAuditor());
  }

  @Test
  void equalsContract() {
    EqualsVerifier.forClass(ApplicationAuditorAware.class).verify();
  }

  @Test
  void shouldReturnExpectedStringRepresentation() {
    ToStringVerifier.forClass(ApplicationAuditorAware.class)
        .withClassName(NameStyle.SIMPLE_NAME)
        .verify();
  }

  private String getAuditor() {
    var applicationAuditorAware = new ApplicationAuditorAware();
    Optional<String> currentAuditor = applicationAuditorAware.getCurrentAuditor();
    return currentAuditor.orElse(null);
  }
}
