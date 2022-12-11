package com.developersboard.entity.user;

import com.developersboard.entity.base.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The UserRole model for the application.
 *
 * @author Matthew Puentes
 * @version 1.0
 * @since 1.0
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString(callSuper = true)
public class UserRole extends BaseEntity<Long> implements Serializable {

  @Serial private static final long serialVersionUID = -4137474921588375398L;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
  private User user;

  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class, cascade = CascadeType.MERGE)
  private Role role;

  /**
   * Constructor for UserRole.
   *
   * @param user user for object instantiation.
   * @param role user for object instantiation.
   */
  public UserRole(User user, Role role) {
    this.user = user;
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserRole userRole) || !super.equals(o)) {
      return false;
    }
    return Objects.equals(getUser(), userRole.getUser())
        && Objects.equals(getRole(), userRole.getRole());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getUser(), getRole());
  }

  @Override
  protected boolean canEqual(Object other) {
    return other instanceof UserRole;
  }
}
