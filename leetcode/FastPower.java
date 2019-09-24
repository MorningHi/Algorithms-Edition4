package leetcode;
/**
* @author: Rezero
* @createDate：2019年9月7日
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
        
        // 指数为负数的时候，将指数变为其相反数，底数变为其倒数
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
