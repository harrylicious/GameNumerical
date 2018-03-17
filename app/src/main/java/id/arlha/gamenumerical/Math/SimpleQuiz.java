package id.arlha.gamenumerical.Math;

import java.util.List;
import java.util.Random;

import id.arlha.gamenumerical.Math.MathUtils;

/**
 * Created by Gentong on 03/03/2018.
 */

public class SimpleQuiz {
    MathUtils math = new MathUtils();
    int min = 1, max = 10;
    Random random = new Random();

    protected int generateValueA(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    protected int generateValueB(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    protected int generateValueC(int min, int max) {
        return random.nextInt(max - min) + min;
    }



    protected String[] generateCorrectQuestion() {
        int a, b, c;
        String[] arr = new String[10];
        for (int i = 0; i < 10; i++) {
            a = generateValueA(min, max);
            b = generateValueB(min, max);
            c = a + b;

            arr[i] = a + " + " + b + " = " + c;
        }
        return arr;
    }

    protected String[] generateWrongQuestion() {
        int a, b, c;
        String[] arr = new String[10];
        for (int i = 0; i < 10; i++) {
            a = generateValueA(min, max);
            b = generateValueB(min, max);
            c = generateValueC(min, max);

            arr[i] = a + " + " + b + " = " + c;
        }
        return arr;
    }

    public String[] mergeAndShuffleQuestion() {
        String[] arr = math.generateCorrectQuestionForMultiplication();
        String[] arr1 = math.generateWrongQuestionForMultiplication();
        String[] questions = new String[10];

        int pos = 0;
        for (int i = 0; i<10; i++) {
            if (i % 2 == 0) {
                questions[i] = arr[i];
            }
            else {
                questions[i] = arr1[pos];
                pos++;
            }
        }

        return questions;
    }

    public String[] shuffleQuestions(String[] arr) {
        int r;
        String[] questions = new String[10];
        for (int i=0; i<10; i++) {
           r = random.nextInt(9) + 1;
            questions[i] = arr[r];
        }
        return questions;
    }
}
