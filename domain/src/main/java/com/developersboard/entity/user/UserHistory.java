package com.developersboard.entity.user;

import com.developersboard.entity.base.BaseEntity;
import com.developersboard.enums.UserHistoryType;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Class UserHistory captures activities happening to user such as profile update, password reset
 * etc.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
@Getter
@Entity
@ToString(callSuper = true)
public class UserHistory extends BaseEntity<Long> implements Serializable {

  @Serial private static final long serialVersionUID = -6902081317651761040L;

  /**
   * The user whom a particular modification is made to.
   *
   * @see User
   */
  @Setter
  @ToString.Exclude
  @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
  private User user;

  /**
   * The type of modification made to the user.
   *
   * @see UserHistoryType
   */
  @Enumerated(EnumType.ORDINAL)
  private UserHistoryType userHistoryType;

  /**
   * Creates a new {@code UserHistory} instance. This is required by {@code Hibernate} to create new
   * instances via reflection.
   */
  public UserHistory() {}

  /**
   * Constructor for UserHistory.
   *
   * @param publicId the publicId
   * @param user the user
   * @param userHistoryType the userHistoryType
   */
  public UserHistory(String publicId, User user, UserHistoryType userHistoryType) {
    this.setPublicId(publicId);
    this.user = user;
    this.userHistoryType = userHistoryType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserHistory that) || !(super.equals(o))) {
      return false;
    }
    return Objects.equals(getPublicId(), that.getPublicId())
        && Objects.equals(getUser(), that.getUser())
        && Objects.equals(getUserHistoryType(), that.getUserHistoryType());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getPublicId(), getUser(), getUserHistoryType());
  }

  @Override
  protected boolean canEqual(Object other) {
    return other instanceof UserHistory;
  }
}
