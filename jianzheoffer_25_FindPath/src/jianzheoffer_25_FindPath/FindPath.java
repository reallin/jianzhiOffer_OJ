package jianzheoffer_25_FindPath;

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @author linxj
 *
 */
public class FindPath {
	int sum = 0;
	ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
	 ArrayList<Integer> aList = new  ArrayList<Integer>();//相当与栈
	 public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		
	        if(root == null){
	        	return arrayList;
	        }
	        //Stack<Integer> stack = new Stack<Integer>();
	        sum += root.val;
	       aList.add(root.val);
	        if(root.left== null && root.right == null&&sum == target){
	        	 ArrayList<Integer> path=new ArrayList<Integer>();
	        	for(int i = 0;i < aList.size();i++){
	        	 path.add(aList.get(i));
	        	}
	        	arrayList.add(path);
	        }else{
	        	if(root.left != null){
	        		FindPath(root.left,target);
	        	}
	        	if(root.right != null){
	        		FindPath(root.right, target);
	        	}
	        	//没有符合的，退一个节点，继续。   
	        }
	        if(aList.size()>0)
	        aList.remove(aList.size()-1);
	        sum-=root.val;
	        return arrayList;
	    }
	 public class TreeNode {
		    int val = 0;
		    TreeNode left = null;
		    TreeNode right = null;

		    public TreeNode(int val) {
		        this.val = val;

		    }

		}
}
