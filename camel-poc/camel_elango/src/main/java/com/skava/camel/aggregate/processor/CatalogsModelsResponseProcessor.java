/*******************************************************************************
 * Copyright ©2002-2018 Skava - All rights reserved.
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

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skava.camel.aggregate.CatalogMicroserviceModelsAPIResponse;

/**
 * <p>The Class CatalogsModelsResponseProcessor is used to convert the user micro-service response into the 
 * admin required response. It will remove the unwanted data from micro-service also 
 * this will add the required data to the response.</p>
 * @since Feb 2020
 * @version 8.7
 * @author Gangasri P
 */
@Service
public class CatalogsModelsResponseProcessor implements Processor {

  /**
   * <p>This processor class is used to convert the user micro-service response into the 
   * admin required response. It will remove the unwanted data from micro-service also
   * this will add the required data to the response.</p>
   * 
   * @param oldExchange An Exchange is the message container holding the information during 
   * the entire routing.
   * @param newExchange An Exchange is the message container holding the information during 
   * the entire routing.
   * @return returns the updated exchange
   * @throws Exception 
   * 
   */
  @Override
  public void process(Exchange exchange) throws Exception {
    CatalogMicroserviceModelsAPIResponse response = new ObjectMapper().readValue(
      exchange.getIn().getBody(String.class), CatalogMicroserviceModelsAPIResponse.class);
    exchange.getIn().setBody(response);
  }

}
