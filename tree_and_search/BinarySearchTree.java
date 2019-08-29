package tree_and_search;
/**
* @author: Rezero
* @createDate：2019年8月15日
* 
* 
*/
public class BinarySearchTree {

    private Node root;      // 根节点
    
    private class Node{
        private int val;       // 节点值
        private Node left;     // 指向结点左子树的链接
        private Node right;    // 指向节点右子树的链接
        
        public Node(int val){
            this.val = val;
        }
    }
    
    // 判断二叉树是否为空
    public boolean isEmpty(){
        return root == null;
    }
    
    // 插入函数
    public void insert(int val){
        Node newNode = new Node(val);
        if(root == null){      // 如果当前位置为空，将新节点放在当前位置
            root = newNode;
            return;
        }
        Node parent = root;
        Node current = root;
        while(true){
            parent = current;
            if(current.val > val){                // 插入值比当前节点值大，应该位于左子树
                current = current.left;
                if(current == null){
                    parent.left = newNode;
                    return;
                }
            }
            else{
                current = current.right;        // 插入值比当前节点值小，应该位于右子树
                if(current == null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
    
    // 查找函数
    public boolean search(int val){
        // 二叉树为空或者只有根节点一个节点且根节点值不等于要查找的值，返回false
        if(root == null || (root.left == null && root.right == null && root.val != val))   return false;
        Node current = root;
        while(current != null && current.val != val){
            if(val < current.val){
                current = current.left;   //小于当前值在左边找
            }
            else{
                current = current.right;  // 大于当前值在右边找
            }
        }
        return !(current == null);   // 如果current为空表明没有找到
    }
    
    // 查找二叉树中最大值
    public int max() throws Exception{
        if(root == null){
            throw new Exception("Tree is empty!");
        }
        return max(root).val;
    }
    // 查找以current为根节点的二叉树中的最大节点
    private Node max(Node current){
        if(current.right == null){      // 如果左子树为空，则根节点就是最大值
            return current;
        }
        return max(current.right);      // 否则在右子树中查找
    }
    
    // 查找二叉树中的最小值
    public int min() throws Exception{
        if(root == null){
            throw new Exception("Tree is empty!");
        }
        
        return min(root).val;
    }
    // 查找以current为根节点的二叉树中的最小节点
    private Node min(Node current) throws Exception{
        if(current.left == null){      // 如果右子树为空，则根节点就是最小值
            return current;
        }
        return min(current.left);
    }
    
    // 删除二叉树中的最小值节点
    public void deleteMin() throws Exception{
        if(root == null){
            throw new Exception("Can't delete node from an empty Tree!");    // 二叉树为空
        }
        root = deleteMin(root);
    }
    private Node deleteMin(Node current){
        if(current.left == null){   // 二叉树左子树为空，则最小值为根节点，将根节点指向右节点即可
            return current.right;
        }
        current.left = deleteMin(current.left);
        return current;
    }
    
    // 删除二叉树中的最大值节点
    public void deleteMax() throws Exception{
        if(root == null){
            throw new Exception("Can't delete node from an empty Tree!");    // 二叉树为空
        }
        root = deleteMax(root);
    }
    private Node deleteMax(Node current){
        if(current.right == null){        // 右子树为空，则最大值为根节点
            return current.left;
        }
        current.right = deleteMax(current.right);
        return current;
    }
    
    // 删除二叉树中指定值对应的节点
    public void delete(int val) throws Exception{
        root = delete(root, val);
    }
    private Node delete(Node current, int val) throws Exception{
        if(current == null){         // 说明需要删除的值不在树中
            throw new Exception("Value doesn't exist!");
        }
        
        if(current.val > val)      current.left = delete(current.left, val);          // 在左子树中
        else if(current.val < val) current.right = delete(current.right, val);        // 在右子树中
        else{
            if(current.left == null)      return current.right;
            if(current.right == null)     return current.left;
            Node temp = current;
            current = min(current.right);     // 找到要删除节点右子树中最小的节点代替当前节点
            current.right = deleteMin(current.right);     // 将右子树中的最小节点删除
            current.left = temp.left;
        }
        
        return current;
    }
}
