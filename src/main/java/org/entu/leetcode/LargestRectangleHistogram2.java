package org.entu.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestRectangleHistogram2 {
    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    static class Solution {
        public int largestRectangleArea(int[] heights) {
            // Marginal conditions
            if (heights == null || heights.length == 0) {
                return 0;
            }

            Map<Integer, Integer> heightReachedIndex = new HashMap<>();
            Set<Integer> heightDescendedIndex = new HashSet<>();

            int maxSquare = 0;
            int previous = heights[0];
            for (int pos = 1; pos < heights.length; ++pos) {
                int current = heights[pos];
                if (current > previous) {
                    heightReachedIndex.put(current, pos);
                    heightDescendedIndex.remove(current);
                } else {
                    maxSquare = Math.max(maxSquare, current * (pos - heightReachedIndex.getOrDefault(current, 0) + 1));
                    heightDescendedIndex.add(current);
                }
                previous = current;
            }

            heightReachedIndex.keySet().removeAll(heightDescendedIndex);
            for (Map.Entry<Integer, Integer> undescended : heightReachedIndex.entrySet()) {
                maxSquare = Math.max(maxSquare, undescended.getKey() * (heights.length - undescended.getValue()));
            }

            return maxSquare;
        }
    }
}
