package org.entu.timus;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArithmeticSequenceOnSet {

    //        JUDGE_ID: 252544PT
    private final String file = "1452";
    private final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

    public ArithmeticSequenceOnSet() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        new ArithmeticSequenceOnSet().run();
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

        Map<Integer, Integer> number2pos = new HashMap<>();
        for (int pos = 0; pos < n; ++pos) {
            number2pos.put(input[pos], pos);
        }

        n = number2pos.keySet().size();
        int[] sorted = new int[n];
        int pos = -1;
        for (Integer unique : number2pos.keySet()) {
            sorted[++pos] = unique;
        }
        Arrays.sort(sorted);

        int maxSequenceLength = 1;
        int maxSequenceDelta = 0;
        int maxSequenceStart = sorted[0];

        for (int firstMemberPos = 0, firstMember;
             firstMemberPos != -1;
             firstMemberPos =
                     findNextMemberPosition(sorted, firstMember, firstMemberPos, n - 2)) {
            firstMember = sorted[firstMemberPos];

            for (int secondMemberPos =
                 findNextMemberPosition(sorted, firstMember, firstMemberPos, n - 1),
                 secondMember;
                 secondMemberPos != -1;
                 secondMemberPos =
                         findNextMemberPosition(sorted, secondMember, secondMemberPos, n - 1)) {
                secondMember = sorted[secondMemberPos];
                int delta = secondMember - firstMember;

                int sequenceLength = 2;
                for (int currentMember = secondMember + delta;
                     number2pos.containsKey(currentMember);
                     currentMember += delta, ++sequenceLength) {
                }

                if (sequenceLength > maxSequenceLength) {
                    maxSequenceStart = firstMember;
                    maxSequenceDelta = delta;
                    maxSequenceLength = sequenceLength;
                }
            }
        }

        int[] results = new int[maxSequenceLength];
        out.println(maxSequenceLength);
        for (int currentMember = maxSequenceStart, sequencePos = 0;
             sequencePos < maxSequenceLength;
             ++sequencePos, currentMember += maxSequenceDelta) {
            results[sequencePos] = number2pos.get(currentMember) + 1;
        }

        return results;
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