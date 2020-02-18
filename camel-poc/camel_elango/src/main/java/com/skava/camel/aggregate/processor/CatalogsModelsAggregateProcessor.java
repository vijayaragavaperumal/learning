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

import java.io.IOException;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skava.camel.aggregate.CatalogMicroserviceModelsAPIResponse;
import com.skava.camel.aggregate.transform.CatalogMicroserviceModel;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>The Class CatalogsModelsAggregateProcessor is used to convert the user micro-service response into the 
 * admin required response. It will remove the unwanted data from micro-service also 
 * this will add the required data to the response.</p>
 * @since Feb 2020
 * @version 8.7
 * @author Gangasri P
 */
@Service
@Slf4j
public class CatalogsModelsAggregateProcessor implements AggregationStrategy {

  private static final String MODELS_LIST = "modelList";

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
   * 
   */
  @Override
  public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
    Exchange exchange = null;
    try {
      exchange = handleExchanges(oldExchange, newExchange);
    } catch (IOException e) {
      log.debug("CatalogsModelsAggregateProcessor : {}", e);
    }
    return exchange;
  }

  /**
   * <h1>handleExchanges</h1>
   * <p>handleExchanges</p>
   * 
   * @param oldExchange holds the previous exchange object
   * @param newExchange hold the current exchange object
   * @return returns the updated exchange
   * @throws IOException throws on exception
   */
  private static Exchange handleExchanges(Exchange oldExchange, Exchange newExchange) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    String propertyData = null;
    CatalogMicroserviceModelsAPIResponse resultResponse = new CatalogMicroserviceModelsAPIResponse();
    CatalogMicroserviceModelsAPIResponse currentResponse = objectMapper.readValue(
      newExchange.getIn().getBody(String.class),
      CatalogMicroserviceModelsAPIResponse.class);

    if (oldExchange == null) {
      propertyData = newExchange.getProperty(MODELS_LIST, String.class);
    } else {
      propertyData = oldExchange.getProperty(MODELS_LIST, String.class);
    }

    List<CatalogMicroserviceModel> oldModels = currentResponse.getModels();
    if (propertyData != null) {
      resultResponse = objectMapper.readValue(propertyData, CatalogMicroserviceModelsAPIResponse.class);
      oldModels.addAll(resultResponse.getModels());
    }
    resultResponse.setModels(oldModels);

    newExchange.setProperty(MODELS_LIST, objectMapper.writeValueAsString(resultResponse));
    newExchange.getIn().setBody(resultResponse);
    return newExchange;
  }
}
