package org.entu.timus;

import org.agrona.collections.Int2IntHashMap;

import java.io.*;
import java.util.Arrays;

public class ArithmeticSequenceOptimized {

    //        JUDGE_ID: 252544PT
    private final String file = "1452";
    private final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

    public ArithmeticSequenceOptimized() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        new ArithmeticSequenceOptimized().run();
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

        Int2IntHashMap number2pos = new Int2IntHashMap(4000, 0.75f, -1);
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

        for (int firstPos = 0; firstPos < n - maxSequenceLength; ++firstPos) {
            int firstMember = sorted[firstPos];

            for (int secondPos = firstPos + 1; secondPos < n - maxSequenceLength + 1; ++secondPos) {
                int secondMember = sorted[secondPos];
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

    private final StreamTokenizer in = new StreamTokenizer(new BufferedReader(
            oj ? new InputStreamReader(System.in) : new FileReader(file + "_input.txt")));
    private final PrintWriter out = new PrintWriter(
            oj ? new OutputStreamWriter(System.out) : new FileWriter(file + "_output.txt"));

}
