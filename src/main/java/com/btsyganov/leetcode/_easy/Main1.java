package com.btsyganov.leetcode._easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 */
public class Main1 {

  static Main1 main1 = new Main1();

  public static void main(String[] args) {
    //    Input: nums = [2,7,11,15], target = 9
    main1.twoSum(new int[] {2,7,11,15}, 9);
  }

  /**
   * O(n) solution
   */
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int cur = nums[i];
      if (map.containsKey(cur)) {
        return new int[] {i, map.get(cur)};
      }
      map.put(target - cur, i);
    }
    return null;
  }
}
