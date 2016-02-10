package jianzheoffer_46_StringConvertToInt;
//字符串转化成整数

public class StringToInt {
	//考虑"" "+123" "-123" 以及除'0'~'9'以外的字符 
	public static void main(String[] args){
		System.out.println(StrToInt("-"));
	}
public static int StrToInt(String str) {
	int length = str.length();
	boolean minu = true;
        if(length <= 0||str == null||"".equals(str)){
        	return 0;
        }
        int count = 0;
        int num = 0;//最后值
       while(count < length){
    	   if(count == 0){//判断正负
    		   if(str.charAt(0) == '+'){
    			   minu = true;//正数
    			  count++;
    		   }else if(str.charAt(0) == '-'){
    			   minu = false;//负数
     			  count++;
    		   }
    	   }
    	   if(length >= 2){
    	   if(str.charAt(count) >= '0' && str.charAt(count) <= '9'){
    		   num = num*10+(str.charAt(count)-'0');
    	   }else{
    		   return 0;
    	   }
    	   count ++;
       }
       }
       if(!minu){
    	   num = -num;
       }
       return num;
    }
}
