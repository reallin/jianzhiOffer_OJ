package Main;
/**�����������1�ĸ���**/
public class Main {
	private static final int _1MB = 1024*1024;
	public static void main(String args[]){
		System.out.print(NumberOf1(7)+"");
		//System.out.print(NumberOf1_2(7)+"");
		byte[] a = new byte[240*_1MB];
	}
	 public static int NumberOf1(int n) {
		 int i = 1;
		 int count = 0;
		 while(i!=0){
		 if((n&i)!=0){
			 count++;
		 }
		 i = i<<1;
		 }
		 return count;
	    }
	 //ÿ&һ�ξ�������С���Ǹ�1
	 public static int NumberOf1_2(int n){
		 int count = 0;
		 while(n!=0){
			 count++;
			 n=n&(n-1);
		 }
		 return count;
	 }
}