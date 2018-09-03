package org.entu.leetcode;

public class LargetsRectangleInHistogram {

    class Solution {
        public int largestRectangleArea(int[] heights) {
            // Marginal conditions
            if (heights == null || heights.length == 0) {
                return 0;
            }


            int globalMaxSquare = 0;

            int currentPos = 0;
            // For each local hill
            for (int localStart;
                 (localStart = findLocalStart(currentPos, heights)) < heights.length;
            ) {
                int localEnd = findLocalEnd(localStart, heights);

                // find hill maximum
                int hillMax = heights[localStart];
                int hillMaxPos = localStart;
                for (int i = localStart; i <= localEnd; ++i) {
                    if (hillMax < heights[i]) {
                        hillMax = heights[i];
                        hillMaxPos = i;
                    }
                }

                int hillMaxSquare = hillMax;
                for (int i = hillMaxPos, j = hillMaxPos; i <= localEnd || j >= localStart; ) {
                    final int square;
                    if (i > localEnd || (j >= localStart && (heights[i + 1] < heights[j - 1])))
                        globalMaxSquare = Math.max(globalMaxSquare, (--j - i + 1) * heights[j]);
                    else
                        square = (j - ++i + 1) * heights[i];
//                    if (square >= hillMaxSquare) {
//                        hillMaxSquare = square;
//                    }
                }

                if (globalMaxSquare <= hillMaxSquare)

                globalMaxSquare = Math.max(globalMaxSquare, hillMaxSquare);
            }

            return -1;
        }

        private int findLocalStart(int currentPos, int[] heights) {
            for (; heights[currentPos++] == 0; ) {

            }
            return currentPos;
        }

        private int findLocalEnd(int currentPos, int[] heights) {
            int currentLimit = heights.length - 1;
            for (int current = heights[currentPos], next;
                 currentPos < currentLimit
                         && current <= (next = heights[currentPos + 1]);
                 ++currentPos, current = next) {
            }

            if (currentLimit == currentPos)
                return currentPos;

            for (int current = heights[currentPos], next;
                 currentPos < currentLimit
                         && current > (next = heights[currentPos + 1]);
                 ++currentPos, current = next) {
            }

            return currentPos;
        }
    }
}
