package sort;

import java.util.Arrays;

public class MergeSort {
    private static int[] aux;   //辅助数组
    
    public static void main(String[] args) {
        int[] arr = {3, 12, 6, 7, 40, 35, 8, 4, 22};
        
        sortBU(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    // 自顶向下的归并排序
    public static void sortTD(int[] arr){
        // 数组为空或者长度为1不需要排序
        if(arr == null || arr.length < 2){
            return;
        }
        
        aux = new int[arr.length];   // 给辅助数组分配和原数组大小相同的空间
        sort(arr, 0, arr.length - 1);
    }
    
    private static void sort(int[] arr, int lo, int hi){
        if(hi <= lo){
            return;
        }
        int mid = (lo + hi) / 2;
        sort(arr, lo, mid);   // 对左半边进行排序
        sort(arr, mid+1, hi); // 对右半边进行排序
        // 由于左右两边此时都是有序的，所以可以通过判断arr[mid]<=arr[mid+1]来跳过merge()过程
        if(arr[mid] <= arr[mid+1]){
            return;
        }
        merge(arr, lo, mid ,hi);  //合并左右两部分
    }
    
    private static void merge(int[] arr, int lo, int mid, int hi){
        int i = lo, j = mid + 1;
        // 复制arr[lo]... arr[hi]到辅助数组
        for(int k = lo; k <= hi; k++){
            aux[k] = arr[k];
        }
        
        for(int k = lo; k <= hi; k++){
            if(i > mid)   arr[k] = aux[j++];   // 左半边用尽则直接取右半边元素
            else if(j > hi)   arr[k] = aux[i++];   // 右半边用尽则直接取左半边元素
            else if(aux[j] < aux[i])   arr[k] = aux[j++];   // 左边元素大于右边元素， 取右边元素
            else  arr[k] = aux[i++];   // 右边元素大于等于左边元素，取左边元素
        }
    }
    
    
    // 自底向上的归并排序
    public static void sortBU(int[] arr){
        // 数组为空或者长度为1不需要排序
        if(arr == null || arr.length < 2){
            return;
        }
        
        int N = arr.length;
        aux = new int[N];   // 给辅助数组分配和原数组大小相同的空间
        for(int sz = 1; sz < N; sz += sz){
            for(int lo = 0; lo < N-sz; lo += sz+sz){
                merge(arr, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }
}
