package tree_and_search;
/**
* @author: Rezero
* @createDate��2019��8��15��
*/
public class Test {
    public static void main(String[] args) throws Exception{
//        int[] arr = {28, 22, 41, 17, 24, 8, 20, 35, 46};
        int[] arr = {28, 41, 35, 46};
        
        BinarySearchTree bst = new BinarySearchTree();
        
        for(int i = 0; i < arr.length; i++){
            bst.insert(arr[i]);
        }
        
        bst.delete(35);
        System.out.println(bst);
    }

}
