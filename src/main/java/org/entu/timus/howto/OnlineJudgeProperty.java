package org.entu.timus.howto;

import java.io.*;

public class OnlineJudgeProperty {

    //        JUDGE_ID: 252544PT
    private final String file = "problem_";
    private final boolean oj = System.getProperty("ONLINE_JUDGE") != null;
    private final StreamTokenizer in = new StreamTokenizer(new BufferedReader(
            oj ? new InputStreamReader(System.in) : new FileReader(file + "_input.txt")));
    private final PrintWriter out = new PrintWriter(
            oj ? new OutputStreamWriter(System.out) : new FileWriter(file + "_output.txt"));

    public OnlineJudgeProperty() throws IOException {
    }
}
