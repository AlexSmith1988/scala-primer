package org.entu.timus;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class ArithmeticSequenceJudge {

    public static void main(String[] args) throws IOException {
        int[] test = {7, 3, 2, 3, 5, 9};
        int[] result = {4, 5, 1, 6};

        ArithmeticSequence metric = new ArithmeticSequence();
        ArithmeticSequenceOptimized subject = new ArithmeticSequenceOptimized();

        if (!Arrays.equals(result, metric.solve(test))) {
            throw new RuntimeException("metric does not pass the test");
        }
        if (!Arrays.equals(result, subject.solve(test))) {
            throw new RuntimeException("subject does not pass the test");
        }

        Random random = new Random();
        int[] loadTest = random.ints(2000, 1, 2000).toArray();

        long startMetric = System.currentTimeMillis();
        int[] metricResult = metric.solve(loadTest);
        long startSubject = System.currentTimeMillis();
        int[] subjectResult = subject.solve(loadTest);
        long endSubject = System.currentTimeMillis() - startSubject;

        System.out.println("Metric time " + (startSubject - startMetric) +
                " msec, Subject time: " + endSubject + " msec");

        if (!Arrays.equals(metricResult, subjectResult)) {
            throw new RuntimeException("subject does not produce same as metric");
        }

    }
}
