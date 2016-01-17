package com.lxj.jianzhe;

public class Power {
	public static void main(String[] args){
		System.out.print(Power(2.0,-1));
	}
	public static double Power(double base, int exponent){
		double result = 1.0;
		//求倒数分母不能为0
		if(base == 0.0 && exponent < 0){
			return -1;
		}else if(exponent < 0){
			int num = -exponent;
			for(int i = 1;i <= num;i++){
				result *= base;
			}
			result = 1/result;
		}
		else if(exponent >= 0){
			for(int i = 1;i <= exponent;i++){
				result *= base;
			}
			
		}
		return result;
	}
}
