package com.btsyganov.leetcode.medium._380;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 380. Insert Delete GetRandom O(1)
 */
public class Main380 {


  public static void main(String[] args) {
    RandomizedSet set = new RandomizedSet();

    set.insert(1);
    set.insert(2);
    set.insert(3);
    set.getRandom();

  }

  static class RandomizedSet {
    private final Set<Integer> storage = new HashSet<>();
    private final Random random = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
      return storage.add(val);
    }

    public boolean remove(int val) {
      return storage.remove(val);
    }

    public int getRandom() {
      int r = random.nextInt(storage.size());
      return storage.stream().skip(r).findFirst().orElseThrow();
    }
  }
}
