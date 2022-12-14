package com.developersboard;

import com.developersboard.constant.EnvConstants;
import org.springframework.test.context.ActiveProfiles;

/**
 * Abstract base class to be extended by every IT test. Starts the Spring Boot context, with all
 * data wiped out before each test.
 */
@ActiveProfiles({EnvConstants.INTEGRATION_TEST})
public class BaseIntegrationIntegrationTest {}
