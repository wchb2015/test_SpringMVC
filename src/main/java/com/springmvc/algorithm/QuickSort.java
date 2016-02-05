package com.springmvc.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by wangchongbei on 16-1-28.
 */

/*
基本思想:每次排序的时候设置一个基准点,将小于等于基准点的数全部放到基准点的一边,将大于等于基准点的数全部放到基准点的另一边.
 */
public class QuickSort {

    public static void main(String[] args) {
        int length = 20;
        int maxValue = 20;
        int[] array = new int[length];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(maxValue);
        }
        System.out.println("before:" + Arrays.toString(array));
        quickSort(array, 0, length - 1);
        System.out.println("after:" + Arrays.toString(array));
    }


    // 假设以左边的为基数,那就要从右边开始移动.左为大于基数,右为小于基数..
    public static void quickSort(int[] array, int leftPoint, int rightPoint) {

        if (leftPoint > rightPoint) {
            return;
        }

        int swapTmp;
        int baseNumber = array[leftPoint];// 以左边为基准.
        int i = leftPoint;
        int j = rightPoint;

        while (leftPoint != rightPoint) {

            // 从右边开始向左移动,到找第一个大于基数时停止.
            while (array[rightPoint] <= baseNumber && leftPoint < rightPoint) {
                rightPoint--;
            }

            // 从左边开始向右移动,到找第一个小于基数时停止.
            while (array[leftPoint] >= baseNumber && leftPoint < rightPoint) {
                leftPoint++;
            }

            // 没有相遇时,就交换
            if (leftPoint < rightPoint) {
                swapTmp = array[leftPoint];
                array[leftPoint] = array[rightPoint];
                array[rightPoint] = swapTmp;
            }
        }

        //恢复新一轮的基准,将旧的基准归位,然后又重新定一个新的左边基准位.即将基准数与中间数互换.
        array[i] = array[leftPoint];
        array[leftPoint] = baseNumber;

        //递归左,右两边.
        quickSort(array, i, leftPoint - 1);
        quickSort(array, leftPoint + 1, j);
    }
}
