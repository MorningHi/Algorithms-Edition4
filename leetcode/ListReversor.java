package leetcode;
/**
* @author: Rezero
* @createDate��2019��9��18��
*/

public class ListReversor {
    
    // ����ڵ���
    private static class ListNode{
        private int val;       // �ڵ�ֵ
        private ListNode next;     // ��һ���ڵ�
        
        public ListNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        
        // ��������
        ListNode head = new ListNode(-1);
        ListNode current = head;
        for(int i = 0; i < 10; i++){
            ListNode temp = new ListNode(i);
            current.next = temp;
            current = current.next;
        }
        current.next = null;  // ���һ���ڵ�ָ��null
        head = head.next;
        
//        head = reverse(head);
        head = reverseBetween(head, 1, 6);
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        

    }

/*    // ������
    public static ListNode reverse(ListNode head){
        ListNode curr = head;    // ��ǰ�ڵ�
        ListNode prev = null;    // ��ǰ�ڵ��ǰһ���ڵ�
        
        while(curr != null){
            ListNode temp = curr.next;   // ��ʱָ��ָ��ǰ�ڵ����һ���ڵ�
            curr.next = prev;   // ��ǰ�ڵ�ָ��ǰһ���ڵ�
            prev = curr;      // ָ�����
            curr = temp;   
        }
        return prev;
    }*/
    
    
/*    // �ݹ�ⷨ
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null)    return head;
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }  */  
    
    // ��ת�����һ����
    public static ListNode reverseBetween(ListNode head, int start, int end){
        if(start == end) return head;
        ListNode curr = head, newHead = new ListNode(-1);
        ListNode prev = newHead;
        newHead.next = head;
        
        int count = 1;     
        while(count < start){
            prev = prev.next;
            count++;
        }
        curr = prev.next; // �ҵ���ת����ʼ�ڵ�
        
        while(count++ < end){
            ListNode temp = curr.next;   // ���浱ǰ�ڵ����һ���ڵ�
            curr.next = curr.next.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return newHead.next;
    }
}