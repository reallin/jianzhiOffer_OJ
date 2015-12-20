package main;
/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历
 * 的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1
 * ,5,3,8,6}，则重建二叉树并返回。
 * 思路：指出二叉树顶点，preorder第一个值就是，再找出左子树的值，右子树的值，返回根节点。
 * @author linxj
 *
 */
public class Main {
	private static  int[] preOrder = {1,2,4,7,3,5,6,8};
	private static  int[] inOrder = {4,7,2,1,5,3,8,6};
public static void main(String[] args){
	TreeNode n = reConstructBinaryTree(preOrder,inOrder);
	n.print();
	while(n.left!=null){
		n.left.print();
		n = n.left;
	}
	
}
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in){
		if(pre.length == 0||in.length == 0||pre == null||in == null||in.length!=pre.length){
			return null;
		}
		int rootNum = pre[0];
		TreeNode node = new TreeNode(rootNum);
		if(pre == in){
			if(pre.length == 1){
				return node;
			}
		}
		int pos = 0;
		while(rootNum != in[pos]&&rootNum<in.length){
			pos++;
			if(rootNum == in.length-1&&rootNum != in[pos]){
				return null;
			}
		}
		if(pos >0){
		int[] leftNew = new int[pos];
		int[] leftIn = new int[pos]; 
		for(int i = 1;i <= pos;i++){
			leftNew[i-1] = pre[i]; 
		}
		for(int i = 0;i < pos;i++){
			leftIn[i] = pre[i];
		}
		node.left = reConstructBinaryTree(leftNew,leftIn);
		}
		if(pos<pre.length-1){//存在右子树
        	int[] newLeftPre = new int[pre.length-1-pos];
        	int[] newLeftIn = new int[pre.length-1-pos];
        	
        	for(int i=1+pos; i<=pre.length-1;i++)
        		newLeftPre[i-1-pos]=pre[i];
        	for(int i=pos+1; i<=in.length-1;i++)
        		newLeftIn[i-1-pos]=in[i];
        	node.right = reConstructBinaryTree(newLeftPre, newLeftIn);
    	}
		return node;
	}
	public static class TreeNode {
		     int val;
		     TreeNode left;
		      TreeNode right;
		      TreeNode(int x)
		      { val = x; }
		      public void print(){
		    	  System.out.println(val);
		      }
		 }
}
