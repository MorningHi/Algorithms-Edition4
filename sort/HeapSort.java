package sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {3, 12, 6, 7, 40, 35, 8, 4, 22};
        
        heap_sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void heap_sort(int[] arr){
        // ����Ϊ�ջ��߳���Ϊ1����Ҫ����
        if(arr == null || arr.length < 2){
            return;
        }
        
        int N = arr.length;
        for(int i = N/2; i >= 0; i--){
            adjust(arr, i, N);  // ͨ������ʹ�ó�ʼ������
        }
        
        // �������ڵ�(���������Ԫ��)�����һ�����ӽڵ㣬���Ӷ���ɾ��
        while(N-- > 0){
            int temp = arr[N];
            arr[N] = arr[0];
            arr[0] = temp;
            adjust(arr, 0, N);   // ���µ�������ʹ�ö�����
        }
    }
    
    private static void adjust(int[] arr, int i, int N){
        while(2*i+1 < N){
            int j = 2 * i + 1; // ��ǰ�ڵ����ӽ�������
            if(j+1 < N && (arr[j] < arr[j+1]))   j++;   // �ҵ����ĺ��ӽڵ�
            if(arr[i] >= arr[j])   break;   // �������ڵ�������еĺ��ӽڵ㣬���ý���
            int temp = arr[i];  // ��������ӽڵ�͸��ڵ�
            arr[i] = arr[j];
            arr[j] = temp;
            i = j;   
        }
    }
}
