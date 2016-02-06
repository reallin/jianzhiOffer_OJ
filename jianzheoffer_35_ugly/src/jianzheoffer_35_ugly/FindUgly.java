package jianzheoffer_35_ugly;
/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 * 思路：把丑数从小到大排列到N个就可以了。分别在己有的数组中从小到大*2，*3，*5找出下一个最大。注意不是每次都从1开始找，而是从上一次到找的位置继承往
 * 下找。
 * @author linxj
 *
 */
public class FindUgly {
	public static void main(String[] args){
		System.out.println(GetUglyNumber_Solution(1));
	}
	 public static int GetUglyNumber_Solution(int index) {
		 if(index <= 0){
	        return 0;
		 }
		 int[] uglys = new int[index];
		 int indexNum = 1;
		uglys[0] = 1;
		 int num2 = 1;
		 int num3 = 1;
		 int num5 = 1;
		 int index2 = 0;
		 int index3 = 0;
		 int index5 = 0;
		 while(indexNum < index){
			 uglys[indexNum] = min(num2*2, num3*3, num5*5);//找出三个数中最小值
			 while(num2*2<=uglys[indexNum]){
				 index2++;
				 num2=uglys[index2];
			 }
			 while(num3*3<=uglys[indexNum]){
				 index3++;
				 num3 = uglys[index3];
			 }
			 while(num5*5<=uglys[indexNum]){
				 index5++;
				 num5 = uglys[index5];
			 }
			indexNum++;
		 }
		 return uglys[index-1];
	    }
	 public static int min(int i,int j,int k){
		 int min = i < j?i:j;
		 min = min < k?min:k;
		 return min;
	 }
}
