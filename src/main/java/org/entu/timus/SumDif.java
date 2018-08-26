package org.entu.timus;

import java.io.*;

public class SumDif {
    public static void main(String[] args) throws IOException {
        new SumDif().run();
    }

    StreamTokenizer in;
    PrintWriter out;

    int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    void run() throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        solve();
        out.flush();
    }

    void solve() throws IOException {
        int a = nextInt();
        int b = nextInt();
        out.print(a + b);
//        out.print(" ");
//        out.println(a - b);
    }
}