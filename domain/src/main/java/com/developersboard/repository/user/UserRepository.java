package com.developersboard.repository.user;

import com.developersboard.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for the User.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
public interface UserRepository extends JpaRepository<User, Long> {

  /**
   * Find user by email.
   *
   * @param email email used to search for user.
   * @return User.
   */
  User findByEmail(String email);
}
