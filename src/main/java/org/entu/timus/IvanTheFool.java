package org.entu.timus;

import java.io.*;

public class IvanTheFool {

    //        JUDGE_ID: 252544PT
    private final String file = "problem_1082";
    private final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

    private IvanTheFool() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        new IvanTheFool().run();
    }

    void run() throws IOException {
        in.nextToken();
        long n = (long) in.nval;
        for (int i = 1; i < n + 1; ++i) {
            out.print(i);
            out.print(" ");
        }
        out.flush();
    }

    private final StreamTokenizer in = new StreamTokenizer(new BufferedReader(
            oj ? new InputStreamReader(System.in) : new FileReader(file + "_input.txt")));
    private final PrintWriter out = new PrintWriter(
            oj ? new OutputStreamWriter(System.out) : new FileWriter(file + "_output.txt"));


}