package com.strop.file;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileOpen {

  public void console() {
    System.out.println("### Show console");
  }
  
  public void openFile()
  {
    try
    {
      File fi = new File("D://PROJECT/");
        if (Desktop.isDesktopSupported()) {
          Desktop desktop = Desktop.getDesktop();
          desktop.open(fi);
      }
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
  }

  public BufferedReader fileRead(String filePath) {
    try {
      File fi = new File(filePath);
      BufferedReader br = new BufferedReader(new FileReader(fi));
      return br;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public void fileClose(BufferedReader br) {
    try {
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void countWord() {

  }
}
