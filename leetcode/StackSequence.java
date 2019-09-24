package leetcode;

import java.util.Stack;

/**
* @author: Rezero
* @createDate：2019年9月19日
* 
* 剑指Offer面试题31
*/
public class StackSequence {
        
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arrayPush = {1, 2, 3, 4, 5};    // 压入顺序
        int[] arrayPop = {4, 3, 5, 2, 1};     // 弹出顺序
        
        boolean isPopOrder = isPopOrder(arrayPush, arrayPop);
        System.out.println(isPopOrder);
    }

    public static boolean isPopOrder(int[] arrPush, int[] arrPop){
        boolean result = false;
        int len = arrPush.length;  // 数组长度，假设给的两个数组等长
        if(len > 0){
            Stack<Integer> s = new Stack();
            int i = 0, j = 0;
            for(; i < len; i++){
                // 栈为空或者栈顶元素不等于当前要弹出的元素则一直向栈中压入元素
                while(s.empty() || (s.peek() != arrPop[i])){
                    if(j == len)    break;
                    s.push(arrPush[j]);
                    j++;
                }
                // 所有元素都已压入栈但栈顶元素仍不等于当前要弹出的元素，说明不满足
                if(s.peek() != arrPop[i])  break;
                s.pop();  // 栈顶元素等于当前要弹出元素，则弹出栈顶元素继续循环
            }
            
            // 栈为空并且代表压入顺序的数组已被遍历完，说明满足条件
            if(s.empty() && i==len){
                result = true;
            }
        }
        return result;
    }
}
