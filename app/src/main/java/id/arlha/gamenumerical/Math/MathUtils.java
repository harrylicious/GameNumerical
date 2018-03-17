package id.arlha.gamenumerical.Math;

import java.util.Random;

/**
 * Created by Gentong on 18/03/2018.
 */

public class MathUtils {
    int min = 1, max = 10;
    Random random = new Random();
    String level = "";

    protected int generateValueA(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    protected int generateValueB(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    protected int generateValueC(int min, int max) {
        return random.nextInt(max - min) + min;
    }



    //region Addition
    protected String[] generateCorrectQuestionForAddition() {
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

    protected String[] generateWrongQuestionForAddition() {
        int a, b, c;
        String[] arr = new String[5];
        for (int i = 0; i < 5; i++) {
            a = generateValueA(min, max);
            b = generateValueB(min, max);
            c = generateValueC(min, max);

            arr[i] = a + " + " + b + " = " + c;
        }
        return arr;
    }
    //endregion

    //region Allevation
    protected String[] generateCorrectQuestionForAllevation() {
        int a, b, c;
        String[] arr = new String[10];
        for (int i = 0; i < 10; i++) {
            a = generateValueA(min, max);
            b = generateValueB(min, max);
            c = a - b;

            arr[i] = a + " - " + b + " = " + c;
        }
        return arr;
    }

    protected String[] generateWrongQuestionForAllevation() {
        int a, b, c;
        String[] arr = new String[5];
        for (int i = 0; i < 5; i++) {
            a = generateValueA(min, max);
            b = generateValueB(min, max);
            c = generateValueC(min, max);

            arr[i] = a + " - " + b + " = " + c;
        }
        return arr;
    }
    //endregionAllevation

    //region Multiplication
    protected String[] generateCorrectQuestionForMultiplication() {
        int a, b, c;
        String[] arr = new String[10];
        for (int i = 0; i < 10; i++) {
            a = generateValueA(min, max);
            b = generateValueB(min, max);
            c = a * b;

            arr[i] = a + " x " + b + " = " + c;
        }
        return arr;
    }

    protected String[] generateWrongQuestionForMultiplication() {
        int a, b, c;
        String[] arr = new String[10];
        for (int i = 0; i < 10; i++) {
            a = generateValueA(min, max);
            b = generateValueB(min, max);
            c = generateValueC(min, max);

            arr[i] = a + " x " + b + " = " + c;
        }
        return arr;
    }
    //endregionAllevation

    //region Division
    protected String[] generateCorrectQuestionForDivision() {
        int a, b, c;
        String[] arr = new String[10];
        for (int i = 0; i < 10; i++) {
            a = generateValueA(min, max);
            b = generateValueB(min, max);
            c = a / b;

            arr[i] = a + " : " + b + " = " + c;
        }
        return arr;
    }

    protected String[] generateWrongQuestionForDivision() {
        int a, b, c;
        String[] arr = new String[10];
        for (int i = 0; i < 10; i++) {
            a = generateValueA(min, max);
            b = generateValueB(min, max);
            c = generateValueC(min, max);

            arr[i] = a + " : " + b + " = " + c;
        }
        return arr;
    }
    //endregionAllevation

    protected String[] mergeAndShuffleQuestion() {
        if (level.equals(CategoryQuestions.Addition)) {

        }
        String[] arr = generateCorrectQuestionForAllevation();
        String[] arr1 = generateWrongQuestionForAllevation();
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

    protected String[] shuffleQuestions(String[] arr) {
        int[] order = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] questions = new String[10];
        for (int i=0; i<10; i++) {
            questions[i] = arr[random.nextInt(9) + 1];
        }
        return questions;
    }
}
