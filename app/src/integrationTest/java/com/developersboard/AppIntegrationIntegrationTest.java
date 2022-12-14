package com.developersboard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppIntegrationIntegrationTest extends BaseAppIntegrationIntegrationTest {

  @Test
  void contextLoad() {
    Assertions.assertEquals(2, 1 + 1);
  }
}
