package com.debug;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.json.JSONObject;
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

    ObjectMapper mapper = new ObjectMapper();
      
    /*JSONObject jsonObject = new JSONObject(exchange.getIn().getBody());
    jsonObject.toString();*/
    LOGGER.debug("DebugProcessor Process End");
  }

  public void writeData(Exchange exchange, BufferedWriter bw) {
    try {
      bw.write(System.lineSeparator());
      bw.write("Request Body");
      bw.write(System.lineSeparator());
      JSONObject jsonObject = new JSONObject(exchange.getIn().getBody());
      bw.write(jsonObject.toString());
      bw.write(System.lineSeparator());
      bw.write("------------------------------------------------------------");
      bw.write(System.lineSeparator());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public BufferedWriter getBufferedWriter() {
    File file = new File("D:\\response\\request_response_log.txt");
    FileWriter fr;
    BufferedWriter bw = null;
    try {
      fr = new FileWriter(file, true);
      bw = new BufferedWriter(fr);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return bw;
  }

}
