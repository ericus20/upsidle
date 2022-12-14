package com.developersboard.entity.user;

import com.developersboard.constant.user.UserConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The user model for the application.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
@Entity
@Getter
@Setter
@Table(name = "users")
@ToString(callSuper = true)
public class User extends UserAccountDetails implements Serializable {

  @Serial private static final long serialVersionUID = -4647505849606129298L;

  /**
   * The username is a unique attribute which can be used to identify a single user in the users
   * table. It is a required field and must be between 3 and 50 inclusively.
   */
  @Column(unique = true, nullable = false)
  @NotBlank(message = UserConstants.BLANK_USERNAME)
  @Size(min = 3, max = 50, message = UserConstants.USERNAME_SIZE)
  private String username;

  /**
   * The email is a unique attribute which can be used to identify a single user in the users table.
   * It is a required field and must be a valid email.
   */
  @Column(unique = true, nullable = false)
  @NotBlank(message = UserConstants.BLANK_EMAIL)
  @Email(message = UserConstants.INVALID_EMAIL)
  private String email;

  /**
   * The password is a required field that should be ignored when serializing the user. The password
   * is also excluded from {@link #toString()}
   */
  @JsonIgnore
  @ToString.Exclude
  @NotBlank(message = UserConstants.BLANK_PASSWORD)
  private String password;

  /** The full name of the user which includes any middle name. */
  private String name;

  /**
   * The phone number is unique across all users and can be used to uniquely identify a user
   * although, it is not required.
   */
  @Column(unique = true)
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

  /**
   * The userRoles are the level of authorization permitted ot this user.
   *
   * @see UserRole
   */
  @ToString.Exclude
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private Set<UserRole> userRoles = new HashSet<>();

  /**
   * The userHistories holds modifications made to this user either by the user or the system.
   *
   * @see UserHistory
   */
  @ToString.Exclude
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private Set<UserHistory> userHistories = new HashSet<>();

  /**
   * Creates a new {@code User} instance. This is required by {@code Hibernate} to create new
   * instances via reflection.
   */
  public User() {}

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof User user) || !super.equals(o)) {
      return false;
    }
    return Objects.equals(getPublicId(), user.getPublicId())
        && Objects.equals(getUsername(), user.getUsername())
        && Objects.equals(getEmail(), user.getEmail());
  }

  @Override
  protected boolean canEqual(Object other) {
    return other instanceof User;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getPublicId(), getUsername(), getEmail());
  }

  /**
   * Add userRole to this User.
   *
   * @param user the user
   * @param role the role
   */
  public void addUserRole(final User user, final Role role) {
    var userRole = new UserRole(user, role);
    userRoles.add(new UserRole(user, role));
    userRole.setUser(this);
  }

  /**
   * Remove userRole from this User.
   *
   * @param user the user
   * @param role the role
   */
  public void removeUserRole(final User user, final Role role) {
    var userRole = new UserRole(user, role);
    userRoles.remove(userRole);
    userRole.setUser(null);
  }

  /**
   * Add a UserHistory to this user.
   *
   * @param userHistory userHistory to be added.
   */
  public void addUserHistory(final UserHistory userHistory) {
    userHistories.add(userHistory);
    userHistory.setUser(this);
  }
}
