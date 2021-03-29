package com.knowledge.sort;

/**
 * 冒泡排序算法测试
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        //如果入参的参数长度为0,返回入参参数
        if (array.length == 0){
            return array;
        }
        //第一层遍历
        for (int i = 0; i < array.length; i++) {
            //第二层遍历  假设array长度为n,遍历的次数为m 进行n-m
            for (int j = 0; j < array.length - 1 - i; j++) {
                //如果下表j+1的参数大于下表j的参数
                if (array[j + 1] < array[j]) {
                    //创建局部变量temp来存储j+1的参数
                    int temp = array[j + 1];
                    //进行参数交换
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }


    public static void main(String[] args) {
        int[] no = new int[]{1,6,3,9,12,5,2};
        for (int tb : bubbleSort(no,no.length)) {
            System.out.println(tb);
        }
    }


    public static int[] bubbleSort(int[] arr,int len)
    {
        int j,tmp;
        for (int i = 0; i < len; i++) {
            for (j = 1 ; j <len-i ; j++) {
                if (arr[j-1]>arr[j]){
                    tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
        return arr;
    }



}
