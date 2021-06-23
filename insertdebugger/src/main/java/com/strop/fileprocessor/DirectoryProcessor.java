package com.strop.fileprocessor;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DirectoryProcessor {
  
  private static int count = 0;

  public static void processDirectory() {
    File file = new File(FileConstant.ECOM_ORCH_READ_PATH);
    if (file.exists() && file.isDirectory()) {
      File arr[] = file.listFiles();
      recursiveProcessDirectory(arr);
    }
  }

  public static void recursiveProcessDirectory(File[] filesList) {
    for (File file : filesList) {
      if (file.isFile() && checkFileNamePattern(file.getName())) {
        String filePath = file.getAbsolutePath();
        System.out.println(file.getName());
        FileProcess.readFile(filePath);
      } else if (file.isDirectory()) {
        recursiveProcessDirectory(file.listFiles());
      }
    }
  }

  public static boolean checkFileNamePattern(String fileName) {
    final String regPattern = "./*-routes.xml";
    //final String regPattern = "cart-routes.xml";

    Pattern pattern = Pattern.compile(regPattern);
    Matcher matcher = pattern.matcher(fileName);
    boolean isTrue = (matcher.find() && fileName.split("-").length == 2 && !fileName.equals("ratingsreviews-routes.xml"));
		isTrue = (!isTrue ? (fileName.split("-").length == 3 && !fileName.contains("-custom-") && !fileName.contains("-rest-")) : isTrue);
    if(isTrue) {
      count++;
    }
    return (isTrue);
  }
}
