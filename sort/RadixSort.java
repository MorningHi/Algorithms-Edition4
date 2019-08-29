package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {-7, 51, 3, -121, -3, 32, 21, 43, -4, 25, 56, 77, 0, 16, -22, 87, 56, -10, 68, 99, 70};
        
        radix_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void radix_sort(int[] arr){
        // ����Ϊ�ջ��߳���Ϊ1����Ҫ����
        if(arr == null || arr.length < 2){
            return;
        }
        
        int maxBit = getMaxBit(arr);  // ������������������λ��
        int bitCount = 0, div = 1, mod = 10;
        while(bitCount++ < maxBit){
             // ����Ͱ���ϣ���19��Ͱ��0-8��Ÿ�����9-18�������
            @SuppressWarnings("unchecked")
            ArrayList<Integer>[] buckets = new ArrayList[19];
            for(int i = 0; i < 19; i++){
                buckets[i] = new ArrayList<Integer>();
            }
            for(int n : arr){
                /* 
                 * (n%mod)/divȡÿ������ǰλ��ֵ,���ֵ������
                 * Ȼ�� +9����ԭ���ĸ����ƶ�������[0-8], ԭ���������ƶ���[9-18]
                 */
                int current = (n % mod) / div + 9;
                buckets[current].add(n);
            }
            
            // ��Ͱ�е����Ż�����
            int index = 0;
            for(int i = 0; i < 19; i++){
                if(!buckets[i].isEmpty()){
                    for(int n : buckets[i]){
                        arr[index++] = n;
                    }
                }
            }
            div *= 10;
            mod *= 10;
        }
        
    }
    
    private static int getMaxBit(int[] arr){
        int maxValue = arr[0], bit = 0;
        for(int n : arr){
            if(Math.abs(n) > maxValue)  maxValue = Math.abs(n);   // �ҳ�������������
        }
        while(maxValue > 0){
            bit++;
            maxValue /= 10;
        }
        return bit;
    }
}
