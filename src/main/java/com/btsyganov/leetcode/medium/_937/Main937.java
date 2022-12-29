package com.btsyganov.leetcode.medium._937;

import java.util.ArrayList;
import java.util.List;

/**
 * 937. Reorder Data in Log Files
 */
public class Main937 {

  static Main937 main937 = new Main937();

  public static void main(String[] args) {
    main937.reorderLogFiles(
        new String[] {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig",
            "let3 art zero"});
    main937.reorderLogFiles(
        new String[] {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo",
            "a2 act car"});
  }

  public String[] reorderLogFiles(String[] logs) {
    List<String> list = new ArrayList<>();
    List<String> letters = new ArrayList<>();
    List<String> digits = new ArrayList<>();
    for (int i = 0; i < logs.length; i++) {
      if (isNumeric(logs[i])) {
        digits.add(logs[i]);
      } else {
        letters.add(logs[i]);
      }
    }
    letters.sort((s1, s2) -> {
      var ss1 = s1.substring(s1.indexOf(' ') + 1);
      var ss2 = s2.substring(s2.indexOf(' ') + 1);
      if (ss1.compareTo(ss2) == 0) {
        return s1.substring(0, s1.indexOf(' ')).compareTo(s2.substring(0, s2.indexOf(' ')));
      }
      return ss1.compareTo(ss2);
    });
    list.addAll(letters);
    list.addAll(digits);
    return list.toArray(new String[0]);
  }

  boolean isNumeric(String s) {
    s = s.substring(s.indexOf(' ') + 1).replaceAll(" ", "");
    char ch0 = '0';
    char ch9 = '9';
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) < ch0 || s.charAt(i) > ch9) {
        return false;
      }
    }
    return true;
  }
}
