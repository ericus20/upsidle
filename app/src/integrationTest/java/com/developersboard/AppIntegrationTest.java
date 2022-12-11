package com.developersboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppIntegrationTest extends BaseAppIntegrationTest {

  @Test
  void contextLoad() {
    Assertions.assertEquals(2, 1 + 1);
  }
}
