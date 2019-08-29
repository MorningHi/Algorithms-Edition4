package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3, 12, 8, 6, 7, 7, 8, 40, 35, 8, 8, 4, 22};
        
        quick_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quick_sort(int[] arr){
        // ����Ϊ�ջ��߳���Ϊ1����Ҫ����
        if(arr == null || arr.length < 2){
            return;
        }
//        sort(arr, 0, arr.length-1);
        quick3way_sort(arr, 0, arr.length-1);
    }
    
    private static void sort(int[] arr, int lo, int hi){
        if(lo >= hi)  return;
        int j = partition(arr, lo, hi);  // �з�����
        sort(arr, lo, j-1);
        sort(arr, j+1, hi);
    }
    
    private static void quick3way_sort(int[] arr, int lo, int hi){
        if(hi <= lo) return;  // lo>=hi˵����ǰ�����Ѿ�����Ҫ�з�������
        int lt = lo, i = lo+1, gt = hi;
        int v = arr[lo];   // �з�Ԫ��
        while(i <= gt){
            if(arr[i] < v)  swap(arr, i++, lt++);
            else if(arr[i] > v)  swap(arr, i, gt--);
            else i++;
        }
        // whileѭ��ִ�����arr[lo...lt-1] < a[lt...gt] < a[gt+1...hi]
        quick3way_sort(arr, lo, lt-1);  // Ȼ��Գ����зֲ�����������ֵݹ�����
        quick3way_sort(arr, gt+1, hi);
    }
    
    private static int partition(int[] arr, int lo, int hi){
        int i = lo, j = hi + 1;
        int v = arr[lo];   //ָ���з�Ԫ��Ϊ��һ��Ԫ��
        while(true){
            while(arr[++i] < v){   // �ӵڶ���Ԫ�ؿ�ʼ���������ҵ����ڻ�׼��Ԫ��
                if(i == hi)  break;
            }
            while(arr[--j] > v){
                if(j == lo)  break; // �����һ��Ԫ����ǰ�������ҵ�С�ڻ�׼��Ԫ��
            }
            if(i >= j) break;  // ǰ�������ָ���������˳�ѭ��
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
