package jiangzheoffer_24_SquenceOfBST;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @author linxj
 *
 */
public class SquenceAfter {
	public boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence == null||sequence.length<=0){
			return false;
		}
		int length = sequence.length;
        int root = sequence[length-1];
        int mid = 0;
        //二叉搜索树中左子树所有结点小于根节点
        //先找出左右子树分界点
        for(int i = 0;i < length-1; i++ ){//此处为sequence.length-1，而不是sequence.length
        	if(sequence[i] < root){
        		mid++;//找到中间点
        		break;
        	}   	
        }
      //右子树结点大于根节点
        //找分界点的时候，已经默认左子树的所有节点值小于根节点，所以只需判断右子树
        for(int i = mid;i< length-1;i++){//此处为sequence.length-1，而不是sequence.length
        	if(sequence[i] < root){
        		return false;
        	}
        }
        boolean leftFlag = true;
        boolean rightFlag = true;
        if(mid>0){//存在左子树
        	int[] left = Arrays.copyOfRange(sequence, 0, mid);//不包括i
        	leftFlag = VerifySquenceOfBST(left);
        }
        if(mid < length-1){
        	 int[] right = Arrays.copyOfRange(sequence, mid, length-1);
        	 rightFlag = VerifySquenceOfBST(right);
        }
          
        return leftFlag&&rightFlag;
    }
}
