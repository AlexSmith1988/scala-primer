package org.entu.timus;

import java.io.*;

public class FireCircle {

    //        JUDGE_ID: 252544PT
    private final String file = "1490";
    private final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

    private FireCircle() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        new FireCircle().run();
    }

    void run() throws IOException {
        in.nextToken();
        long r = (long) in.nval;

       /* long ns = r;
        double r2 = r * r;
        for (int y = 1; y < r; ++y) {
            ns += Math.ceil(Math.sqrt(r2 - y * y));
        }*/

//        out.println(4 * ns);
        out.println(r == 1 ? 4 : longRun(r));
//        out.println(Math.PI * r2);
        out.flush();
    }

    void test() throws IOException {
        for (long r = 0; r < 10000; ++r) {
            long ns = r;
            double r2 = r * r;
            for (int y = 1; y < r; ++y) {
                ns += Math.ceil(Math.sqrt(r2 - y * y));
            }

            long lr = longRun(r);
            if (lr != 4 * ns) {
                System.out.println(r + " " + 4 * ns + " " + lr);
            }
//            out.println(4 * ns);
//            out.println(longRun(r));
//            out.println(Math.PI * r2);
        }
//        out.flush();
    }

    long longRun(final long rl) {
        final int r = (int) rl;
        long sq[] = new long[r + 1];
        for (long i = 0; i <= r; ++i) {
            sq[(int) i] = i * i;
        }

        long sqr = sq[r];
        int prev = r;
        long result = 0;
        for (int y = 0; y < r; ++y) {
            long sqy = sq[y];
            for (int x = prev; x > 0; --x) {
                if (sqy + sq[x] < sqr) {
                    result += x + 1;
                    prev = x;
                    break;
                }
            }
        }
        return result * 4;
    }

    private final StreamTokenizer in = new StreamTokenizer(new BufferedReader(
            oj ? new InputStreamReader(System.in) : new FileReader(file + "_input.txt")));
    private final PrintWriter out = new PrintWriter(
            oj ? new OutputStreamWriter(System.out) : new FileWriter(file + "_output.txt"));

}