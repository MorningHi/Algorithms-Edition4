package tree_and_search;
/**
* @author: Rezero
* @createDate��2019��8��15��
* 
* ʵ�ֶ������Լ�һЩ�����Ĳ���������/ǰ�����/�������/�������
*/
public class BinaryTree {
    
    private Node root;     // ���ڵ�

    // �ڵ���
    private class Node{    
        private int val;   //�ڵ��ֵ
        private Node left, right;     // ָ����������������
        
        public Node(int val){
            this.val = val;
        }
    }
    
    // ����ڵ�
    public void insert(int val){
        Node newNode = new Node(val);   //  �����½ڵ�
        if(root == null){
            root = newNode;     // �����Ϊ�գ����¼���Ľڵ���Ǹ��ڵ�
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(current.val > val){             // ����ֵ�ȵ�ǰ�ڵ�ֵ��Ӧ��λ��������
                current = current.left;
                if(current == null){
                    parent.left = newNode;
                    return;
                }
            }
            else{                            // ����ֵ�ȵ�ǰ�ڵ�ֵС��Ӧ��λ��������
                current = current.right;
                if(current == null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }    

    // ǰ�����������
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
    
    // �������������
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
    
    // �������������
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
