package jianzheoffer_31_MaxSum;

import javax.print.attribute.standard.Finishings;

/**
 *  连续数组最大和
 *  HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？
 * @author linxj
 *
 */
public class MaxSum {
	public static void main(String[] args){

		int[] array = {6,-3,-2,7,-15,1,2,2};
		int[] array1 = {1,-2,3,10,-4,7,2,-5};
		int[] array2 = {-2,-1,-2,-5};
		
		System.out.print(FindGreatestSumOfSubArray(array1));
	}
	 public static int FindGreatestSumOfSubArray(int[] array) {
		 if(array == null || array.length <= 0){
			 return 0;
		 }
	        int length = array.length;
	        int sum = 0;
	        int max = array[0];
	        int index = 0;
	        int end = 0;
	        for(int i = 0;i<length;i++){	        	
	        	
	        	if(sum <= 0){
	        		sum = array[i];
	        		index = i+1;
	        	}else{
	        		sum+=array[i];
	        	}
	        	if(max < sum){
	        		max = sum;
	        		end = i;
	        	}
	        }
	       return max;
	    }
}
