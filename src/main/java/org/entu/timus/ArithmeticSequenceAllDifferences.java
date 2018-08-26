package org.entu.timus;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.*;
import static java.util.Collections.sort;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class ArithmeticSequenceAllDifferences {

    //        JUDGE_ID: 252544PT
    private final String file = "1452";
    private final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

    public ArithmeticSequenceAllDifferences() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        new ArithmeticSequenceAllDifferences().run();
    }

    void run() throws IOException {
        in.nextToken();
        int n = (int) in.nval;

        int[] input = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            input[i] = (int) in.nval;
        }

        int[] solution = solve(input);

        for (int position : solution) {
            out.print(position);
            out.print(" ");
        }
        out.flush();
    }

    public int[] solve(int[] input) {
        int n = input.length;

        if (n == 0) {
            return new int[]{};

        }
        if (n == 1) {
            return new int[]{1};
        }

        Set<Integer> uniques = stream(input).boxed().collect(toSet());
        int size = uniques.size();
        int[] work = new int[size];
        int pos = -1;
        for (Integer unique : uniques) {
            work[++pos] = unique;
        }

        Map<Integer, Integer> deltasStatistics = new HashMap<>();
        for (int i = 0; i < size - 1; ++i) {
            for (int j = i + 1; j < size; ++j) {
                int delta = Math.abs(work[j] - work[i]);
                Integer statVal = deltasStatistics.get(delta);
                deltasStatistics.put(delta, statVal == null ? 1 : statVal + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> sortedDeltas = new ArrayList<>(deltasStatistics.entrySet());
        sort(sortedDeltas, comparing(Map.Entry::getValue));



        return null;
    }

    private boolean continueSequenceSearch(Map<Integer, int[]> number2pos,
                                           int currentMember,
                                           int sequenceLength,
                                           int maxSequenceLength,
                                           int n) {

        int[] positions = number2pos.get(currentMember);
        return positions != null && (n - positions[1] + sequenceLength > maxSequenceLength);
    }

    private int findNextMemberPosition(int[] source,
                                       int currentMember,
                                       int currentMemberIndex,
                                       int tillIndex) {
        for (int position = currentMemberIndex + 1; position < tillIndex; ++position) {
            if (source[position] > currentMember) {
                return position;
            }
        }
        return -1;
    }

    private final StreamTokenizer in = new StreamTokenizer(new BufferedReader(
            oj ? new InputStreamReader(System.in) : new FileReader(file + "_input.txt")));
    private final PrintWriter out = new PrintWriter(
            oj ? new OutputStreamWriter(System.out) : new FileWriter(file + "_output.txt"));

}
