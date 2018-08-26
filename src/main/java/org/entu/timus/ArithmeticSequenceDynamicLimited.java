package org.entu.timus;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArithmeticSequenceDynamicLimited {

    //        JUDGE_ID: 252544PT
    private final String file = "1452";
    private final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

    public ArithmeticSequenceDynamicLimited() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        new ArithmeticSequenceDynamicLimited().run();
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

    class Companion {
        public int originalPosition;
        public int sortedPosition;
        public int[] deltas;

        public Companion(int originalPosition, int deltaLimit) {
            this.originalPosition = originalPosition;
            this.deltas = new int[deltaLimit];
        }
    }

    public int[] solve(int[] input) {
        int precalulated = 0;
        int precalulatedStored = 0;

        int deltasLimit = 25;

        int storingLimit = 1;

        int n = input.length;

        if (n == 0) {
            return new int[]{};

        }
        if (n == 1) {
            return new int[]{1};
        }

        Map<Integer, Companion> number2pos = new HashMap<>();
        for (int pos = 0; pos < n; ++pos) {
            number2pos.put(input[pos], new Companion(pos, deltasLimit));
        }

        n = number2pos.keySet().size();
        int[] sorted = new int[n];
        int pos = -1;
        for (Integer unique : number2pos.keySet()) {
            sorted[++pos] = unique;
        }
        Arrays.sort(sorted);
        for (int i = 0; i < n; ++i) {
            number2pos.get(sorted[i]).sortedPosition = i;
        }

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

                Companion companion = number2pos.get(secondMember);

                int sequenceLength = 0;

                boolean canBeStored = deltasLimit > delta;
                if (canBeStored) {
                    int storedSequence = companion.deltas[delta];
                    if (storedSequence > 0) {
                        sequenceLength = storedSequence;
                        precalulated++;
                    }
                }

                if (sequenceLength == 0) {
                    sequenceLength = 2;
                    for (int currentMember = secondMember + delta;
                         continueSequenceSearch(number2pos, currentMember, sequenceLength,
                                 maxSequenceLength, n);
                         currentMember += delta, ++sequenceLength) {

                        if (canBeStored) {
                            int storedSeq = number2pos.get(currentMember).deltas[delta];
                            if (storedSeq > 0) {
                                sequenceLength += storedSeq;
                                storedSeq++;
                                break;
                            }
                        }
                    }

                    if (canBeStored) {
                        companion.deltas[delta] = sequenceLength;
                        precalulatedStored++;

                        if (sequenceLength > storingLimit) {
                            int current = secondMember + delta * (storingLimit - 3);
                            for (int i = storingLimit; i < sequenceLength; ++i) {
                                number2pos.get(current += delta).deltas[delta] = sequenceLength - i;
                            }
                        }
                    }
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
            results[sequencePos] = number2pos.get(currentMember).originalPosition + 1;
        }

//        System.out.println("Precalculated used: " + precalulated);
//        System.out.println("Precalculated stored : " + precalulatedStored);

        return results;
    }

    private boolean continueSequenceSearch(Map<Integer, Companion> number2pos,
                                           int currentMember,
                                           int sequenceLength,
                                           int maxSequenceLength,
                                           int n) {
        Companion companion = number2pos.get(currentMember);
        return companion != null && (n - companion.sortedPosition + sequenceLength > maxSequenceLength);
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