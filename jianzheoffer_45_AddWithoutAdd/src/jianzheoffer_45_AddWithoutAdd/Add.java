package jianzheoffer_45_AddWithoutAdd;
/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @author linxj
 *
 */
public class Add {
	public static void main(String[] args){
		System.out.println(Add(1,2));
	}
    public static int Add(int num1,int num2) {
        int sum,carry;
        while(num2 != 0){
            sum = num1 ^ num2;
            carry = (num2 & num1)<<1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
}
