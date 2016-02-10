package jianzheoffer_42_findSequenceWithSum;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的
 * 和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S
 * 的连续正数序列? Good Luck! 
 * @author linxj
 *
 */
public class FindSequence {
	public static void main(String[] args){
		ArrayList<ArrayList<Integer> > aLists = FindContinuousSequence(1);
		for(int i = 0;i < aLists.size();i++){
			System.out.println(aLists.get(i).toString());
		}
		
	}
	public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer> > aLists = new ArrayList<ArrayList<Integer> >();
		//ArrayList<Integer> aList = new ArrayList<Integer>();
		int small = 1;
		int big = 2;
		int endSum = small + big;
		 int mid = (1+sum)/2;
		 if(sum < 3){
			 return aLists;
		 }
		while(small < mid){

			if(endSum < sum){
				big++;
				endSum+=big;
				
			}else if(endSum > sum){
				
				endSum-=small;
				small++;
			}else{
				ArrayList<Integer> aList = new ArrayList<Integer>();
				int count = small;
				while(count <= big){
					aList.add(count);
					count++;
				}
				aLists.add(aList);
				big++;
				endSum+=big;
				
			}
		}
		return aLists;
    }
}
