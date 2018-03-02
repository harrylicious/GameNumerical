package id.arlha.gamenumerical;

import java.util.Random;

/**
 * Created by Gentong on 25/02/2018.
 */

public class Utils {

    static int[] generateRandomNumberA() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int rand=0; rand<=9; rand++) {
            random.nextInt(rand + 1);
            int hasil = random.nextInt();

            arr[rand] = Integer.parseInt(String.valueOf(hasil).substring(1,2));
        }
        return arr;
    }

    static int[] generateRandomNumberB() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int rand=10; rand<=19; rand++) {
            random.nextInt(rand);
            int hasil = random.nextInt();

            arr[rand] = Integer.parseInt(String.valueOf(hasil).substring(1,2));
        }
        return arr;
    }

    static int[] generateRandomNumberHasil() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int rand=20; rand<=29; rand++) {
            random.nextInt(rand + 1);
            int hasil = random.nextInt();

            arr[rand] = Integer.parseInt(String.valueOf(hasil).substring(1,2));
        }
        return arr;
    }

    public  int[] mData() {
        int[] arr = new int[10];
        Random rnd = new Random();
        for (int i = 1; i < arr.length; i++) {
            arr[i] = rnd.nextInt(arr.length);
        }
        return arr;
    }
}
