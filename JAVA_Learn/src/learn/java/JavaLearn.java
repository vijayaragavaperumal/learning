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
package learn.java;

import java.util.Scanner;

public class JavaLearn {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int test = scanner.nextInt();
      int[] arr = new int[test];
      for (int i=0;i<arr.length;i++){
          arr[i] = scanner.nextInt();
      }
      scanner.close();
      
      int len= arr.length;
      int i=0;
      
      do
      {
          int temp = arr[i];
          int sum = 0;
          for (int j=0; j<=temp; j++)
          {
              sum = sum + j;
          }
          System.out.println(sum);
          i++;
      }while (i<len);
    }

  }
