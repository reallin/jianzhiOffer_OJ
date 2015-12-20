package com.lxj.Main;

import java.util.Stack;
/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 思路：添加添加到第一个栈，当要pop时第一个栈中数据全放放第二个栈，再出栈。
 * @author linxj
 *
 */
public class Main {
	    Stack<Integer> stack1 = new Stack<Integer>();
	    Stack<Integer> stack2 = new Stack<Integer>();
	    public static void main(String[] args){
	    	Main m = new Main();
	    	m.push(6);
	    	m.push(5);
	    	m.push(10);
	    	System.out.print(m.pop());
	    	System.out.print(m.pop());
	    }
	    public void push(int node) {
	    	
	        stack1.add(node);
	    }
	    
	    public int pop() {
	    	if(stack2.size() == 0&&stack1.size()==0){
	    		return -1;
	    	}
	    	
	    	if(stack2.isEmpty()){
	    		while(stack1.size()>0){
	    			stack2.add(stack1.pop());
	    		}
	    	}
	    	if(stack2.isEmpty()) {
				try {
					throw new Exception("Queue is Empty");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	    	return stack2.pop();
	    }
	
}
