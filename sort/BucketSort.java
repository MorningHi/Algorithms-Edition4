package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {

    public static void main(String[] args) {
        int[] arr = {-7, 51, 3, 121, -3, 32, 21, 43, 4, 25, 56, 77, 16, 22, 87, 56, -10, 68, 99, 70};
        
        bucket_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bucket_sort(int[] arr){
        // 数组为空或者长度为1不需要排序
        if(arr == null || arr.length < 2){
            return;
        }
        
        int bucketSize = 10;   // 设定桶的容量
        int maxValue = arr[0], minValue = arr[0];   // 找出最大最小值
        for(int n : arr){
            if(n > maxValue)    maxValue = n;
            else if(n < minValue)    minValue = n;
        }
        
        // 创建桶的集合
        ArrayList<LinkedList<Integer>> buckets = new ArrayList<>();
        int bucketLen = (int)Math.floor((maxValue - minValue) / bucketSize) + 1;   //  需要的桶的个数
        for(int i = 0; i < bucketLen; i++){
            buckets.add(new LinkedList<Integer>());
        }
        
        //  将数组中的元素根据所处区间放到桶中
        for(int n : arr){
            int index = (int)Math.floor((n - minValue) / bucketSize);  // 确定当前元素应该放到第几个桶中
            buckets.get(index).add(n);
        }
        
        // 对每个桶中的元素进行排序(使用插入排序)
        for(LinkedList<Integer> bucket : buckets){
            if(bucket.size() > 1){ 
                Collections.sort(bucket); // 桶中元素大于1才需要排序
            }
        }
        
        // 从桶中按顺序取出元素放回数组
        int index = 0;
        for(LinkedList<Integer> bucket : buckets){
            for(int n : bucket){
                arr[index++] = n;
            }
        }
    }
}
