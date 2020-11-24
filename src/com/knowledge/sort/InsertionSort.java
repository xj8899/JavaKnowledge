package com.knowledge.sort;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度：最坏 O(n^2) 最好O(n)
 * 空间复杂度：O(1)
 * 排序方式：In-place：占用常数内存，不占用额外内存
 * 稳定性：稳定
 * 步骤：
 * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 * 步骤1: 从第一个元素开始，该元素可以认为已经被排序；
 * 步骤2: 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 步骤3: 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 步骤4: 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 步骤5: 将新元素插入到该位置后；
 * 步骤6: 重复步骤2~5。
 */
public class InsertionSort {


    public static void main(String[] args) {
        int[] arr = new int[]{1,4,32,46,13,7,100,92,25,18};
        insertionSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }


    public static int[] insertionSort(int[] arr){
        if (arr.length==0){
            return arr;
        }
        //遍历arr
        int current;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 ; j--) {
                current = arr[i];
                int preIndex = i-1;
                while(preIndex >0 && current < arr[preIndex]){
                    arr[preIndex+1] = arr[preIndex];
                    preIndex -- ;
                }
                arr[preIndex+1] = current;
//                if(arr[j]<arr[j-1]){
//                    int tmp = arr[j];
//                    arr[j] = arr[j-1];
//                    arr[j-1] = tmp;
//                }
            }
        }
        return arr;
    }


}
