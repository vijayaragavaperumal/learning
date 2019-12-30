/*******************************************************************************
 * Copyright ©2002-2019 Skava - All rights reserved.
 * 
 * All information contained herein is, and remains the property of Skava.
 * Skava including, without limitation, all software and other elements thereof, 
 * are owned or controlled exclusively by Skava and protected by copyright, patent
 * and other laws. Use without permission is prohibited. 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 *    
 * For further information contact Skava at info@skava.com.
 ******************************************************************************/
package com.skava.cart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;

public class GoogleTranslate {

  public static void main(String[] args) throws Exception {

    GoogleTranslate http = new GoogleTranslate();
    String word = http.callUrlAndParseResult("en_US", "zh_CN", "hello");

    System.out.println(word);
  }

  private String callUrlAndParseResult(String langFrom, String langTo,
    String word) throws Exception {

    String url = "https://translate.googleapis.com/translate_a/single?" +
      "client=gtx&" +
      "sl=" + langFrom +
      "&tl=" + langTo +
      "&dt=t&q=" + URLEncoder.encode(word, "UTF-8");

    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestProperty("User-Agent", "Mozilla/5.0");

    BufferedReader in = new BufferedReader(
      new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();

    return parseResult(response.toString());
  }

  private String parseResult(String inputJson) throws Exception {
    /*
     * inputJson for word 'hello' translated to language Hindi from English-
     * [[["नमस्ते","hello",,,1]],,"en"]
     * We have to get 'नमस्ते ' from this json.
     */

    JSONArray jsonArray = new JSONArray(inputJson);
    JSONArray jsonArray2 = (JSONArray) jsonArray.get(0);
    JSONArray jsonArray3 = (JSONArray) jsonArray2.get(0);

    return jsonArray3.get(0).toString();
  }
}
