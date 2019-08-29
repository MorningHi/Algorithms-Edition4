package sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {3, 12, 6, 7, 40, 35, 8, 4, 22};
        
        shell_sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void shell_sort(int[] arr){
        int N = arr.length;  //���鳤��
        // ����Ϊ�ջ��߳���Ϊ1����Ҫ����
        if(arr == null || N < 2){
            return;
        }
        
        for(int h = N; h >= 1; h /= 2){
            // �������Ϊh����
            for(int i = h; i < N; i++){
                // ��a[i]���뵽 a[i-h], a[i-2*h], a[i-3*h]....��
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
