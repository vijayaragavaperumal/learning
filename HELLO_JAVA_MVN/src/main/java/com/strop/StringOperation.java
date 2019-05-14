package com.strop;

import com.strop.map.HashMapExample;

public class StringOperation {

  public static void main(String[] args) throws Exception {
    System.out.println("StringOperation File INIT");
    init();
  }

  public static void init() throws Exception {
    /*System.out.println(test());
    

    FileRead fr = new FileRead();
    fr.countTheWord();

    RegexTest rt = new RegexTest();
    rt.testRegex();*/

    HashMapExample hme = new HashMapExample();
    hme.setHashMap();
    
   /* CopyFile cf = new CopyFile();
    cf.copyFileStoD();*/
    
    /*FileWrite fw = new FileWrite();
    fw.writeUsingOutputStream();
    
    FileOpen fp = new FileOpen();
    fp.openFile();*/
  }

  public static String test() {
    return "### Init Function";
  }
}
