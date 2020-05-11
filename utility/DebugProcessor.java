package com.skava.plugins.orchestration.rue21.config;

import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>The class debugProcessor</p>
 */
@Service(value = "debugProcessor")
public class DebugProcessor implements Processor {

  /** The Constant Logger*/
  private static final Logger LOGGER = LoggerFactory.getLogger(DebugProcessor.class);

  /**
   * This process method set stores location respones in body
   * @param exchange Indicates a {@link Exchange} instance, which holds the information during the entire
   *                 routing of a Message received by a Consumer.
   */
  @Override
  public void process(Exchange exchange) throws Exception {
    LOGGER.debug("DebugProcessor Process Start");
    //exchange.getIn().setHeader("camelHttpResponseCode", "404");
    //Map<String, Object> map = (Map<String, Object>) exchange.getIn().getHeaders();
    ObjectMapper mapper = new ObjectMapper();
    String response = "Headers" + System.lineSeparator();
    response += exchange.getIn().getHeaders().toString(); 
    response += "Body" + System.lineSeparator();
    response += exchange.getIn().getBody(String.class);
    
    mapper.writeValue(new File("D://response/T1.txt"), response);
    //exchange.getIn().setBody(exchange.getIn().getBody(String.class));
    LOGGER.debug("DebugProcessor Process End");
  }
}
