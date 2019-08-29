package tree_and_search;
/**
* @author: Rezero
* @createDate��2019��8��15��
* 
* 
*/
public class BinarySearchTree {

    private Node root;      // ���ڵ�
    
    private class Node{
        private int val;       // �ڵ�ֵ
        private Node left;     // ָ����������������
        private Node right;    // ָ��ڵ�������������
        
        public Node(int val){
            this.val = val;
        }
    }
    
    // �ж϶������Ƿ�Ϊ��
    public boolean isEmpty(){
        return root == null;
    }
    
    // ���뺯��
    public void insert(int val){
        Node newNode = new Node(val);
        if(root == null){      // �����ǰλ��Ϊ�գ����½ڵ���ڵ�ǰλ��
            root = newNode;
            return;
        }
        Node parent = root;
        Node current = root;
        while(true){
            parent = current;
            if(current.val > val){                // ����ֵ�ȵ�ǰ�ڵ�ֵ��Ӧ��λ��������
                current = current.left;
                if(current == null){
                    parent.left = newNode;
                    return;
                }
            }
            else{
                current = current.right;        // ����ֵ�ȵ�ǰ�ڵ�ֵС��Ӧ��λ��������
                if(current == null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
    
    // ���Һ���
    public boolean search(int val){
        // ������Ϊ�ջ���ֻ�и��ڵ�һ���ڵ��Ҹ��ڵ�ֵ������Ҫ���ҵ�ֵ������false
        if(root == null || (root.left == null && root.right == null && root.val != val))   return false;
        Node current = root;
        while(current != null && current.val != val){
            if(val < current.val){
                current = current.left;   //С�ڵ�ǰֵ�������
            }
            else{
                current = current.right;  // ���ڵ�ǰֵ���ұ���
            }
        }
        return !(current == null);   // ���currentΪ�ձ���û���ҵ�
    }
    
    // ���Ҷ����������ֵ
    public int max() throws Exception{
        if(root == null){
            throw new Exception("Tree is empty!");
        }
        return max(root).val;
    }
    // ������currentΪ���ڵ�Ķ������е����ڵ�
    private Node max(Node current){
        if(current.right == null){      // ���������Ϊ�գ�����ڵ�������ֵ
            return current;
        }
        return max(current.right);      // �������������в���
    }
    
    // ���Ҷ������е���Сֵ
    public int min() throws Exception{
        if(root == null){
            throw new Exception("Tree is empty!");
        }
        
        return min(root).val;
    }
    // ������currentΪ���ڵ�Ķ������е���С�ڵ�
    private Node min(Node current) throws Exception{
        if(current.left == null){      // ���������Ϊ�գ�����ڵ������Сֵ
            return current;
        }
        return min(current.left);
    }
    
    // ɾ���������е���Сֵ�ڵ�
    public void deleteMin() throws Exception{
        if(root == null){
            throw new Exception("Can't delete node from an empty Tree!");    // ������Ϊ��
        }
        root = deleteMin(root);
    }
    private Node deleteMin(Node current){
        if(current.left == null){   // ������������Ϊ�գ�����СֵΪ���ڵ㣬�����ڵ�ָ���ҽڵ㼴��
            return current.right;
        }
        current.left = deleteMin(current.left);
        return current;
    }
    
    // ɾ���������е����ֵ�ڵ�
    public void deleteMax() throws Exception{
        if(root == null){
            throw new Exception("Can't delete node from an empty Tree!");    // ������Ϊ��
        }
        root = deleteMax(root);
    }
    private Node deleteMax(Node current){
        if(current.right == null){        // ������Ϊ�գ������ֵΪ���ڵ�
            return current.left;
        }
        current.right = deleteMax(current.right);
        return current;
    }
    
    // ɾ����������ָ��ֵ��Ӧ�Ľڵ�
    public void delete(int val) throws Exception{
        root = delete(root, val);
    }
    private Node delete(Node current, int val) throws Exception{
        if(current == null){         // ˵����Ҫɾ����ֵ��������
            throw new Exception("Value doesn't exist!");
        }
        
        if(current.val > val)      current.left = delete(current.left, val);          // ����������
        else if(current.val < val) current.right = delete(current.right, val);        // ����������
        else{
            if(current.left == null)      return current.right;
            if(current.right == null)     return current.left;
            Node temp = current;
            current = min(current.right);     // �ҵ�Ҫɾ���ڵ�����������С�Ľڵ���浱ǰ�ڵ�
            current.right = deleteMin(current.right);     // ���������е���С�ڵ�ɾ��
            current.left = temp.left;
        }
        
        return current;
    }
}
