package com.knowledge.sort;

import java.util.Arrays;


/**
 * 选择排序
 * 定义:选择排序就是不断地从未排序的元素中选择最大（或最小）的元素放入已排好序的元素集合中，直到未排序中仅剩一个元素为止
 * 时间复杂度：O(N^2)
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,5,9,3};
        selectSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }


    public static int[] selectSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<arr[i]){
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        return arr;
    }



}
