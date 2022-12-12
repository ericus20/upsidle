package com.developersboard.entity.user;

import com.developersboard.BaseTest;
import com.developersboard.UserUtils;
import com.developersboard.mapper.user.UserMapper;
import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class UserHistoryTest {

  @Test
  void equalsContract() {

    var clientDto = UserUtils.createUser();
    var adminDto = UserUtils.createUser();

    var client = UserMapper.MAPPER.toUser(clientDto);
    var admin = UserMapper.MAPPER.toUser(adminDto);

    EqualsVerifier.forClass(UserHistory.class)
        .withRedefinedSuperclass()
        .withPrefabValues(User.class, client, admin)
        .withIgnoredFields(BaseTest.getIgnoredFields().toArray(new String[0]))
        .verify();
  }

  @Test
  void testToString() {
    ToStringVerifier.forClass(UserHistory.class)
        .withClassName(NameStyle.SIMPLE_NAME)
        .withIgnoredFields("user")
        .verify();
  }
}
