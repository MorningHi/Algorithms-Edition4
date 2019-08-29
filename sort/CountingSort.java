package sort;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {-3, 12, 6, 7, -11, 40, 35, 7, 8, 4, 12, 22};
        
        counting_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void counting_sort(int[] arr){
        // ����Ϊ�ջ��߳���Ϊ1����Ҫ����
        if(arr == null || arr.length < 2){
            return;
        }
        
        int maxValue = arr[0], minValue = arr[0];   // �ҳ������Сֵ
        for(int n : arr){
            if(n > maxValue)    maxValue = n;
            else if(n < minValue)    minValue = n;
        }
        
        int bucketLen = maxValue - minValue + 1;   //  ��Ҫ��Ͱ�ĸ���
        int[] bucket = new int[bucketLen];
        for(int n : arr){
            bucket[n-minValue]++;    // Ͱ��ÿ��λ����������ԭ�����е���(��ǰͰ����+minValue)�����ĸ���
        }
        
        int sortedIndex = 0;   // ��Ͱ���Ԫ�طŻ�ԭ����
        for(int i = 0; i < bucketLen; i++){
            while(bucket[i]-- > 0){
                arr[sortedIndex++] = i + minValue;
            }
        }
    }
}
