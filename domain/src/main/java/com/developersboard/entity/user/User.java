package com.developersboard.entity.user;

import com.developersboard.constant.user.UserConstants;
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

  @Column(unique = true, nullable = false)
  @NotBlank(message = UserConstants.BLANK_USERNAME)
  @Size(min = 3, max = 50, message = UserConstants.USERNAME_SIZE)
  private String username;

  @Column(unique = true, nullable = false)
  @NotBlank(message = UserConstants.BLANK_EMAIL)
  @Email(message = UserConstants.INVALID_EMAIL)
  private String email;

  @ToString.Exclude
  @NotBlank(message = UserConstants.BLANK_PASSWORD)
  private String password;

  private String name;
  private String profileImage;
  private String verificationToken;

  @ToString.Exclude
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private Set<UserRole> userRoles = new HashSet<>();

  @ToString.Exclude
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private Set<UserHistory> userHistories = new HashSet<>();

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
