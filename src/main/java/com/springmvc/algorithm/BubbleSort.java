package com.springmvc.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by wangchongbei on 16-1-28.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int length = 10;
        int maxValue = 20;
        int[] array = new int[length];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(maxValue);
        }
        System.out.println("before: " + Arrays.toString(array));
        bubbleSort(array);
        System.out.println("after: " + Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        int tmp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                System.out.println(i + "_____" + j);
                if (array[j] < array[j + 1]) {//如果前一个比后一个小,则进行交换.这样子就可以是从大到小.
                    System.out.println(array[j] + "_#####_" + array[j + 1]);
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }


}
