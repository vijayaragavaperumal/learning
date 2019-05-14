/*Learn data : https://www.journaldev.com/861/java-copy-file*/
package com.strop.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

public class CopyFile {

  public void copyFileStoD() throws IOException
  {
    try
    {
      File sourceFile = new File("D:\\TEST\\test1.txt");
      File destFile = new File("D:\\TEST\\dd.txt");
      
      copyFileStream(sourceFile, destFile);
    }
    catch(Exception e)
    {
      System.out.println("Error in file path"+e);
    }    
    
  }
  
  /*This function get source and destination file path from user */
  public void copyToDest() throws IOException {
    Scanner cr = null;
    try {
      cr = new Scanner(System.in);

      System.out.println("Enter the Source File path");
      String sf = cr.nextLine();

      System.out.println("Enter the Destination File path");
      String df = cr.nextLine();
      
      long t = System.nanoTime();
      //Date ms = new Date();
      
      TimeUnit.SECONDS.convert(t, TimeUnit.NANOSECONDS);
      TimeUnit.MINUTES.convert(t, TimeUnit.NANOSECONDS);
      
      File source = new File(sf);
      File dest = new File(new File(df), source.getName());

      //copyFileApache(source, dest);
      copyFileStream(source, dest);
    } finally {
      cr.close();
    }
  }

  public void copyFileStream(File source, File dest) {
    InputStream is = null;
    OutputStream os = null;
    try {
      long st = System.nanoTime();
      is = new FileInputStream(source);
      os = new FileOutputStream(dest);

      byte[] buff = new byte[1024];
      int length;
      while ((length = is.read(buff)) > 0) {
        os.write(buff, 0, length);
        System.out.println("Copying in Progress...");
      }
      long timeTaken = (System.nanoTime() - st);
      System.out.println("Time taken in seconds" + TimeUnit.SECONDS.convert(timeTaken, TimeUnit.NANOSECONDS));
    } catch (Exception e) {
      System.out.println("Error in copying file"+e);
    } finally {
      try {
        is.close();
        os.close();
      } catch (Exception fe) {
      }
    }
  }

  public void copyFileApache(File source, File dest) throws IOException {
    FileUtils.copyFile(source, dest);
  }
}
