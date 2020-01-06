/*******************************************************************************
 * Copyright ©2002-2019 Skava - All rights reserved.
 * All information contained herein is, and remains the property of Skava.
 * Skava including, without limitation, all software and other elements thereof, 
 * are owned or controlled exclusively by Skava and protected by copyright, patent
 * and other laws. Use without permission is prohibited. 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * For further information contact Skava at info@skava.com.
 ******************************************************************************/
package com.javalearn.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LearnBigDecimal {

  public static final int BIG_DECIMAL_DIVISION_SCALE = 3;
  public final static int ROUND_HALF_UP = 4;

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println("Learn Big Decimal");

    BigDecimal totalDeliveryChargeTax = new BigDecimal(19);
    totalDeliveryChargeTax = totalDeliveryChargeTax.divide(new BigDecimal(5), BIG_DECIMAL_DIVISION_SCALE, ROUND_HALF_UP);
      //.multiply(new BigDecimal(3));
    System.out.println(totalDeliveryChargeTax);
    
    BigDecimal a = new BigDecimal("1");
    BigDecimal b = new BigDecimal("3");
    BigDecimal c = a.divide(b, 2, RoundingMode.HALF_UP);
    System.out.println(a + "/" + b + " = " + c);
  }

}
