package com.developersboard.repository.user;

import com.developersboard.BaseDomainIntegrationTest;
import com.developersboard.entity.user.Role;
import com.developersboard.enums.RoleType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;

class RoleRepositoryIntegrationTest extends BaseDomainIntegrationTest {

  @Autowired private RoleRepository cut;

  @Test
  void shouldFindByName() {
    // given
    var role = new Role(RoleType.ROLE_USER);
    cut.save(role);

    // when
    var actual = cut.findByName(role.getName());

    // then
    Assertions.assertEquals(role, actual);
  }

  @Test
  void shouldFindNothingWhenRoleDoesNotExist(TestInfo testInfo) {

    var actual = cut.findByName(testInfo.getDisplayName());

    Assertions.assertNull(actual);
  }
}
