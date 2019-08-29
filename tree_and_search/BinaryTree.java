package tree_and_search;
/**
* @author: Rezero
* @createDate：2019年8月15日
* 
* 实现二叉树以及一些基本的操作：插入/前序遍历/中序遍历/后序遍历
*/
public class BinaryTree {
    
    private Node root;     // 根节点

    // 节点类
    private class Node{    
        private int val;   //节点的值
        private Node left, right;     // 指向左右子树的链接
        
        public Node(int val){
            this.val = val;
        }
    }
    
    // 插入节点
    public void insert(int val){
        Node newNode = new Node(val);   //  生成新节点
        if(root == null){
            root = newNode;     // 如果树为空，那新加入的节点就是根节点
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(current.val > val){             // 插入值比当前节点值大，应该位于左子树
                current = current.left;
                if(current == null){
                    parent.left = newNode;
                    return;
                }
            }
            else{                            // 插入值比当前节点值小，应该位于右子树
                current = current.right;
                if(current == null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }    

    // 前序遍历二叉树
    public void preOrder(){
        Node current = root;
        preOrder(current);
    }
    private void preOrder(Node current){
        if(current != null){
            System.out.print(current.val + " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }
    
    // 中序遍历二叉树
    public void inOrder(){
        Node current = root;
        inOrder(current);
    }
    private void inOrder(Node current){
        if(current != null){
            inOrder(current.left);
            System.out.print(current.val + " ");
            inOrder(current.right);
        }
    }
    
    // 后序遍历二叉树
    public void postOrder(){
        Node current = root;
        postOrder(current);
    }
    private void postOrder(Node current){
        if(current != null){
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current.val + " ");
        }
    }
}
