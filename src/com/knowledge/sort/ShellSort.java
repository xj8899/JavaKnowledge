package com.knowledge.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 算法分析：
 * 最佳情况：T(n) = O(nlog2 n)
 * 最坏情况：T(n) = O(nlog2 n)
 * 平均情况：T(n) =O(nlog2n)
 */
public class ShellSort {
    

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,14,36,20,49,27,99,61,77};
        shellSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int[] shellSort(int[] arr){
        int len = arr.length;
        //gap 组数
        int tmp,gap =len/2;
        //组数大于0
        while (gap>0){
            //循环次数为组数
            for (int i = gap; i < len; i++) {
                tmp = arr[i];
                int preIndex =  i - gap;
                //从第 len/2 开始  与其前gap位进行对比
                if (preIndex >= 0 && arr[preIndex]>tmp){
                    //组内参数对比
                    arr[preIndex+gap] = arr[preIndex];
                    arr[preIndex] = tmp;
                }
            }
            gap /= 2;
        }
        return arr;
    }

    public static int[] ShellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
 
}
