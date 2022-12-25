package com.btsyganov.leetcode.medium._1010;

/**
 * 1010. Pairs of Songs With Total Durations Divisible by 60
 */
public class Main1010 {

  static Main1010 main1010 = new Main1010();

  public static void main(String[] args) {
    assert 3 == main1010.numPairsDivisibleBy60(new int[] {30, 20, 150, 100, 40});
    assert 3 == main1010.numPairsDivisibleBy60(new int[] {60, 60, 60});
  }

  /**
   * Brute force produces Time Limit Exceeded
   */
  public int numPairsDivisibleBy60(int[] time) {
    int counter = 0;
    for (int i = 0; i < time.length - 1; i++) {
      for (int j = i + 1; j < time.length; j++) {
        if ((time[i] + time[j]) % 60 == 0) {
          counter++;
        }
      }
    }
    return counter;
  }
}
