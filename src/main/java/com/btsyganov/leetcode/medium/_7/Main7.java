package com.btsyganov.leetcode.medium._7;

/**
 * 7. Reverse Integer
 */
public class Main7 {
  static Main7 main7 = new Main7();

  public static void main(String[] args) {
    assert 321 == main7.reverse(123);
    assert 21 == main7.reverse(120);
    assert -321 == main7.reverse(-123);
    assert 0 == main7.reverse(-2000000009);
  }

  /**
   * Using java features
   */
  public int reverse(int x) {
    String s = String.valueOf(x);
    String res = "";
    boolean isNegative = s.charAt(0) == '-';

    if (isNegative) {
      s = s.substring(1);
    }

    for (int i = 0; i < s.length(); i++) {
      res += s.charAt(s.length() - 1 - i);
    }
    long base = Long.parseLong(res);
    if (base > Integer.MAX_VALUE) {
      return 0;
    }

    return (int) (isNegative ? -1 * base : base);
  }

}
