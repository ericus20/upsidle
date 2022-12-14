package com.developersboard.repository.user;

import com.developersboard.entity.user.Role;
import org.springframework.data.repository.ListCrudRepository;

/**
 * Repository for the {@code Role} entity. This provides database level operations used to access on
 * Role entity.
 *
 * @author Eric Opoku
 * @version 1.0
 * @since 1.0
 */
public interface RoleRepository extends ListCrudRepository<Role, Integer> {

  /**
   * Gets role associated with required name.
   *
   * @param name name of role
   * @return role found or {@code null} if role does not exist
   */
  Role findByName(String name);
}
