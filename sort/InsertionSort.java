package sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {3, 12, 6, 7, 40, 35, 8, 4, 22};
        
        insertion_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertion_sort(int[] arr){
        // 数组为空或者长度为1不需要排序
        if(arr == null || arr.length < 2){
            return;
        }
        
        int N = arr.length;
        for(int i = 1; i < N; i++){
            // 每次循环将第j+1个元素插入到前j个元素中，保证前j+1个元素有序
            int temp = arr[i], j = i;
            while(temp < arr[j-1] && j > 0){   // 大于当前元素的全部后移
                    arr[j] = arr[j-1];
                    j--;
            }
            arr[j] = temp;
        }
    }
}
