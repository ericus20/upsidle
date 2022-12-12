package com.developersboard;

import com.developersboard.dto.user.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.commons.util.ReflectionUtils;

class UserUtilsTest {

  @Test
  void ShouldThrowException() {
    Assertions.assertThrows(
        AssertionError.class, () -> ReflectionUtils.newInstance(UserUtils.class));
  }

  @Test
  void createUserWithNoArgument() {
    UserDto user = UserUtils.createUser();
    Assertions.assertAll(
        () -> {
          Assertions.assertNotNull(user.getUsername());
          Assertions.assertNotNull(user.getPassword());
          Assertions.assertNotNull(user.getEmail());
        });
  }

  @Test
  void createUserWithAnArgument(TestInfo testInfo) {
    UserDto user = UserUtils.createUser(testInfo.getDisplayName());
    Assertions.assertAll(
        () -> {
          Assertions.assertNotNull(user.getUsername());
          Assertions.assertNotNull(user.getPassword());
          Assertions.assertNotNull(user.getEmail());

          Assertions.assertEquals(testInfo.getDisplayName(), user.getUsername());
        });
  }

  @Test
  void createUserWithFourParameters() {

    UserDto userDto =
        UserUtils.createUser(
            BaseUtils.FAKER.name().username(),
            BaseUtils.FAKER.elderScrolls().city(),
            BaseUtils.FAKER.pokemon().name(),
            Boolean.TRUE);

    Assertions.assertAll(
        () -> {
          Assertions.assertNotNull(userDto.getUsername());
          Assertions.assertNotNull(userDto.getPassword());
          Assertions.assertNotNull(userDto.getEmail());
          Assertions.assertTrue(userDto.isEnabled());
        });
  }
}
