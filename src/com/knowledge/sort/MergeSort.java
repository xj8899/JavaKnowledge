package com.knowledge.sort;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

/**
 * 归并排序
 * 时间复杂度：O(n Log n )
 * 空间复杂度：O(n)
 * 排序方式：Out-place
 * 稳定性：不稳定
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{34,1,19,5,3,89,74,15};
        arr = MergeSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int[] MergeSort(int[] arr){
        if (arr.length < 2 ){
            return arr;
        }
        int mid = arr.length / 2;
        int[] left  = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(MergeSort(left),MergeSort(right));
    }


    public static int[] merge(int[] left,int[]right){
        int[] result = new int[left.length+right.length];

        for (int index = 0, i = 0,j=0; index < result.length; index++) {
            if (i>=left.length){
                result[index] = right[j++];
            }else if (j>= right.length){
                result[index] = left[i++];
            }else if (left[i]>right[j]){
                result[index] = right[j++];
            }else{
                result[index] = left[i++];
            }
        }
        return result;
    }
}
