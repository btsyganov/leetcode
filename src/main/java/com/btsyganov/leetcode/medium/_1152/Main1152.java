package com.btsyganov.leetcode.medium._1152;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 1152. Analyze User Website Visit Pattern
 */
public class Main1152 {

  static Main1152 main1152 = new Main1152();

  public static void main(String[] args) {
    main1152.mostVisitedPattern(
        new String[] {"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"},
        new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
        new String[] {"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"});
    main1152.mostVisitedPattern(
        new String[] {"ua","ua","ua","ub","ub","ub"},
        new int[] {1, 2, 3, 4, 5, 6},
        new String[] {"a","b","a","a","b","c"});
    main1152.mostVisitedPattern(
        new String[] {"ua", "ua", "ua", "ub", "ub", "ub"},
        new int[] {1, 2, 3, 4, 5, 6},
        new String[] {"a", "b", "c", "a", "b", "a"});

    main1152.mostVisitedPattern(
        new String[] {"zkiikgv", "zkiikgv", "zkiikgv", "zkiikgv"},
        new int[] {436363475, 710406388, 386655081, 797150921},
        new String[] {"wnaaxbfhxp", "mryxsjc", "oz", "wlarkzzqht"});

    main1152.mostVisitedPattern(
        new String[] {"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"},
        new int[] {527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930},
        new String[] {"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"});
  }


  /**
   * Wrong answer
   * usernames = ["h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"]
   * timestamps = [527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930]
   * websites = ["hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"]
   * expected ["hibympufi","hibympufi","yljmntrclw"]
   * actual ["hibympufi","hibympufi","hibympufi"]
   */
  public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

    Map<String, Set<UTPair>> byNames = new HashMap<>();
    Map<String, Integer> patterns = new HashMap<>();
    for (int i = 0; i < username.length; i++) {
      if (!byNames.containsKey(username[i])) {
        byNames.put(username[i], new TreeSet<>());
      }
      byNames.get(username[i]).add(new UTPair(website[i], timestamp[i]));
    }

    int maxPatternCounter = 0;
    for (Map.Entry<String, Set<UTPair>> entry : byNames.entrySet()) {
      List<UTPair> pairs = entry.getValue().stream().toList();

      for (int i = 0; i < pairs.size() - 2; i++) {
        for (int j = i + 1; j < pairs.size() - 1; j++) {
          for (int k = j + 1; k < pairs.size(); k++) {
            String pattern =
                pairs.get(i).site + "_" + pairs.get(j).site + "_" + pairs.get(k).site;
            if (!patterns.containsKey(pattern)) {
              patterns.put(pattern, 0);
            }
            patterns.put(pattern, patterns.get(pattern) + 1);
            if (maxPatternCounter < patterns.get(pattern)) {
              maxPatternCounter = patterns.get(pattern);
            }
          }
        }
      }

    }

    Set<String> results = new TreeSet<>();
    for (Map.Entry<String, Integer> patternEntry : patterns.entrySet()) {
      if (patternEntry.getValue() == maxPatternCounter) {
        results.add(patternEntry.getKey());
      }
    }

    return Arrays.stream(results.iterator().next().split("_")).toList();
  }

  public static class UTPair implements Comparable<UTPair> {
    final String site;
    final Integer timestamp;

    public UTPair(String site, Integer timestamp) {
      this.site = site;
      this.timestamp = timestamp;
    }

    @Override
    public int compareTo(UTPair o) {
      return this.timestamp.compareTo(o.timestamp);
    }
  }
}
