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
        // 数组为空或者长度为1不需要排序
        if(arr == null || arr.length < 2){
            return;
        }
        
        int maxBit = getMaxBit(arr);  // 计算数组中最大的数的位数
        int bitCount = 0, div = 1, mod = 10;
        while(bitCount++ < maxBit){
             // 生成桶集合，共19个桶，0-8存放负数，9-18存放正数
            @SuppressWarnings("unchecked")
            ArrayList<Integer>[] buckets = new ArrayList[19];
            for(int i = 0; i < 19; i++){
                buckets[i] = new ArrayList<Integer>();
            }
            for(int n : arr){
                /* 
                 * (n%mod)/div取每个数当前位的值,这个值带符号
                 * 然后 +9，将原本的负数移动到区间[0-8], 原来的正数移动到[9-18]
                 */
                int current = (n % mod) / div + 9;
                buckets[current].add(n);
            }
            
            // 将桶中的数放回数组
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
            if(Math.abs(n) > maxValue)  maxValue = Math.abs(n);   // 找出数组中最大的数
        }
        while(maxValue > 0){
            bit++;
            maxValue /= 10;
        }
        return bit;
    }
}
