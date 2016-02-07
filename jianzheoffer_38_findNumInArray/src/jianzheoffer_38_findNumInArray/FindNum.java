package jianzheoffer_38_findNumInArray;
/**
 * 统计一个数字在排序数组中出现的次数。
 * @author linxj
 *思路：找出第一个数的位置，找出最后一个数的位置，相减。
 *找第一个数思路：中点法找到等于k的位置n，判断n的前一个是不是k，如果不是，证明不是第一个，找前面一段。
 */
public class FindNum {
	public static void main(String[] args){
		int[] array = {2,2,3,3,3,3,3};
		System.out.println(GetNumberOfK(array, 2));
		
	}
	public static int GetNumberOfK(int [] array , int k) {
		if(array == null||array.length <= 0){
			return -1;
		}
		int end = array.length;
		if(GetFirst(array, 0, end, k)!=-1&&GetEnd(array, 0, end, k)!=-1){
			int i = GetEnd(array, 0, end-1,k);
			int j = GetFirst(array, 0, end-1,k);
				
	    return GetEnd(array, 0, end-1,k)-GetFirst(array, 0, end-1,k)+1;
		}
		return -1;
    }
	public static int GetFirst(int [] array , int start,int end,int k){
		if(start >= end){//不存在k
			return -1;
		}
		int mid = (start + end)/2;
		if(mid == 0){
			return mid;
		}
		if(array[mid] == k){
			if(array[mid-1] != k){
				return mid;
			}else{
				end = mid;
			}
		}else if(array[mid] > k){
			end = mid;
		}else{
			start = mid+1;
		}
		return GetFirst(array, start, end, k);
	}
	public static int GetEnd(int [] array , int start,int end,int k){
		if(start > end){
			return -1;
		}
		int mid = (start + end)/2;
		if(mid == array.length-1){
			return mid;
		}
		if(array[mid] == k){
			if(array[mid+1] != k){
				return mid;
			}else{
				start = mid+1;
			}
		}else if(array[mid] > k){
			end = mid;
		}else{
			start = mid+1;
		}
		return GetEnd(array, start, end, k);
	}
}
