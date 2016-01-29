package jianzheoffer_28_permutation;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。
 * @author linxj
 *
 */
public class PermutationCharOfString {
	public static void main(String[] args) {
		ArrayList<String> resultList = new ArrayList<String>();
		resultList = Permutation("abcd");
		for(int i=0; i<resultList.size();i++){
			System.out.print(resultList.get(i) + " ");
		}
	}
	public static ArrayList<String> Permutation(String str) {
		ArrayList<String> aList = new ArrayList<String>();
	      if(str.length()==0){
	    	  return aList;
	      }
	      if(str.length()==1){
	    	  aList.add(str);
	    	  return aList;
	      }
	      for(int i = 0;i < str.length();i++){
	    	  String mStr = str.substring(0,i)+str.substring(i+1,str.length());
	    	  ArrayList<String> childList = Permutation(mStr);
	    	  for(String childStr:childList){
	    		  String resultString = str.charAt(i)+childStr;
	    		  if(!aList.contains(resultString))
	    		  aList.add(resultString);
	    	  }    	  
	      }
	      return aList;
    }
}
