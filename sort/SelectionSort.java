package sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {3, 12, 6, 7, 40, 35, 8, 4, 22};
        
        selection_sort(arr);
        System.out.println(Arrays.toString(arr));

    }
    
    public static void selection_sort(int[]  arr){
        // ����Ϊ�ջ��߳���Ϊ1����Ҫ����
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){
            int min = i;  // ��¼��Сֵ������
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            // ������ǰֵ����Сֵ
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

}
