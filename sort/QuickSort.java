package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3, 12, 8, 6, 7, 7, 8, 40, 35, 8, 8, 4, 22};
        
        quick_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quick_sort(int[] arr){
        // 数组为空或者长度为1不需要排序
        if(arr == null || arr.length < 2){
            return;
        }
//        sort(arr, 0, arr.length-1);
        quick3way_sort(arr, 0, arr.length-1);
    }
    
    private static void sort(int[] arr, int lo, int hi){
        if(lo >= hi)  return;
        int j = partition(arr, lo, hi);  // 切分数组
        sort(arr, lo, j-1);
        sort(arr, j+1, hi);
    }
    
    private static void quick3way_sort(int[] arr, int lo, int hi){
        if(hi <= lo) return;  // lo>=hi说明当前部分已经不需要切分排序了
        int lt = lo, i = lo+1, gt = hi;
        int v = arr[lo];   // 切分元素
        while(i <= gt){
            if(arr[i] < v)  swap(arr, i++, lt++);
            else if(arr[i] > v)  swap(arr, i, gt--);
            else i++;
        }
        // while循环执行完后，arr[lo...lt-1] < a[lt...gt] < a[gt+1...hi]
        quick3way_sort(arr, lo, lt-1);  // 然后对除了切分部分外的两部分递归排序
        quick3way_sort(arr, gt+1, hi);
    }
    
    private static int partition(int[] arr, int lo, int hi){
        int i = lo, j = hi + 1;
        int v = arr[lo];   //指定切分元素为第一个元素
        while(true){
            while(arr[++i] < v){   // 从第二个元素开始向后遍历，找到大于基准的元素
                if(i == hi)  break;
            }
            while(arr[--j] > v){
                if(j == lo)  break; // 从最后一个元素向前遍历，找到小于基准的元素
            }
            if(i >= j) break;  // 前后便利的指针相遇，退出循环
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }
    
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
