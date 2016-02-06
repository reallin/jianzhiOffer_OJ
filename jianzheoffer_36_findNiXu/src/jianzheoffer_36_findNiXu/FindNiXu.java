package jianzheoffer_36_findNiXu;
/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * @author linxj
 *
 */
public class FindNiXu {
	private static int[] array;
	public static void main(String[] args){
		int[] array = {1,2,3,4,7,6,5};
		System.out.println(InversePairs(array));
	}
	 public static int InversePairs(int[] marray) {
		array = marray;
		 if(array == null || array.length <= 0){
			 return 0;
		 }
		 int[] copy = new int[array.length];
		 int count = InversePairsCore(copy, 0, array.length-1);
		 return count;
	 }
	 public static int  InversePairsCore(int[] result,int start,int end){
		 if(start == end){
			 return 0;
		 }
		 int mid = (start+end)/2;
		 int leftCount = InversePairsCore(result, start, mid);
		 int rightCount = InversePairsCore(result,mid+1,end);
		//开始合并两个已排序子序列，边进行排序，边统计逆序对
	        //三个指针
	        int leftPtr=mid;
	        int rightPtr=end;
	        int mergeCount=0;
	        int j=end;
		 while(leftPtr>=start && rightPtr>mid){
	            if(array[leftPtr]>array[rightPtr]){//如果左边>右边，存在逆序对
	                mergeCount+=rightPtr-mid;
	                result[j--]=array[leftPtr--];
	            }else{
	            	if(array[leftPtr]<array[rightPtr])
	            		result[j--]=array[rightPtr--];
	            	else{
	            		mergeCount+=rightPtr-mid-1;
	            		result[j--]=array[leftPtr--];
	            		result[j--]=array[rightPtr--];
	            	}
	            }
	        }
	        while(leftPtr>=start){
	        	result[j--]=array[leftPtr--];
	        }
	        while(rightPtr>mid){
	        	result[j--]=array[rightPtr--];
	        }
	        for(j=end;j>=0;j--){
	        	array[j]=result[j];
	        }
	        return leftCount + rightCount + mergeCount;
	 }
}
