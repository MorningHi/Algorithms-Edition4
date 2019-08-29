package tree_and_search;
/**
* @author: Rezero
* @createDate：2019年8月15日
* 
* 实现有序数组的二分查找
*/
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {-22, -10, -7, -4, -3, 0, 3, 16, 21, 25, 32, 43, 51, 53, 56, 68, 70, 77, 87, 99, 121};
        int key = 33;   // 需要查找的值
        
//        int index = search(arr, key);   //调用非递归的实现方法
        int index = search(arr, key, 0, arr.length-1);    // 调用递归的实现方法
        if(index != -1){
            System.out.println("key found, index is " + index + '.');
        }
        else{
            System.out.println("key doesn't exist!");
        }
    }
    
    // 非递归实现
    public static int search(int[] arr, int key){
        int lo = 0;
        int hi = arr.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;   // 注意：求平均值若使用  (lo+hi)/2 可能存在求和溢出的问题
            if(arr[mid] > key)   hi = mid - 1;
            else if(arr[mid] < key)   lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    
    // 递归实现
    public static int search(int[] arr, int key, int lo, int hi){
        if(hi <= lo)   return (arr[lo] == key) ? lo : -1;
        int mid = lo + (hi - lo) / 2;
        if(arr[mid] > key){
            return search(arr, key, lo, mid-1);
        }
        else if(arr[mid] < key){
            return search(arr, key, mid+1, hi);
        }
        else return mid;
    }
}
