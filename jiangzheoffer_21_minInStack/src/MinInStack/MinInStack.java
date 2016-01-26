package MinInStack;

import java.util.Stack;
/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 思路：用辅助栈，存当前的最小数，栈1有多少个数，辅助栈就有多少个
 * @author linxj
 *
 */
public class MinInStack {
	  Stack<Integer> stack1 = new Stack<Integer>();
	  Stack<Integer> stack2 = new Stack<Integer>();//辅助栈
		    
		    public void push(int node) {
		        stack1.push(node);
		        if(stack2.isEmpty()){
		        	stack2.push(node);
		        }else if(stack2.peek()>node){
		        	stack2.push(node);
		        }else{
		        	stack2.push(stack2.peek());
		        }
		    }
		    
		    public void pop() {
		    	if(stack2.isEmpty()){
		    		return;
		    	}else{
		    	stack2.pop();
		    	stack1.pop();//辅助栈也要出栈，保证它栈顶是栈1当前数的最小值
		    	}
		    	
		    }
		    
		    public int top() {
		    	if(!stack1.isEmpty())
		        return stack1.peek();
		    	else{
		    		return 0;
		    	}
		    }
		    //获取当前最小值
		    public int min() {
		    	if(!stack1.isEmpty())
		    		 return stack2.peek();
			    	else{
			    		return 0;
			    	}
		       
		    }
	
}
