package com.strop.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

  public void testRegex() {
    final String regex = "[e|t].addclass";
    final String string = "one.addclass\n"
      + "test.addclass testing t.addclass h.addclass";

    final Pattern pattern = Pattern.compile(regex);
    final Matcher matcher = pattern.matcher(string);

    while (matcher.find()) {
      System.out.println("Full match: " + matcher.group(0));
      for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
      }
    }
  }
}
