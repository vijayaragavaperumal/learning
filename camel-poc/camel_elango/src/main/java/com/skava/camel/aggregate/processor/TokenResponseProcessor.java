/*******************************************************************************
 * Copyright ©2002-2020 Skava - All rights reserved.
 * 
 * All information contained herein is, and remains the property of Skava.
 * Skava including, without limitation, all software and other elements thereof, 
 * are owned or controlled exclusively by Skava and protected by copyright, patent
 * and other laws. Use without permission is prohibited. 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 *    
 * For further information contact Skava at info@skava.com.
 ******************************************************************************/
package com.skava.camel.aggregate.processor;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TokenResponseProcessor implements Processor {

  private static final String TOKEN_NAME = "x-auth-token";

  @Override
  public void process(Exchange exchange) throws Exception {
    Map<String, String> tokenResponse = (HashMap<String, String>) new ObjectMapper()
      .readValue(exchange.getIn().getBody(String.class), HashMap.class);
    exchange.getIn().setHeader(TOKEN_NAME, tokenResponse.get("superAdminToken"));
  }

}
