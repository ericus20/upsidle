package com.developersboard.entity.base;

import java.io.Serializable;

/**
 * This interface is to provide a generic Identity for entities.
 *
 * @param <T> the ID type
 * @author Eric Opoku
 * @version 1.0.0
 * @since 1.0.0
 */
@FunctionalInterface
interface Identifiable<T extends Serializable> {

  /**
   * Returns a serialized generic id to be used as primary keys for entities.
   *
   * @return id
   */
  T getId();
}
