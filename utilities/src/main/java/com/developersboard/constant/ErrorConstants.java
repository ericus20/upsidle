package com.developersboard.constant;

/**
 * This class holds all the error messages used in the application.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
public final class ErrorConstants {

  /** This class is not meant to be instantiated. */
  public static final String NOT_INSTANTIABLE = "This class cannot be instantiated";

  private ErrorConstants() {
    throw new AssertionError(NOT_INSTANTIABLE);
  }
}
