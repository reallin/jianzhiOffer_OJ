package com.lxj.FindTwoNum;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。 
 * @author linxj
 *
 */
public class FindTwoNum {
	public static void main(String[] args){
		int[] array = {};
		System.out.println(FindNumbersWithSum(array,15).toString());
	}
public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
	
        int left = 0;
        int right = array.length-1;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if(array.length<=0||array==null){
    		return arrayList;
    	}
        int min = array[right]*array[right];
        int mul = -1;//两数乘积
        while(left<right){
        	
        	if(array[left]+array[right] < sum){
        		left++;
        	}
        	else if(array[left]+array[right] > sum){
        		right--;
        	}
        	else{
        		mul = array[left]*array[right];
        		if(mul < min&&mul != -1){
            		min = mul;
            		arrayList.clear();
            		arrayList.add(array[left]);
            		arrayList.add(array[right]);
            	}
        		
        		left++;
        	}
        	
        }
        return arrayList;
    }
}
