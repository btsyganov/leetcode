package com.btsyganov.leetcode.medium._56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 */
public class Main56 {

  static Main56 main56 = new Main56();

  public static void main(String[] args) {
    int[][] intervals = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int[][] res = main56.merge(intervals);
  }

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    List<int[]> results = new ArrayList<>();
    for (int [] interval : intervals) {
      int a = interval[0];
      int b = interval[1];
      if (results.isEmpty()) {
        results.add(new int[] {a, b});
      } else {
        int[] last = results.get(results.size() - 1);
        if (last[1] >= a) {
          last[1] = Integer.max(b, last[1]);
        } else {
          results.add(new int[] {a, b});
        }
      }

    }
    int[][] r = new int[results.size()][2];
    for (int i = 0; i < results.size(); i++) {
      r[i] = results.get(i);
    }
    return r;
  }
}
