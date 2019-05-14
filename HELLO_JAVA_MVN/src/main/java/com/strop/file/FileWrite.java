package com.strop.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileWrite {
  
  public void writeUsingOutputStream() 
  {
    OutputStream os = null;
    String data = "Test one";
    
    try {
        File fp = new File("D://test.txt");
        os = new FileOutputStream(fp);
        os.write(data.getBytes(), 0, data.length());
    }
    catch(IOException e) {
      e.printStackTrace();
    }
  }

}
