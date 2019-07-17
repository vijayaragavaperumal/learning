package com.strop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.strop.map.HashMapExample;

public class StringOperation {

  public static void main(String[] args) throws Exception {
    System.out.println("StringOperation File INIT");
    SumTwoNumbers();
    // DatePrint();
    // init();
  }
  
  public static void SumTwoNumbers() {
    Scanner s = new Scanner(System.in);
    
    // Get L and R from the input
  int L = s.nextInt();
  int R = s.nextInt();
  
      // Write here the logic to print all integers between L and R
      
      if(L == R)
      {
          System.out.println(L);
      }
      else 
      {
          //System.out.print(L + " ");
          while(L < R)
          {
              System.out.print(L++ + " ");
          }
          System.out.print(R);
      }
    s.close();
  }
  
  public static void DatePrint() throws Exception {
    Date dateObj = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").parse("2019-06-13T18:08:41+05:30");
    System.out.println("StringOperation File :" + new SimpleDateFormat("MM-dd-yyyy hh:mm a").format(dateObj));
  }

  public static void init() throws Exception {
    /*
     * System.out.println(test());
     * 
     * 
     * FileRead fr = new FileRead();
     * fr.countTheWord();
     * 
     * RegexTest rt = new RegexTest();
     * rt.testRegex();
     */

    HashMapExample hme = new HashMapExample();
    hme.setHashMap();

    /*
     * CopyFile cf = new CopyFile();
     * cf.copyFileStoD();
     */

    /*
     * FileWrite fw = new FileWrite();
     * fw.writeUsingOutputStream();
     * 
     * FileOpen fp = new FileOpen();
     * fp.openFile();
     */
  }

  public static String test() {
    return "### Init Function";
  }
}
