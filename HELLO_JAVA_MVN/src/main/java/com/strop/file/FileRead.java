package com.strop.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class FileRead {

  public void countTheWord() {
    try {
      FileOpen fb = new FileOpen();
      BufferedReader br = fb.fileRead("D:\\testdata.txt");

      Scanner sin = new Scanner(System.in);

      System.out.println("Enter find string");
      String fs = sin.nextLine();

      String s;
      int ir = 1, pr = 0;
      while ((s = br.readLine()) != null) {
        if (s.indexOf(fs) != -1) {
          pr++;
          // System.out.println("### addClass is present" + ir);
        } else {
          // System.out.println("### addClass is not present" + ir);
        }
        ir++;
      }

      System.out.println("### Total Present count is :" + pr);

      sin.close();
      fb.fileClose(br);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
