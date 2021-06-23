package com.strop.fileprocessor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FileProcess {

  private static String space8 = "        ";
  private static String path = "D:\\PROJECTS\\RUE21\\ecommorchestration\\src\\main\\resources\\camel\\cart\\cart-routes1.xml";

  public static void readFile(String filePath) {
    File file = new File(filePath);
    BufferedWriter bw = getWriter(filePath);
    try {
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      int linenumber = 0;

      List<String> list = new ArrayList<>();
      while (line != null) {
        //Add Debug script to routes
       /* {
          if (checkMarshal(line)) {
            addRequestBody(list);
          } else if (checkHttpComponent(line)) {
            addRequestUri(list);
          } else if (checkUnMarshal(line)) {
            list.add(line);
            list.add(System.lineSeparator());
            line = null;
            injectResponseRoute(list);
          }
        }*/
        // Read line to add to routes
        if(line != null) {
          list.add(line);
          list.add(System.lineSeparator());
        }
        line = br.readLine();
        linenumber++;
      }
      writeFile(bw, list);
      br.close();
      bw.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static void writeFile(BufferedWriter bw, List<String> lines) {
    try {
      for (String line : lines) {
        bw.write(line);
        // bw.newLine();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static BufferedWriter getWriter(String filePath) {
    filePath = filePath.replace(FileConstant.ECOM_ORCH_READ_CHECK_PATH, FileConstant.ECOM_ORCH_WRITE_REPLACE_PATH);
    File file = new File(filePath);
    BufferedWriter bw = null;
    try {
      FileWriter fw = new FileWriter(file);
      bw = new BufferedWriter(fw);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return bw;
  }

  public static boolean checkMarshal(String line) {
    String regPattern = "<marshal\\s+ref=\"serializer\"\\s*/>";
    return (Pattern.matches(regPattern, line.trim()));
  }

  public static boolean checkHttpComponent(String line) {
    String regPattern = "<to\\s+uri=\"\\{\\{com.component.http\\}\\}\"\\s*/>";
    return (Pattern.matches(regPattern, line.trim()));
  }

  public static boolean checkUnMarshal(String line) {
    String regPattern = "</\\s*unmarshal>";
    return (Pattern.matches(regPattern, line.trim()));
  }

  public static void injectResponseRoute(List<String> list) {
    list.add(space8 + "<!-- Script Code : Start -->");
    list.add(System.lineSeparator());
    list.add(space8 + "<to uri=\"direct:debugHttpResponse\" />");
    list.add(System.lineSeparator());
    list.add(space8 + "<!-- Script Code : End -->");
    list.add(System.lineSeparator());
  }

  public static void addRequestBody(List<String> list) {
    list.add(space8 + "<!-- Script Code : Start -->");
    list.add(System.lineSeparator());
    list.add(space8 + "<to uri=\"direct:debugRequestBody\" />");
    list.add(System.lineSeparator());
    list.add(space8 + "<!-- Script Code : End -->");
    list.add(System.lineSeparator());
  }

  public static void addRequestUri(List<String> list) {
    list.add(space8 + "<!-- Script Code : Start -->");
    list.add(System.lineSeparator());
    list.add(space8 + "<to uri=\"direct:debugBeforeHttpComponent\" />");
    list.add(System.lineSeparator());
    list.add(space8 + "<!-- Script Code : End -->");
    list.add(System.lineSeparator());
  }
}
