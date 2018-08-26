package org.entu.timus;

import java.io.*;

public class Scolarships {

    /*
    Если у Васи не будет стипендии, выведите «None».
    Если у него будет обычная стипендия, выведите «Common»,
    если повышенная — «High»,
    если именнная — «Named».
Примеры
исходные данные	результат
3
5
5
4
     */


    //        JUDGE_ID: 252544PT
    private final String file = "problem_2056";
    private final boolean oj = System.getProperty("ONLINE_JUDGE") != null;

    private Scolarships() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        new Scolarships().run();
    }

    private void run() throws IOException {
        in.nextToken();
        int examsAmount = (int) in.nval;
        int sum = 0;
        boolean allFives = true;
        for (int i = 0; i < examsAmount; ++i) {
            in.nextToken();
            int current = (int) in.nval;
            if (current == 3) {
                out.println("None");
                out.flush();
                return;
            } else if (current != 5) {
                allFives = false;
            }

            sum += in.nval;
        }
        if (allFives) {
            out.println("Named");
        } else {
            double result = 1.0d * sum / examsAmount;
            out.println(result < 4.5 ? "Common" : "High");
        }
        out.flush();
    }

    private final StreamTokenizer in = new StreamTokenizer(new BufferedReader(
            oj ? new InputStreamReader(System.in) : new FileReader(file + "_input.txt")));
    private final PrintWriter out = new PrintWriter(
            oj ? new OutputStreamWriter(System.out) : new FileWriter(file + "_output.txt"));


}