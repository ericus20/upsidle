package com.developersboard.dto.user;

import com.developersboard.constant.user.UserConstants;
import com.developersboard.dto.BaseDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The UserDto transfers user details from outside into the application and vice versa.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class UserDto extends BaseDto implements Serializable {

  @Serial private static final long serialVersionUID = -6342630857637389028L;

  @EqualsAndHashCode.Include private String publicId;

  @EqualsAndHashCode.Include
  @NotBlank(message = UserConstants.BLANK_USERNAME)
  private String username;

  @ToString.Exclude
  @NotBlank(message = UserConstants.BLANK_PASSWORD)
  private String password;

  private String name;

  @EqualsAndHashCode.Include
  @NotBlank(message = UserConstants.BLANK_EMAIL)
  @Email(message = UserConstants.INVALID_EMAIL)
  private String email;

  private String role;
  private String phone;
  private String profileImage;
  private String verificationToken;

  private int failedLoginAttempts;
  private OffsetDateTime lastSuccessfulLogin;

  private boolean enabled;
  private boolean accountNonExpired;
  private boolean accountNonLocked;
  private boolean credentialsNonExpired;

  @ToString.Exclude private Set<UserRoleDto> userRoles = new HashSet<>();

  @ToString.Exclude private Set<UserHistoryDto> userHistories = new HashSet<>();
}
