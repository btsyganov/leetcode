package com.btsyganov.leetcode.medium._6;

/**
 * 6. Zigzag Conversion
 */
public class Main6 {

  static Main6 main6 = new Main6();

  public static void main(String[] args) {
    assert "PAHNAPLSIIGYIR".equals(main6.convert("PAYPALISHIRING", 3));
    assert "PINALSIGYAHRPI".equals(main6.convert("PAYPALISHIRING", 4));
    assert "A".equals(main6.convert("A", 1));
    main6.convert("ABC", 1);
    main6.convert("AB", 1);
  }


  public String convert(String s, int numRows) {
    if (numRows == 1) return s;
    StringBuilder res = new StringBuilder();
    char[][] matrix = new char[numRows][s.length()];

    int k = 0;
    int l = 0;
    boolean toBottom = true;
    for (int i = 0; i < s.length(); i++) {
      char cur = s.charAt(i);
      matrix[k][l] = cur;
      if (toBottom) {
        if (k + 1 < numRows) {
          k++;
        } else {
          l++;
          k--;
          toBottom = false;
        }
      } else {
        if (k - 1 < 0) {
          k++;
          toBottom = true;
        } else {
          l++;
          k--;
        }
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] != '\u0000') {
          res.append(matrix[i][j]);
        }
      }
    }
    return res.toString();
  }
}
