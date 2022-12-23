package com.btsyganov.leetcode.hard._4;

/**
 * 4. Median of Two Sorted Arrays
 */
public class Main4 {

  static Main4 main4 = new Main4();

  public static void main(String[] args) {
//    Input: nums1 = [1,2], nums2 = [3,4]
//    Input: nums1 = [1,3], nums2 = [2]

    int[] nums11 = new int[] {1, 2};
    int[] nums21 = new int[] {3, 4};
    main4.findMedianSortedArrays(nums11, nums21);

    int[] nums12 = new int[] {1, 3};
    int[] nums22 = new int[] {2};
    main4.findMedianSortedArrays(nums12, nums22);
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] res = new int[nums1.length + nums2.length];

    boolean isEven = (nums1.length + nums2.length) % 2 == 0;
    int medianIndex = (nums1.length + nums2.length - 1) / 2;

    int num1Index = 0;
    int num2Index = 0;
    for (int i = 0; i < res.length; i++) {
      if (num1Index >= nums1.length || (!(num2Index >= nums2.length) && nums1[num1Index] > nums2[num2Index])) {
        res[i] = nums2[num2Index++];
      } else {
        res[i] = nums1[num1Index++];
      }
    }
    if (isEven) {
      return ((double) (res[medianIndex] + res[medianIndex + 1])) / 2;
    } else {
      return res[medianIndex];
    }
  }

}
