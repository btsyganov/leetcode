package com.btsyganov.leetcode.hard._381;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 381. Insert Delete GetRandom O(1) - Duplicates allowed
 */
public class Main381 {


  public static void main(String[] args) {
    RandomizedCollection set = new RandomizedCollection();

    set.insert(1);
    set.insert(1);
    set.insert(2);
    set.insert(3);
    set.remove(1);
    set.remove(3);
    set.getRandom();

  }

  static class RandomizedCollection {
    private final Map<Integer, Set<Integer>> storage = new HashMap<>();
    private final List<Integer> list = new ArrayList<>();
    private final Random random = new Random();

    public RandomizedCollection() {

    }

    public boolean insert(int val) {
      if (storage.containsKey(val)) {
        storage.get(val).add(list.size());
        list.add(val);
        return false;
      } else {
        Set<Integer> list = new HashSet<>();
        list.add(this.list.size());
        storage.put(val, list);
        this.list.add(val);
        return true;
      }
    }

    public boolean remove(int val) {
      if (!storage.containsKey(val)) {
        return false;
      }

      if (storage.get(val).size() == 1) {
        Integer removeIndex = storage.get(val).iterator().next();
        Integer last = list.get(list.size() - 1);
        list.set(removeIndex, last);
        storage.get(val).remove(removeIndex);
        storage.get(last).remove(list.size() - 1);
        storage.get(last).add(removeIndex);
        list.remove(list.size() - 1);
        storage.remove(val);
      } else {
        Integer removeIndex = storage.get(val).iterator().next();
        Integer last = list.get(list.size() - 1);
        list.set(removeIndex, last);
        storage.get(val).remove(removeIndex);
        storage.get(last).remove(list.size() - 1);
        storage.get(last).add(removeIndex);
        list.remove(list.size() - 1);
      }

      return true;
    }

    public int getRandom() {
      return list.get(random.nextInt(list.size()));
    }
  }
}
