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

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SplitRequestProcessor implements Processor {

  private static final String PAGINATION_NAME = "paginate";

  @Override
  public void process(Exchange exchange) throws Exception {
    List<Integer> paginate = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      paginate.add(i);
    }
    exchange.setProperty(PAGINATION_NAME, StringUtils.collectionToCommaDelimitedString(paginate));
  }

}
