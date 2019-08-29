package tree_and_search;
/**
* @author: Rezero
* @createDate��2019��8��15��
* 
* ʵ����������Ķ��ֲ���
*/
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {-22, -10, -7, -4, -3, 0, 3, 16, 21, 25, 32, 43, 51, 53, 56, 68, 70, 77, 87, 99, 121};
        int key = 33;   // ��Ҫ���ҵ�ֵ
        
//        int index = search(arr, key);   //���÷ǵݹ��ʵ�ַ���
        int index = search(arr, key, 0, arr.length-1);    // ���õݹ��ʵ�ַ���
        if(index != -1){
            System.out.println("key found, index is " + index + '.');
        }
        else{
            System.out.println("key doesn't exist!");
        }
    }
    
    // �ǵݹ�ʵ��
    public static int search(int[] arr, int key){
        int lo = 0;
        int hi = arr.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;   // ע�⣺��ƽ��ֵ��ʹ��  (lo+hi)/2 ���ܴ���������������
            if(arr[mid] > key)   hi = mid - 1;
            else if(arr[mid] < key)   lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    
    // �ݹ�ʵ��
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
