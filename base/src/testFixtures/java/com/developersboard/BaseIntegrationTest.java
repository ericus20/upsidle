package com.developersboard;

import com.developersboard.constant.EnvConstants;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Abstract base class to be extended by every IT test. Starts the Spring Boot context, with all
 * data wiped out before each test.
 */
@AutoConfigureMockMvc
@ActiveProfiles({EnvConstants.INTEGRATION_TEST})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseIntegrationTest {}
