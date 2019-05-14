package com.strop.map;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HashMapExample {

  public void setHashMap() throws Exception {
    System.out.println("Set Hashmap start");

    Map<String, String> ma = new HashMap<String, String>();
    ma.put("A", "1");
    ma.put("B", "2");

    try {
      ObjectMapper om = new ObjectMapper();
      String smap = om.writeValueAsString(ma);
      System.out.println(smap);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
