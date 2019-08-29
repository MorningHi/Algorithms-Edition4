package sort;

import java.util.Arrays;

public class MergeSort {
    private static int[] aux;   //��������
    
    public static void main(String[] args) {
        int[] arr = {3, 12, 6, 7, 40, 35, 8, 4, 22};
        
        sortBU(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    // �Զ����µĹ鲢����
    public static void sortTD(int[] arr){
        // ����Ϊ�ջ��߳���Ϊ1����Ҫ����
        if(arr == null || arr.length < 2){
            return;
        }
        
        aux = new int[arr.length];   // ��������������ԭ�����С��ͬ�Ŀռ�
        sort(arr, 0, arr.length - 1);
    }
    
    private static void sort(int[] arr, int lo, int hi){
        if(hi <= lo){
            return;
        }
        int mid = (lo + hi) / 2;
        sort(arr, lo, mid);   // �����߽�������
        sort(arr, mid+1, hi); // ���Ұ�߽�������
        // �����������ߴ�ʱ��������ģ����Կ���ͨ���ж�arr[mid]<=arr[mid+1]������merge()����
        if(arr[mid] <= arr[mid+1]){
            return;
        }
        merge(arr, lo, mid ,hi);  //�ϲ�����������
    }
    
    private static void merge(int[] arr, int lo, int mid, int hi){
        int i = lo, j = mid + 1;
        // ����arr[lo]... arr[hi]����������
        for(int k = lo; k <= hi; k++){
            aux[k] = arr[k];
        }
        
        for(int k = lo; k <= hi; k++){
            if(i > mid)   arr[k] = aux[j++];   // �����þ���ֱ��ȡ�Ұ��Ԫ��
            else if(j > hi)   arr[k] = aux[i++];   // �Ұ���þ���ֱ��ȡ����Ԫ��
            else if(aux[j] < aux[i])   arr[k] = aux[j++];   // ���Ԫ�ش����ұ�Ԫ�أ� ȡ�ұ�Ԫ��
            else  arr[k] = aux[i++];   // �ұ�Ԫ�ش��ڵ������Ԫ�أ�ȡ���Ԫ��
        }
    }
    
    
    // �Ե����ϵĹ鲢����
    public static void sortBU(int[] arr){
        // ����Ϊ�ջ��߳���Ϊ1����Ҫ����
        if(arr == null || arr.length < 2){
            return;
        }
        
        int N = arr.length;
        aux = new int[N];   // ��������������ԭ�����С��ͬ�Ŀռ�
        for(int sz = 1; sz < N; sz += sz){
            for(int lo = 0; lo < N-sz; lo += sz+sz){
                merge(arr, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }
}
