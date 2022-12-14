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

  /** Public facing id used to uniquely accessed user in the users table. */
  @EqualsAndHashCode.Include private String publicId;

  /**
   * The username is a unique attribute which can be used to identify a single user in the users
   * table. It is a required field and must be between 3 and 50 inclusively.
   */
  @EqualsAndHashCode.Include
  @NotBlank(message = UserConstants.BLANK_USERNAME)
  private String username;

  /**
   * The email is a unique attribute which can be used to identify a single user in the users table.
   * It is a required field and must be a valid email.
   */
  @EqualsAndHashCode.Include
  @NotBlank(message = UserConstants.BLANK_EMAIL)
  @Email(message = UserConstants.INVALID_EMAIL)
  private String email;

  /**
   * The password is a required field that should be ignored when serializing the user. The password
   * is also excluded from {@link #toString()}
   */
  @ToString.Exclude
  @NotBlank(message = UserConstants.BLANK_PASSWORD)
  private String password;

  /** The full name of the user which includes any middle name. */
  private String name;

  /**
   * The string representation of the highest role assigned to this user. If the user has 2 roles
   * (ADMIN, USER), then the role will be 'admin'.
   */
  private String role;

  /**
   * The phone number is unique across all users and can be used to uniquely identify a user
   * although, it is not required.
   */
  private String phone;

  /**
   * The profileImageUrl is the path to the profile image of the user. This is populated once a user
   * uploads a profile image via profile update.
   */
  private String profileImageUrl;

  /**
   * VerificationToken is used to temporarily store a generated token for this user either to verify
   * email when creating the account or verify that a password reset operation is valid.
   */
  private String verificationToken;

  /** The number of times a login attempt to this user account has failed. */
  private int failedLoginAttempts;

  /** The last successful recorded time to this user account. */
  private OffsetDateTime lastSuccessfulLogin;

  /**
   * Determines if the user is enabled. When a user is not enabled, no authentication is permitted
   * regardless of credentials specified.
   */
  private boolean enabled;

  /**
   * Determines if the account is expired. When account is expired, no authentication is permitted
   * regardless of credentials specified.
   */
  private boolean accountNonExpired;

  /**
   * Determines if the account is locked. When account is locked, no authentication is permitted
   * regardless of credentials specified.
   */
  private boolean accountNonLocked;

  /**
   * Determines if the user credentials has been marked as expired. When credentials is marked as
   * expired, no authentication is permitted regardless of credentials specified.
   */
  private boolean credentialsNonExpired;

  /**
   * The userRoles are the level of authorization permitted ot this user.
   *
   * @see UserRoleDto
   */
  @ToString.Exclude private Set<UserRoleDto> userRoles = new HashSet<>();

  /**
   * The userHistories holds modifications made to this user either by the user or the system.
   *
   * @see UserHistoryDto
   */
  @ToString.Exclude private Set<UserHistoryDto> userHistories = new HashSet<>();

  /** Creates a new {@code BaseDto} instance. */
  public UserDto() {}
}
