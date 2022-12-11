package com.developersboard.entity.base;

import com.developersboard.BaseTest;
import com.jparams.verifier.tostring.NameStyle;
import com.jparams.verifier.tostring.ToStringVerifier;
import java.io.Serial;
import java.io.Serializable;
import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.UUID;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * Test class for the BaseEntity.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
class BaseEntityTest {

  @Test
  void shouldCreateBaseEntityWhenGivenIdTypeString(TestInfo testInfo) {
    var baseEntity = createBaseEntity(testInfo.getDisplayName());

    Assertions.assertAll(
        () -> {
          Assertions.assertEquals(testInfo.getDisplayName(), baseEntity.getId());
          Assertions.assertEquals(0L, baseEntity.getVersion());
        });
  }

  @Test
  void shouldCreateBaseEntityWhenGivenIdTypeLong() {
    var id = 1L;
    var baseEntity = createBaseEntity(id);

    Assertions.assertEquals(id, baseEntity.getId());
  }

  @Test
  void shouldCreateBaseEntityWhenGivenCustomType() {

    // Id must implement serializable
    class CustomIdentifier implements Serializable {
      @Serial private static final long serialVersionUID = 1L;
    }

    var id = new CustomIdentifier();
    var baseEntity = createBaseEntity(id);

    Assertions.assertEquals(id, baseEntity.getId());
  }

  @Test
  void equalsContract() {
    EqualsVerifier.forClass(BaseEntity.class)
        .withOnlyTheseFields(BaseTest.getBaseEqualsAndHashCodeFields().toArray(new String[0]))
        .verify();
  }

  @Test
  void testToString() {
    ToStringVerifier.forClass(BaseEntity.class).withClassName(NameStyle.SIMPLE_NAME).verify();
  }

  private <T extends Serializable> BaseEntity<T> createBaseEntity(T id) {
    var baseEntity = new BaseEntity<T>();
    baseEntity.setId(id);
    baseEntity.setCreatedBy("system");
    baseEntity.setUpdatedBy(baseEntity.getCreatedBy());
    baseEntity.setPublicId(UUID.randomUUID().toString());
    baseEntity.setCreatedAt(OffsetDateTime.now(Clock.systemUTC()));
    baseEntity.setUpdatedAt(OffsetDateTime.now(Clock.systemUTC()));

    return baseEntity;
  }
}
