package com.btsyganov.leetcode.algo.bubble_sort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

  public static void main(String[] args) {
    sort(List.of(3, 1, 2));
  }

  public static <T extends Comparable<? super T>> List<T> sort(List<T> list) {
    list = new ArrayList<>(list);
    for (int i = 0; i < list.size(); i++) {
      for (int j = 0; j < list.size() - i - 1; j++) {
        if (list.get(j).compareTo(list.get(j + 1)) > 0) {
          T buf = list.get(j);
          list.set(j, list.get(j + 1));
          list.set(j + 1, buf);
        }
      }
    }
    return list;
  }
}
