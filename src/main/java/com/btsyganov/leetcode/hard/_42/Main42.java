package com.btsyganov.leetcode.hard._42;

/**
 * 42. Trapping Rain Water
 */
public class Main42 {

  static Main42 main42 = new Main42();

  public static void main(String[] args) {
    main42.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
  }

  public int trap(int[] height) {
    int[] leftMaximum = new int[height.length];
    int[] rightMaximum = new int[height.length];
    leftMaximum[0] = height[0];
    for (int i = 1; i < leftMaximum.length; i++) {
      leftMaximum[i] = Math.max(leftMaximum[i - 1], height[i]);
    }

    rightMaximum[rightMaximum.length - 1] = height[height.length - 1];
    for (int i = rightMaximum.length - 2; i >= 0; i--) {
      rightMaximum[i] = Math.max(height[i], rightMaximum[i + 1]);
    }

    int res = 0;
    for (int i = 0; i < height.length - 1; i++) {
      res += Math.min(leftMaximum[i], rightMaximum[i]) - height[i];
    }

    return res;
  }
}
