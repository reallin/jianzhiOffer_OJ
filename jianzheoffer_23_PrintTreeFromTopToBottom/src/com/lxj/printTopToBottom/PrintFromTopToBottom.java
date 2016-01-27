package com.lxj.printTopToBottom;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 思路：用一个队列来存节点，pop一个节点就把它的子节点加进来
 * @author linxj
 *
 */
public class PrintFromTopToBottom {
	 public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
	        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
	        ArrayList<Integer> aList = new ArrayList<Integer>();
	        if(root == null){
	        	return aList;
	        }
	        list.add(root);
	        while(!list.isEmpty()){	        
	        TreeNode pop = list.pop();
	        aList.add(pop.val);
	        if(pop.left!=null){
	        	list.add(pop.left);
	        }
	        if(pop.right!=null){
	        	list.add(pop.right);
	        }
	        }
	        return aList;
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
