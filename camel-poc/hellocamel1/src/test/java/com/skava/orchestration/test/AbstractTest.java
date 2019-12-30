/**********************************************************************************
 * Copyright ©2002-2018 Skava - All rights reserved.
 *
 * All information contained herein is, and remains the property of Skava.
 * Skava including, without limitation, all software and other elements thereof,
 * are owned or controlled exclusively by Skava and protected by copyright, patent
 * and other laws. Use without permission is prohibited.
 * Unauthorized copying of this file, via any medium is strictly prohibited
 *
 * For further information contact Skava at info@skava.com.
 *********************************************************************************/
package com.skava.orchestration.test;

import org.apache.camel.spring.SpringCamelContext;
import org.apache.camel.test.spring.DisableJmx;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.ConnectionFactory;
import com.skava.OrchestrationApplication;

/**
 * @author <a href="mailto:srinivasan.r@skava.com">Srinivasan R</a>
 * @since Feb 22, 2019
 *
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = OrchestrationApplication.class,
  properties = {
    "spring.cloud.zookeeper.enabled=false",
    "spring.cloud.zookeeper.config.watcher.enabled=false", "logging.level.org.apache.camel.component.http4=DEBUG"})
@DisableJmx(true)
public abstract class AbstractTest {

  /** The Constant LOGGER. */
  protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractTest.class);

  protected static final ObjectMapper mapper = new ObjectMapper();
  protected static MediaType defaultMediaType = MediaType.APPLICATION_JSON;

  /** Header properties */
  protected static final String HEADER_STORE_ID = "x-store-id";
  protected static final String HEADER_COLLECTION_ID = "x-collection-id";
  protected static final String HEADER_SESSION_ID = "x-sk-session-id";
  protected static final String HEADER_LIST_ID = "listId";
  protected static final String HEADER_VERSION_ID = "x-version";
  protected static final String HEADER_CONTENT_TYPE = "content-type";
  protected static final String HEADER_USER_ID = "x-user-id";
  protected static final String HEADER_ID = "x-id";
  protected static final String HEADER_CONTRACTS_END_TIME = "endTime";
  protected static final String HEADER_MERCHANDISE_STATUS_CODE = "merchandiseStatusCode";
  protected static final String HEADER_ORDER_WITH_PAYMENTS = "orderPayments";
  protected static final String HEADER_ORDER_WITHOUT_PAYMENTS_REF = "orderPaymentsRef";
  protected static final String HEADER_CANCEL_ORDER = "cancelOrder";

  /** Event properties */
  protected static final String NOTIFICATION_QUEUE_NAME = "notificationQueue";

  /** Query Properties **/
  protected static final String PARAM_STORE_ID = "storeId";

  /** Constant values */
  protected static final String B2C_STORE_ID = "1";
  protected static final String B2B_STORE_ID = "2";
  protected static final String VERSION_ID = "8.0.0";
  protected static final String CONTENT_TYPE = "application/json";
  protected static final String CONTRACTS_END_TIME = "1435353340000";
  protected static final String MERCHANDISE_STATUS_CODE = "200";

  @Autowired
  protected SpringCamelContext camelContext;

  @Autowired
  protected TestRestTemplate restTemplate;

  @Autowired
  protected ConnectionFactory connectionFactory;

  @Value("${skava.event.ecommTopic}")
  protected String ecommTopicName;


  protected abstract void beforeTest() throws Exception;

  @Before
  public void testSetup() throws Exception {
    this.beforeTest();
  }
  }
