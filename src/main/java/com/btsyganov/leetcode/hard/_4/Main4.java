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
    assert 2.5 == main4.findMedianSortedArrays(nums11, nums21);

    int[] nums12 = new int[] {1, 3};
    int[] nums22 = new int[] {2};
    assert 2.0 == main4.findMedianSortedArrays(nums12, nums22);
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    boolean isEven = (nums1.length + nums2.length) % 2 == 0;
    int medianIndex = (nums1.length + nums2.length - 1) / 2;

    int num1Index = 0;
    int num2Index = 0;
    int a = 0, b = 0;
    for (int i = 0; i <= (isEven ? medianIndex + 1 : medianIndex); i++) {
      int current;
      if (num1Index >= nums1.length ||
          (!(num2Index >= nums2.length) && nums1[num1Index] > nums2[num2Index])) {
        current = nums2[num2Index++];
      } else {
        current = nums1[num1Index++];
      }
      if (i == medianIndex) {
        a = current;
      } else if (i == medianIndex + 1) {
        b = current;
      }
    }
    if (isEven) {
      return ((double) (a + b)) / 2;
    } else {
      return a;
    }
  }

}
