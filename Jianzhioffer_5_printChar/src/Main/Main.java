package Main;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
	public static void main(String[] args){
		ListNode node = new ListNode(3);
		node.nextNode = new ListNode(5);
		node.nextNode.nextNode = new ListNode(6);
		System.out.print(printListFromTailToHead(node).toString());
	}
	    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	    	Stack<ListNode> stack = new Stack<ListNode>();
	    	ArrayList<Integer> aList = new ArrayList<Integer>();
	    	ListNode curNode=listNode;
	    	if(curNode == null){
	    		return aList;
	    	}
	        while(curNode != null){
	        	stack.push(curNode);
	        	curNode = curNode.nextNode;
	        }
	        while(!stack.isEmpty()){
	        	aList.add(stack.pop().value);
	        }
	        return aList;
	    }
}
