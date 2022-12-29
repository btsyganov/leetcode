package com.btsyganov.leetcode.medium._2214;

/**
 * 2214. Minimum Health to Beat Game
 */
public class Main2214 {

  static Main2214 main2214 = new Main2214();

  public static void main(String[] args) {
    assert 13 == main2214.minimumHealth(new int[] {2, 7, 4, 3}, 4);
    assert 10 == main2214.minimumHealth(new int[] {2, 5, 3, 4}, 7);
    assert 10 == main2214.minimumHealth(new int[] {3, 3, 3}, 0);
  }

  public long minimumHealth(int[] damage, int armor) {
    long max = damage[0];
    long sum = damage[0];
    int maxIndex = 0;
    for (int i = 1; i < damage.length; i++) {
      if (max < damage[i]) {
        max = damage[i];
        maxIndex = i;
      }
      sum += damage[i];
    }


    return sum - Math.min(damage[maxIndex], armor) + 1;
  }
}
