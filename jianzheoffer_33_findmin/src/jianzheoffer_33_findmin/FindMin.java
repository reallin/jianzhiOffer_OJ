package jianzheoffer_33_findmin;
/**
 *输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 *则打印出这三个数字能排成的最小数字为321323。。
 * @author linxj
 *
 */
public class FindMin {
	public static void main(String[] args) {
		int[] array = {3,324,322,323};
		System.out.print(PrintMinNumber(array));
	}
	public static String PrintMinNumber(int [] numbers) {
		if(numbers==null || numbers.length==0)
			return "";
		//先排序，再拼接
		numbers = select(numbers);
		String temp = String.valueOf(numbers[0]);
		for(int i=1; i<numbers.length; i++){
			String str1 = temp + String.valueOf(numbers[i]);
			String str2 = String.valueOf(numbers[i]) + temp;
			int result = str1.compareTo(str2);
			if(result > 0)
				temp = str2;
			else
				temp = str1;
		}
		return temp;
    }
	private static int[] select(int[] array){
		int outer, inner, min;
		for(outer=0; outer<array.length-1; outer++){
			min = outer;//初始化min指针的索引
			for(inner=outer+1; inner< array.length; inner++){
				if(array[inner] < array[min])
					min = inner;//只查找最小值，不交换，一趟比较结束后，找到最小值，再进行交换。
			}
			int temp = array[outer];
			array[outer] = array[min];
			array[min] = temp;
		}
		return array;
	}
}
