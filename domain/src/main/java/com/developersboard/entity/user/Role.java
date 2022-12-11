package com.developersboard.entity.user;

import com.developersboard.enums.RoleType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The role entity.
 *
 * @author George Anguah
 * @version 1.0
 * @since 1.0
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Role {

  @Id private Integer id;
  private String name;

  /**
   * The Role class creates a role for the user.
   *
   * @param roleType assigns the role properties.
   */
  public Role(RoleType roleType) {
    this.id = roleType.getId();
    this.name = roleType.getName();
  }

  /**
   * Evaluate the equality of Role class.
   *
   * @param other is the object to use in equality test.
   * @return the equality of both objects.
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Role that)) {
      return false;
    }
    return Objects.equals(name, that.name);
  }

  /**
   * Hashcode of Role base on name.
   *
   * @return the hash value.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
