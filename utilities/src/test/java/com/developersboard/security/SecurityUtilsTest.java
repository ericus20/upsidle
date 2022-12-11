package com.developersboard.security;

import com.developersboard.UtilitiesTestUtils;
import com.developersboard.utils.security.SecurityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;
import org.springframework.security.core.context.SecurityContextHolder;

class SecurityUtilsTest extends UtilitiesTestUtils {

  @BeforeEach
  void setUp() {
    SecurityContextHolder.clearContext();
  }

  @Test
  void shouldThrowExceptionWhenConstructorIsCalled() {
    Assertions.assertThrows(
        AssertionError.class, () -> ReflectionUtils.newInstance(SecurityUtils.class));
  }

  @Test
  void testingIsUserAuthenticatedNull() {
    Assertions.assertFalse(SecurityUtils.isAuthenticated(null));
  }

  @Test
  void testingIsUserAuthenticatedNotAuthenticated() {
    var authentication = SecurityUtils.getAuthentication();
    Assertions.assertAll(
        () -> {
          Assertions.assertFalse(SecurityUtils.isAuthenticated());
          Assertions.assertFalse(SecurityUtils.isAuthenticated(authentication));
        });
  }
}
