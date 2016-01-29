package jianzheoffer_29NumOutOfHalf;
/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author linxj
 *思路：设置两个数，一个表示个数，一个表示数值，但相同时个数加1，不相同个数减一，为0时就要换数，最后数大于0的那个值就是超过半数的。
 */
public class Partition {
	public static void main(String[] args){
		int[] array = {1,2,3,2,2,2,5,4,2};
		int[] array1 = {};
		int[] array2 = {1,2,3,2,2,4};
		System.out.print(MoreThanHalfNum_Solution(array));
		System.out.print(MoreThanHalfNum_Solution(array1));
		System.out.print(MoreThanHalfNum_Solution(array2));
	}
	public static int MoreThanHalfNum_Solution(int [] array) {
		if(array == null||array.length<=0){
			return 0;
		}
     int mNum = 1;
     int mData = array[0];
     int length = array.length;
     for(int i = 1;i < length;i++){
    	 if(mData != array[i] ){
    		 mNum--;
    	 }else if(mData == array[i]){
    		 mNum++;
    	 }
     if(mNum == 0){
    	 mData = array[i];
    	 mNum=1;
     }
     }
     //判断是否超过一半
     int count = 0;
     for(int i = 0;i < length;i++){
    	 if(array[i]==mData){
    		 count++;
    	 }
     }
     if(count*2 <= length){
    	 mData = 0;
     }
     return mData;
    }
}
