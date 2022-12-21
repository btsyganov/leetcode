package com.btsyganov.leetcode.medium._5;

/**
 * 5. Longest Palindromic Substring
 */
public class Main5 {

  static Main5 main5 = new Main5();

  public static void main(String[] args) {
    assert "aba".equals(main5.longestPalindrome("babad"));
    assert "bb".equals(main5.longestPalindrome("cbbd"));
  }


  /**
   * Brute force throws Time Limit Exceeded
   */
  public String longestPalindrome(String s) {
    String longestStr = "";
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        String substring = s.substring(i, j + 1);
        if (isPalindrome(substring) && substring.length() >= longestStr.length()) {
          longestStr = substring;
        }
      }
    }
    return longestStr;
  }

  public boolean isPalindrome(String s) {
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }
}
