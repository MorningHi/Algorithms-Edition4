package sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {3, 12, 6, 7, 40, 35, 8, 4, 22};
        
        heap_sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void heap_sort(int[] arr){
        // 数组为空或者长度为1不需要排序
        if(arr == null || arr.length < 2){
            return;
        }
        
        int N = arr.length;
        for(int i = N/2; i >= 0; i--){
            adjust(arr, i, N);  // 通过调整使得初始堆有序
        }
        
        // 交换根节点(保存着最大元素)和最后一个孩子节点，并从堆中删除
        while(N-- > 0){
            int temp = arr[N];
            arr[N] = arr[0];
            arr[0] = temp;
            adjust(arr, 0, N);   // 重新调整数组使得堆有序
        }
    }
    
    private static void adjust(int[] arr, int i, int N){
        while(2*i+1 < N){
            int j = 2 * i + 1; // 当前节点左孩子结点的索引
            if(j+1 < N && (arr[j] < arr[j+1]))   j++;   // 找到最大的孩子节点
            if(arr[i] >= arr[j])   break;   // 表明根节点大于所有的孩子节点，不用交换
            int temp = arr[i];  // 交换最大孩子节点和根节点
            arr[i] = arr[j];
            arr[j] = temp;
            i = j;   
        }
    }
}
