package com.debug;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>The class debugProcessor</p>
 */
@Service
public class RouteDebugProcessor implements Processor {

  /** The Constant Logger*/
  private static final Logger LOGGER = LoggerFactory.getLogger(RouteDebugProcessor.class);

  /**
   * This process method set stores location respones in body
   * @param exchange Indicates a {@link Exchange} instance, which holds the information during the entire
   *                 routing of a Message received by a Consumer.
   */
  @Override
  public void process(Exchange exchange) throws Exception {
    LOGGER.debug("DebugProcessor Process Start");
    
    
    

    ObjectMapper mapper = new ObjectMapper();
    BufferedWriter bw = null;

    if (checkIsHttpRequest(exchange)) {
      bw = getBufferedWriter();
      writeRequestBody(exchange, bw);
    } else if (checkIsBeforeHttp(exchange)) {
      bw = getBufferedWriter();
      writeHttpUriDetails(exchange, bw);
    }
    else if(checkIsHttpResponse(exchange)){
      bw = getBufferedWriter();
      writeHttpResponse(exchange, bw);
    }
    if(bw != null) {
      bw.close();
    }

    LOGGER.debug("DebugProcessor Process End");
  }

  public void writeRequestBody(Exchange exchange, BufferedWriter bw) {
    try {
      bw.write(System.lineSeparator());
      bw.write("Request Body");
      //JsonGenerator writeData = null;
      ObjectMapper mapper = new ObjectMapper();
      /*mapper.writeValue(bw, exchange.getIn().getBody());
      bw.write(System.lineSeparator());
      */
      
      
      
      
      //JSONObject jsonObject = new JSONObject(exchange.getIn().getBody());   
      
      /*StringWriter writer = new StringWriter();
      IOUtils.copy(exchange.getIn().getBody().toString(), writer, "UTF-8");
      String theString = writer.toString();*/
      
      bw.write(mapper.writeValueAsString(exchange.getIn().getBody()));
      bw.write(System.lineSeparator());
      bw.write("------------------------------------------------------------");
      bw.write(System.lineSeparator());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void writeHttpUriDetails(Exchange exchange, BufferedWriter bw) {
    try {
      String httpMethodType = exchange.getIn().getHeader(Exchange.HTTP_METHOD, String.class);
      String httpUri = exchange.getIn().getHeader(Exchange.HTTP_URI, String.class);
      bw.write(System.lineSeparator());
      bw.write("Request Type");
      bw.write(System.lineSeparator());
      bw.write(httpMethodType);
      bw.write(System.lineSeparator());
      bw.write("Request URI");
      bw.write(httpUri);
      bw.write(System.lineSeparator());
      bw.write("------------------------------------------------------------");
      bw.write(System.lineSeparator());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void writeHttpResponse(Exchange exchange, BufferedWriter bw) {
    try {
      String httpMethodType = exchange.getIn().getHeader(Exchange.HTTP_METHOD, String.class);
      String httpUri = exchange.getIn().getHeader(Exchange.HTTP_URI, String.class);
     
      bw.write(System.lineSeparator());
      bw.write("Http Response");
      bw.write(System.lineSeparator());
      
      bw.write(System.lineSeparator());
      bw.write(httpMethodType);
      bw.write(System.lineSeparator());
      bw.write("Request URI");
      bw.write(httpUri);
      bw.write(System.lineSeparator());
      bw.write(System.lineSeparator());
      
      /*JSONObject jsonObject = new JSONObject(exchange.getIn().getBody());
      bw.write(jsonObject.toString());*/
      ObjectMapper mapper = new ObjectMapper();
      bw.write(mapper.writeValueAsString(exchange.getIn().getBody()));
      bw.write(System.lineSeparator());
      bw.write("------------------------------------------------------------");
      bw.write(System.lineSeparator());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public boolean checkIsHttpRequest(Exchange exchange) {
    return exchange.getProperty("isHttpRequest", boolean.class);
  }

  public boolean checkIsBeforeHttp(Exchange exchange) {
    return exchange.getProperty("isBeforeHttp", boolean.class);
  }

  public boolean checkIsHttpResponse(Exchange exchange) {
    return exchange.getProperty("isHttpResponse", boolean.class);
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

  public void test(Exchange exchange) {

    // mapper.writeValue(resultFile, value);

    if (exchange.getProperty("HttpRequest").equals("true")) {
      // writeRequestToFile(exchange);
    }

    if (exchange.getProperty("authRequestBody") != null && exchange.getProperty("authRequestBody").equals("true")) {
      System.out.println("RequestBody");
      String bodyData = exchange.getIn().getBody(String.class);
      System.out.println(bodyData);
    } else if (exchange.getProperty("authResponseBody") != null
      && exchange.getProperty("authResponseBody").equals("true")) {
      System.out.println("bodyReponse");
      // String bodyData = exchange.getIn().getBody(String.class);
      JSONObject jsonObject = new JSONObject(exchange.getIn().getBody());
      System.out.println(jsonObject.toString());
    }

  }

  public void writeRequestToFile(Exchange exchange) throws Exception {
    File file = new File("D:\\response\\request_response_log.txt");
    FileWriter fr = new FileWriter(file, true);
    BufferedWriter bw = new BufferedWriter(fr);

    String lineSeparator = System.getProperty("line.separator");

    bw.write("HttpRequest");
    bw.write(lineSeparator);
    bw.write(exchange.getIn().getHeaders().toString());
    bw.write(lineSeparator);
    bw.write("------------------------------------------------------------");
    bw.write("Body");
    bw.write(lineSeparator);
    bw.write(exchange.getIn().getBody().toString());
    bw.write(lineSeparator);
    bw.write("------------------------------------------------------------");
    bw.write(lineSeparator);
    bw.close();
  }

  public void writeHeaderAndBodyInFile() {
    // exchange.getIn().setHeader("camelHttpResponseCode", "404");
    // Map<String, Object> map = (Map<String, Object>) exchange.getIn().getHeaders();
    /*
     * ObjectMapper mapper = new ObjectMapper();
     * String response = "Headers" + System.lineSeparator();
     * response += exchange.getIn().getHeaders().toString();
     * response += "Body" + System.lineSeparator();
     * response += exchange.getIn().getBody(String.class);
     */

    // mapper.writeValue(new File("D://response/T1.txt"), response);
    // exchange.getIn().setBody(exchange.getIn().getBody(String.class));
  }
}
