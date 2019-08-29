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
        // ����Ϊ�ջ��߳���Ϊ1����Ҫ����
        if(arr == null || arr.length < 2){
            return;
        }
        
        int bucketSize = 10;   // �趨Ͱ������
        int maxValue = arr[0], minValue = arr[0];   // �ҳ������Сֵ
        for(int n : arr){
            if(n > maxValue)    maxValue = n;
            else if(n < minValue)    minValue = n;
        }
        
        // ����Ͱ�ļ���
        ArrayList<LinkedList<Integer>> buckets = new ArrayList<>();
        int bucketLen = (int)Math.floor((maxValue - minValue) / bucketSize) + 1;   //  ��Ҫ��Ͱ�ĸ���
        for(int i = 0; i < bucketLen; i++){
            buckets.add(new LinkedList<Integer>());
        }
        
        //  �������е�Ԫ�ظ�����������ŵ�Ͱ��
        for(int n : arr){
            int index = (int)Math.floor((n - minValue) / bucketSize);  // ȷ����ǰԪ��Ӧ�÷ŵ��ڼ���Ͱ��
            buckets.get(index).add(n);
        }
        
        // ��ÿ��Ͱ�е�Ԫ�ؽ�������(ʹ�ò�������)
        for(LinkedList<Integer> bucket : buckets){
            if(bucket.size() > 1){ 
                Collections.sort(bucket); // Ͱ��Ԫ�ش���1����Ҫ����
            }
        }
        
        // ��Ͱ�а�˳��ȡ��Ԫ�طŻ�����
        int index = 0;
        for(LinkedList<Integer> bucket : buckets){
            for(int n : bucket){
                arr[index++] = n;
            }
        }
    }
}
