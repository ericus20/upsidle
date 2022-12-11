package com.developersboard.entity.base;

import com.developersboard.utils.security.SecurityUtils;
import java.util.Optional;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;

/**
 * This class gets the application's current auditor which is the username of the authenticated
 * user.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
@ToString
@EqualsAndHashCode
public final class ApplicationAuditorAware implements AuditorAware<String> {
  private static final String CURRENT_AUDITOR = "system";

  @NonNull
  @Override
  public Optional<String> getCurrentAuditor() {

    // Check if there is a user logged in.
    // If so, use the logged-in user as the current auditor.
    // spring injects an anonymousUser if there is no
    // authentication and authorization
    var authentication = SecurityUtils.getAuthentication();
    if (SecurityUtils.isAuthenticated(authentication)) {
      return Optional.ofNullable(authentication.getName());
    }

    // If there is no authentication,
    // then the system will be used as the current auditor.
    return Optional.of(CURRENT_AUDITOR);
  }
}
