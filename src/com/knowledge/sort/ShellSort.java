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
        shellSort(arr,arr.length);
        Arrays.stream(arr).forEach(System.out::println);
    }


    public static int[] shellSort(int[] a,int len){
        int i;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (i = gap; i < len; i++) {
                int insertIndex = a[i];
                int insertValue = a[insertIndex];
                while(insertIndex-gap >=0 && insertValue<a[insertIndex-gap]){
                    a[insertIndex] = a[insertIndex-gap];
                    insertIndex -= gap;
                }
                a[insertIndex] = insertValue;
            }
        }
        return a;
    }



 
}
