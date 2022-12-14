package com.developersboard.dto;

import java.time.OffsetDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The BaseDto provides base fields to be extended.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BaseDto {
  private Long id;
  @EqualsAndHashCode.Include private int version;

  private String updatedBy;
  private String createdBy;
  private OffsetDateTime createdAt;
  private OffsetDateTime updatedAt;

  /** Creates a new {@code BaseDto} instance. */
  public BaseDto() {}
}
