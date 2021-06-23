package com.strop.inputtooutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InputToDesireOutput {
  
  private static int lineNumber = 0;
  
  public static void inOutController() throws IOException {
    System.out.println("Input Output Controller");
    FileReader fr = collectInput();
    BufferedWriter bw = new BufferedWriter(createOutput());
   
    if(fr != null) {
      BufferedReader br = new BufferedReader(fr);
      String changedText = "";
      while((changedText = br.readLine()) != null) {
        if(!checkAndReplace(changedText).equals("")) {
          bw.write(checkAndReplace(changedText));
          bw.write(System.lineSeparator());
        }
      }
      br.close();
    }
    bw.close();
  }
  
  public static String checkAndReplace(String line) {
    lineNumber++;
    if(lineNumber == 1 || lineNumber % 8 == 0) {
      return line;
    }
    return "";
  }
  
  public static FileReader collectInput() {
    System.out.println("Collect input");
    File inFile = new File("D:\\response\\input.txt");
    FileReader fr = null;
    try {
      fr = new FileReader(inFile);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return fr;
  } 
  
  public static FileWriter createOutput() throws IOException {
    System.out.println("Create Output");
    File outFile = new File("D:\\response\\desireOutput.txt");
    FileWriter fw = new FileWriter(outFile);
    return fw;
  }
  
  public void logicProcessor() {
    System.out.println("Logic processor");
  }
}
