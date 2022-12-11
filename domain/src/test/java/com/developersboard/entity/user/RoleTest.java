package com.developersboard.entity.user;

import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class RoleTest {

  @Test
  void equalsContract() {
    EqualsVerifier.forClass(Role.class).withOnlyTheseFields("name").verify();
  }

  @Test
  void testToString() {
    ToStringVerifier.forClass(Role.class).withClassName(NameStyle.SIMPLE_NAME).verify();
  }
}
