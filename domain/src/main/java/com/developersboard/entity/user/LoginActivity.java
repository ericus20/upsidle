package com.developersboard.entity.user;

import com.developersboard.entity.base.BaseEntity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * LoginActivity records login details of the user entity.
 *
 * @author Eric Opoku
 * @version 1.0.0
 * @since 1.0.0
 */
@Getter
@Setter
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
class LoginActivity extends BaseEntity<Long> {

  private Integer failedLoginAttempts;
  private OffsetDateTime lastSuccessfulLogin;

  /**
   * Creates a new {@code LoginActivity} instance. This is required by {@code Hibernate} to create
   * new instances via reflection.
   */
  LoginActivity() {}
}
