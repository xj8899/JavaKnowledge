package com.knowledge.sort;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度：最坏 O(n^2) 最好O(n)
 * 空间复杂度：O(1)
 * 排序方式：In-place：占用常数内存，不占用额外内存
 * 稳定性：稳定
 * 插入排序一共会进行（数组长度-1）轮，每一轮的结果如下：
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
        int[] arr = new int[]{0,4,32,46,13,7,100,92,25,18};
        insertionSort2(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }


    public static int[] insertionSort(int[] arr){
        if (arr.length==0){
            return arr;
        }
        //遍历arr
        int current;
        int w = 0;
        for (int i = 1; i < arr.length; i++) {
            w++;
            //向前遍历
            for (int j = i; j > 0 ; j--) {
                w++;
                //获取下标i的值
                current = arr[i]; //
                //前一位下标
                int preIndex = i-1;
                // 如果前一位下标的值大于0 并且 i下标的值小于i-1下标的值
                while(preIndex >0 && current < arr[preIndex]){
                    w++;
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
        System.out.println(w);
        return arr;
    }


    public static int[] insertionSort1(int[] arr){
        if (arr.length==0){
            return arr;
        }
        //1、首字母为有序列表
        //2、将插入的数值缓存起来与依次有序列表比较
        //3、若小于比较的数据，则将比较的数据后移一位
        //4、若大于比较的数据，则插入比较的数据后一位中
        int i,j;
        for ( i = 1; i < arr.length; i++) {
            if (arr[i]<arr[i-1]) {
                int current = arr[i];
                for ( j = i;current < arr[j - 1]; j--) {
                        arr[j] = arr[j - 1];
                }
                arr[j] = current;
            }
        }
        return arr;
    }


    public static int[] insertionSort2(int[] r){
        // r[0]为哨兵，作用存储比对数据
        int n =r.length;


        int span = n/2;
        //分组
        for (int i = 0; i < span; i++) {

        }

        int i,j;
        for (i = 2; i < n; i++) {
            if (r[i]<r[i-1]){
                r[0]=r[i];
                for (j = i-1;r[0]<r[j];j--) {
                    r[j+1] = r[j];
                }
                r[j+1] = r[0];
            }
        }
        return r;
    }



}
