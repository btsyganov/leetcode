package com.btsyganov.leetcode.hard._23;

/**
 * 23. Merge k Sorted Lists
 */
public class Main23 {
  static Main23 main23 = new Main23();
  public static void main(String[] args) {
//    Input: lists = [[1,4,5],[1,3,4],[2,6]]


    ListNode l11 = new ListNode(1);
    ListNode l12 = new ListNode(4);
    ListNode l13 = new ListNode(5);
    l11.next = l12;
    l12.next = l13;

    ListNode l21 = new ListNode(1);
    ListNode l22 = new ListNode(3);
    ListNode l23 = new ListNode(4);
    l21.next = l22;
    l22.next = l23;

    ListNode l31 = new ListNode(2);
    ListNode l32 = new ListNode(6);
    l31.next = l32;

    main23.mergeKLists(new ListNode[] {l11, l21, l31});
  }

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode head = null;
    ListNode prev = null;
    while (true) {
      boolean isEmpty = true;
      ListNode min = null;
      int minIndex = -1;
      for (int i = 0; i < lists.length; i++) {
        if (lists[i] != null) {
          if (min == null || lists[i].val < min.val) {
            min = lists[i];
            minIndex = i;
          }
          isEmpty = false;
        }
      }

      if (isEmpty) {
        break;
      }

      if (min != null) {
        if (head == null) {
          head = min;
        } else {
          prev.next = min;
        }
        prev = min;
        lists[minIndex] = lists[minIndex].next;
      }


    }
    return head;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

}
