package com.developersboard.entity.base;

import java.io.Serializable;
import java.util.Objects;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

/**
 * A custom sequence generator that can also accommodate manually assigned identifier.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
public class AssignedSequenceStyleGenerator extends SequenceStyleGenerator {

  /** Creates a new {@code AssignedSequenceStyleGenerator} instance. */
  public AssignedSequenceStyleGenerator() {}

  @Override
  public Serializable generate(SharedSessionContractImplementor session, Object object) {
    if (object instanceof Identifiable<? extends Serializable> identifiable) {
      Serializable id = identifiable.getId();
      if (Objects.nonNull(id)) {
        return id;
      }
    }

    return (Serializable) super.generate(session, object);
  }
}
