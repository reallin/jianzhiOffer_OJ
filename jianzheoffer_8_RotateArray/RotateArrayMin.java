package com.offer.question08;

/**
 * 旋转数组最小值
 * 原递增排序数组{1,2,3,4,5}
 * 其中的一个旋转数组{4,5,1,2,3}
 * 找出旋转数组最小值
 */
public class RotateArrayMin {
	
	public static void main(String[] args){
		int[] array = {4,5,6,1,2,3};
		System.out.print(findMin(array));
	}
	
	//采用二分查找
	//分为两个数组子递增数组
	private static int findMin(int[] array){
		if(array == null || array.length <= 0)
			return -1;
		int lowerBound, upperBound, currentIn;
		lowerBound = 0;
		upperBound = array.length -1;
		currentIn = lowerBound;
		while(array[lowerBound] >= array[upperBound]) {
			if(lowerBound == upperBound-1) 
				return array[upperBound]; 
			currentIn = (lowerBound + upperBound)/2;
			//如果lowerBound，upperBound和currentIn相等，则顺序查找
			if(array[lowerBound] == array[upperBound] && array[lowerBound] == array[currentIn])
				return getMinInOrder(array, lowerBound, upperBound);
			if(array[currentIn] >= array[lowerBound])
				lowerBound = currentIn;
			else if (array[currentIn] <= array[upperBound])
				upperBound = currentIn;
		}
		return array[currentIn];
	}

	private static int getMinInOrder(int[] array, int lowerBound, int upperBound) {
		int min = array[lowerBound];
		for(int i=lowerBound+1; i<=upperBound; i++) {
			if(array[i] < min)
				min = array[i];
		}
		return min;
	}
}
