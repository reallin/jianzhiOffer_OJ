package com.lxj.lastK;
/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 思路：定义两个指针，一个先跑，注意鲁棒性
 * @author linxj
 *
 */
public class LastK {
	
	public class ListNode{
		 int val;
		    ListNode next = null;

		    ListNode(int val) {
		        this.val = val;
		    }
	}
	 public ListNode FindKthToTail(ListNode head,int k) {
		 ListNode node1 = head;
		 ListNode node2 = head;
		 if(head == null||k==0){
			 return null;
		 }
		 int i = 0;
		 while(i < k){
			 if(node1 != null)
			 node1 = node1.next;
			 else{
				 return null;
			 }
			 i++;
		 }
		 while(node1 != null){
			 node1 = node1.next;
			 node2 = node2.next;
			
		 }
		 return node2;
	    }
}
