package sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {3, 12, 6, 7, 40, 35, 8, 4, 22};
        
        shell_sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void shell_sort(int[] arr){
        int N = arr.length;  //数组长度
        // 数组为空或者长度为1不需要排序
        if(arr == null || N < 2){
            return;
        }
        
        for(int h = N; h >= 1; h /= 2){
            // 将数组变为h有序
            for(int i = h; i < N; i++){
                // 将a[i]插入到 a[i-h], a[i-2*h], a[i-3*h]....中
                for(int j = i; j >= h; j -= h){
                    if(arr[j] < arr[j-h]){
                        int temp = arr[j];
                        arr[j] = arr[j-h];
                        arr[j-h] = temp;
                    }
                }
            }
        }
    }
}
