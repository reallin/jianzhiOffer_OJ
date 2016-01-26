package PrintMartix;

import java.util.ArrayList;
import java.util.List;
/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵：
 *  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9
 *  ,5,6,7,11,10.
 * @author linxj
 *
 */
public class PrintMartix {
	public static void main(String[] args){
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] matrix1 = {{1,2},{3,4}};
		int[][] matrix2 = {{1},{2},{3},{4}};
		int[][] matrix3 = {{1,2},{3,4},{5,6},{7,8},{9,10}};
		List<Integer> list = printMatrix(matrix3);
		System.out.print(list.toString());
	}
	
	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int row = matrix.length;
		int colum = matrix[0].length;
		if(matrix == null||colum<=0||row<=0 ){
			return null;
		}
		int start = 0;
		while(row > start*2&&colum > start*2){
			printCricle(list,row,colum,start,matrix);
			start++;
		}
		
	   return list;
    }
	public static  void printCricle(List<Integer> list,int row,int colum,int start,int[][] matrix){
		
				int rowNum = colum-start-1;
			int columNum = row - start-1;
			//从左往右打
			for(int i = start;i <= rowNum;i++){
				list.add(matrix[start][i]);
			}
			//从上往下打
			if(start < columNum){
				for(int i = start+1;i <= columNum;i++){
					list.add(matrix[i][rowNum]);
				}
			}
			//从右往左打
			if(start < rowNum&&start < columNum ){
				for(int i = rowNum-1;i >= start;i--){
					list.add(matrix[columNum][i]);
				}
			}
		
			//从下往上打
					if(start < rowNum &&start < columNum-1 ){
						for(int i = columNum-1;i >= start+1;i--){
							list.add(matrix[i][start]);
						}
					}
			}
}
