package leetcode;
/**
* @author: Rezero
* @createDate��2019��9��7��
*/
public class FastPower {

    public static void main(String[] args) {
        double base = 2;
        int exponent = -214;
        double result = Power(base, exponent);
        System.out.print(result);
    }

    public static double Power(double base, int exponent){
        if((Math.abs(base - 0.0) < 1e-16) && (exponent <= 0)){
            return 0;
        }
        
        // ָ��Ϊ������ʱ�򣬽�ָ����Ϊ���෴����������Ϊ�䵹��
        if(exponent < 0){
            //exponent = -exponent;
            base = 1 / base;
        }
        double result = myPow(base, exponent);
        return result;
    }

    private static double myPow(double base, int exponent) {
        if(exponent == 0)  return 1;
        if(exponent == 1)  return base;
        double result = myPow(base, exponent >> 1);
        result *= result;
        if((exponent & 0x1) == 1){
            result *= base;
        }
        return result;
    }
    
}
