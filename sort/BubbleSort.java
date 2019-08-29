package sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        
        bubble_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void bubble_sort(int[] arr){
        // 数组为空或者长度为1不需要排序
        if(arr == null || arr.length < 2){
            return;
        }
        
        int N = arr.length;
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < N - i - 1; j++){
                // 如果相邻元素顺序不对则交换
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
