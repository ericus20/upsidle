package com.developersboard.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * UserHistoryType will hold User history types relevant to a user of the application.
 *
 * @author George on 6/29/2021
 * @version 1.0
 * @since 1.0
 */
@Getter
@RequiredArgsConstructor
public enum UserHistoryType {

  /** This is when a user is created by the system. */
  CREATED("Account created"),

  /** This is when the user verifies email. */
  VERIFIED("Account verified"),

  /** This will be used for password changes. */
  PASSWORD_UPDATE("Password updated"),

  /** This will be used for user info updates like name and phone changes. */
  PROFILE_UPDATE("Profile updated"),

  /** This will be used for account enabling. */
  ACCOUNT_ENABLED("Account Enabled"),

  /** This will be used for account disabling. */
  ACCOUNT_DISABLED("Account Disabled"),

  /** This will be used for account locking. */
  ACCOUNT_LOCKED("Account Locked"),

  /** This will be used for account unlocking. */
  ACCOUNT_UNLOCKED("Account unlocked"),

  /** This will be used for account expiry. */
  ACCOUNT_EXPIRED("Account Expired"),

  /** This will be used for credentials expiry. */
  CREDENTIALS_LOCKED("Credentials Locked");

  /** The name of the history type which is the string value attached to the enum constant. */
  private final String name;
}
