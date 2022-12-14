package com.developersboard.config;

import com.developersboard.entity.base.ApplicationAuditorAware;
import java.time.OffsetDateTime;
import java.util.Optional;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * DomainConfig allows JPA configurations to be specified for this application.
 *
 * @author Eric Opoku
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
@EnableTransactionManagement
@EntityScan("com.developersboard.entity")
@EnableJpaRepositories("com.developersboard.repository")
@EnableJpaAuditing(auditorAwareRef = "auditorAware", dateTimeProviderRef = "dateTimeProvider")
public class DomainConfig {

  /** Creates a new {@code DomainConfig} instance. */
  public DomainConfig() {}

  /**
   * {@return Application implementation of AuditorAware}
   *
   * @see ApplicationAuditorAware
   */
  @Bean
  public AuditorAware<String> auditorAware() {
    return new ApplicationAuditorAware();
  }

  /**
   * A date-time with an offset from UTC/Greenwich in the ISO-8601 calendar system, such as
   * 2007-12-03T10:15:30+01:00. Used when modeling date-time concepts in more detail, or when
   * communicating to a database or in a network protocol.
   *
   * @return DateTimeProvider
   * @see <a
   *     href="https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html">OffsetDateTime</a>
   */
  @Bean
  public DateTimeProvider dateTimeProvider() {
    return () -> Optional.of(OffsetDateTime.now());
  }
}
