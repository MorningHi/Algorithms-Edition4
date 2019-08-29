package sort;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {-3, 12, 6, 7, -11, 40, 35, 7, 8, 4, 12, 22};
        
        counting_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void counting_sort(int[] arr){
        // 数组为空或者长度为1不需要排序
        if(arr == null || arr.length < 2){
            return;
        }
        
        int maxValue = arr[0], minValue = arr[0];   // 找出最大最小值
        for(int n : arr){
            if(n > maxValue)    maxValue = n;
            else if(n < minValue)    minValue = n;
        }
        
        int bucketLen = maxValue - minValue + 1;   //  需要的桶的个数
        int[] bucket = new int[bucketLen];
        for(int n : arr){
            bucket[n-minValue]++;    // 桶中每个位置用来计数原数组中等于(当前桶索引+minValue)的数的个数
        }
        
        int sortedIndex = 0;   // 将桶里的元素放回原数组
        for(int i = 0; i < bucketLen; i++){
            while(bucket[i]-- > 0){
                arr[sortedIndex++] = i + minValue;
            }
        }
    }
}
