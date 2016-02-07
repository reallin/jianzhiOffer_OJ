package jianzheoffer_40_findTheOnce;
/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @author linxj
 *
 */
public class FindTheOnce {
	public static void main(String[] args){
		int[] array = {2,4,3,6,3,2,5,5};
		int num1[] = new int[1];
		int num2[] = new int[1];
		FindNumsAppearOnce(array,num1 , num2);
	}
public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length <= 2){
        	return;
        }
        int result = 0;
        for(int i = 0;i < array.length;i++){
        	result ^= array[i];
        }
        int num = findFirstOne(result);//找到值为1的位置
        for(int i = 0;i < array.length;i++){
        	if(isBit1(array[i], num)){//分为两组
        		num2[0] ^= array[i];
        	}else{
        		num1[0] ^=  array[i];
        	}
        }
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
public static int findFirstOne(int result){
	int count = 0;
	while((result&1)==0){
		result = result >> 1;
        count++;
	}
	return count;
}
public static boolean isBit1(int result,int num){
	result=result>>num;
    return (result&1)==1;
}
}
