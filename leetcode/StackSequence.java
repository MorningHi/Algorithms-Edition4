package leetcode;

import java.util.Stack;

/**
* @author: Rezero
* @createDate��2019��9��19��
* 
* ��ָOffer������31
*/
public class StackSequence {
        
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arrayPush = {1, 2, 3, 4, 5};    // ѹ��˳��
        int[] arrayPop = {4, 3, 5, 2, 1};     // ����˳��
        
        boolean isPopOrder = isPopOrder(arrayPush, arrayPop);
        System.out.println(isPopOrder);
    }

    public static boolean isPopOrder(int[] arrPush, int[] arrPop){
        boolean result = false;
        int len = arrPush.length;  // ���鳤�ȣ����������������ȳ�
        if(len > 0){
            Stack<Integer> s = new Stack();
            int i = 0, j = 0;
            for(; i < len; i++){
                // ջΪ�ջ���ջ��Ԫ�ز����ڵ�ǰҪ������Ԫ����һֱ��ջ��ѹ��Ԫ��
                while(s.empty() || (s.peek() != arrPop[i])){
                    if(j == len)    break;
                    s.push(arrPush[j]);
                    j++;
                }
                // ����Ԫ�ض���ѹ��ջ��ջ��Ԫ���Բ����ڵ�ǰҪ������Ԫ�أ�˵��������
                if(s.peek() != arrPop[i])  break;
                s.pop();  // ջ��Ԫ�ص��ڵ�ǰҪ����Ԫ�أ��򵯳�ջ��Ԫ�ؼ���ѭ��
            }
            
            // ջΪ�ղ��Ҵ���ѹ��˳��������ѱ������꣬˵����������
            if(s.empty() && i==len){
                result = true;
            }
        }
        return result;
    }
}
