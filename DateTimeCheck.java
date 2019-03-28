/*******************************************************************************
 * Copyright ©2002-2018 Skava.
 * All rights reserved.The Skava system, including
 * without limitation, all software and other elements
 * thereof, are owned or controlled exclusively by
 * Skava and protected by copyright, patent, and
 * other laws. Use without permission is prohibited.
 *
 * For further information contact Skava at info@skava.com.
 ******************************************************************************/
package com.skava.pricingadmin.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateTimeCheck {

  public static void main(String args[]) {
    String dateTime = "2019-12-29T10:00:00";
    String dayLightDateTime = "2019-03-29T10:00:00";
    String timezone = "PST";
    if (dateTime != null && timezone != null) {
      ZoneId zoneId = ZoneId.of((String) ZoneId.SHORT_IDS.get(timezone));
      if (zoneId == null) {
        zoneId = ZoneId.of(timezone);
      }
      LocalDateTime localDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);
      ZoneOffset zo = zoneId.getRules().getOffset(localDateTime);
      System.out.println("Without Day light date time offeset :" + dateTime + " Offset :" + zo.getId());
      localDateTime = LocalDateTime.parse(dayLightDateTime, DateTimeFormatter.ISO_DATE_TIME);
      zo = zoneId.getRules().getOffset(localDateTime);
      System.out.println("Day light date time :"  + dayLightDateTime + " Offset :" +  zo.getId());
      
      if(checkValidDate("2019-12-29T10:00:00 PST"))
      {
        System.out.println("This is valid date");
      }
    }
  }
  
  public static Boolean checkValidDate(String dateStr)
  {
    SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");
    
    try {
      sDate.parse(dateStr);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
        return false;
    }
    
    return true;
  }

}
