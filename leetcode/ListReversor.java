package leetcode;
/**
* @author: Rezero
* @createDate：2019年9月18日
*/

public class ListReversor {
    
    // 链表节点类
    private static class ListNode{
        private int val;       // 节点值
        private ListNode next;     // 下一个节点
        
        public ListNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        
        // 构造链表
        ListNode head = new ListNode(-1);
        ListNode current = head;
        for(int i = 0; i < 10; i++){
            ListNode temp = new ListNode(i);
            current.next = temp;
            current = current.next;
        }
        current.next = null;  // 最后一个节点指向null
        head = head.next;
        
//        head = reverse(head);
        head = reverseBetween(head, 1, 6);
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        

    }

/*    // 迭代法
    public static ListNode reverse(ListNode head){
        ListNode curr = head;    // 当前节点
        ListNode prev = null;    // 当前节点的前一个节点
        
        while(curr != null){
            ListNode temp = curr.next;   // 临时指针指向当前节点的下一个节点
            curr.next = prev;   // 当前节点指向前一个节点
            prev = curr;      // 指针后移
            curr = temp;   
        }
        return prev;
    }*/
    
    
/*    // 递归解法
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null)    return head;
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }  */  
    
    // 反转链表的一部分
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
        curr = prev.next; // 找到反转的起始节点
        
        while(count++ < end){
            ListNode temp = curr.next;   // 保存当前节点的下一个节点
            curr.next = curr.next.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return newHead.next;
    }
}