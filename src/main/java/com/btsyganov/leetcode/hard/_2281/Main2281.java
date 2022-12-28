package com.btsyganov.leetcode.hard._2281;

/**
 * 2281. Sum of Total Strength of Wizards
 */
public class Main2281 {

  static Main2281 main2281 = new Main2281();

  public static void main(String[] args) {
    assert 44 == main2281.totalStrength(new int[] {1, 3, 1, 2});
    assert 471441678 == main2281.totalStrength(
        new int[] {747, 812, 112, 1230, 1426, 1477, 1388, 976, 849, 1431, 1885, 1845, 1070, 1980,
            280, 1075, 232, 1330, 1868, 1696, 1361, 1822, 524, 1899, 1904, 538, 731, 985, 279, 1608,
            1558, 930, 1232, 1497, 875, 1850, 1173, 805, 1720, 33, 233, 330, 1429, 1688, 281, 362,
            1963, 927, 1688, 256, 1594, 1823, 743, 553, 1633, 1898, 1101, 1278, 717, 522, 1926,
            1451, 119, 1283, 1016, 194, 780, 1436, 1233, 710, 1608, 523, 874, 1779, 1822, 134,
            1984});
    assert 213 == main2281.totalStrength(new int[] {5, 4, 6});
  }

  /**
   * Brute force produces Time Limit Exceeded
   */
  public int totalStrength(int[] strength) {
    long total = 0;
    for (int i = 0; i < strength.length; i++) {
      for (int j = i; j < strength.length; j++) {
        long sum = sum(strength, i, j);
        long min = min(strength, i, j);
        total += sum * min;
      }
    }
    if (total > Integer.MAX_VALUE) {
      return (int) (total % (10_000_000_00 + 7));
    }
    return (int) total;
  }

  public long min(int[] str, int i, int j) {
    long min = str[i];
    for (int k = i + 1; k <= j; k++) {
      if (str[k] < min) {
        min = str[k];
      }
    }
    return min;
  }

  public long sum(int[] str, int i, int j) {
    long sum = 0;
    if (i == j) {
      return str[i];
    }
    for (int k = i; k <= j; k++) {
      sum += str[k];
    }
    return sum;
  }
}
