package sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {3, 12, 6, 7, 40, 35, 8, 4, 22};
        
        insertion_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertion_sort(int[] arr){
        // ����Ϊ�ջ��߳���Ϊ1����Ҫ����
        if(arr == null || arr.length < 2){
            return;
        }
        
        int N = arr.length;
        for(int i = 1; i < N; i++){
            // ÿ��ѭ������j+1��Ԫ�ز��뵽ǰj��Ԫ���У���֤ǰj+1��Ԫ������
            int temp = arr[i], j = i;
            while(temp < arr[j-1] && j > 0){   // ���ڵ�ǰԪ�ص�ȫ������
                    arr[j] = arr[j-1];
                    j--;
            }
            arr[j] = temp;
        }
    }
}
