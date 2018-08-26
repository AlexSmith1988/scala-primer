package org.entu.timus;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SquareRoot {
    private SquareRoot() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        new SquareRoot().run();
    }

    private void run() throws IOException {
        DecimalFormat decimalFormat = new DecimalFormat("##########0.0000");
//        decimalFormat.setRoundingMode(RoundingMode.DOWN);

        List<Double> numbers = new ArrayList<>();

        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            numbers.add(Math.sqrt(in.nval));
        }

        Collections.reverse(numbers);

        for (Double number : numbers) {
            out.println(decimalFormat.format(number));
        }

        out.flush();
    }

    //        JUDGE_ID: 252544PT
    private final String file = "problem_1001";
    private final boolean oj = System.getProperty("ONLINE_JUDGE") != null;
    private final StreamTokenizer in = new StreamTokenizer(new BufferedReader(
            oj ? new InputStreamReader(System.in) : new FileReader(file + "_input.txt")));
    private final PrintWriter out = new PrintWriter(
            oj ? new OutputStreamWriter(System.out) : new FileWriter(file + "_output.txt"));
}