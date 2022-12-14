package com.developersboard.entity.user;

import com.developersboard.BaseTest;
import com.developersboard.UserUtils;
import com.developersboard.enums.RoleType;
import com.developersboard.mapper.user.UserMapper;
import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class UserRoleTest {

  @Test
  void equalsContract() {
    var clientDto = UserUtils.createUser();
    var adminDto = UserUtils.createUser();

    var client = UserMapper.MAPPER.toUser(clientDto);
    var admin = UserMapper.MAPPER.toUser(adminDto);

    Role roleClient = new Role(RoleType.ROLE_USER);
    Role roleAdmin = new Role(RoleType.ROLE_ADMIN);

    EqualsVerifier.forClass(UserRole.class)
        .withRedefinedSuperclass()
        .withPrefabValues(User.class, client, admin)
        .withPrefabValues(Role.class, roleClient, roleAdmin)
        .withIgnoredFields(BaseTest.getIgnoredFields().toArray(new String[0]))
        .verify();
  }

  @Test
  void testToString() {
    ToStringVerifier.forClass(UserRole.class)
        .withClassName(NameStyle.SIMPLE_NAME)
        .withIgnoredFields("user", "role")
        .verify();
  }
}
