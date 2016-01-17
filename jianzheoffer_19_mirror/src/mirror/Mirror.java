package mirror;
/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。 
输入描述:
二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 * @author linxj
 *
 */
public class Mirror {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	   public void MirrorTree(TreeNode root) {
	        if(root == null){
	        	return;
	        }
	      //递归结束条件：到达左子树和者右子树的叶子结点
	        if(root.left==null && root.right==null)//注意：是&&，而不是 ||
	        	/*答案错误:您提交的程序没有通过所有的测试用例
	        	测试用例:
	        	{8,7,#,6,#,5,#,4}
	        	对应输出应该为:
	        	{8,#,7,#,6,#,5,#,4} */
	            return;
	        //先交换左右子树，再递归交换孙子树
	        //交换节点
	        TreeNode temp;
	        temp = root.left;
	        root.left = root.right;
	        root.right = temp;
	        MirrorTree(root.left);
	        MirrorTree(root.right);
	    }
}
