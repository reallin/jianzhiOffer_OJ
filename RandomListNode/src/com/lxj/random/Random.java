package com.lxj.random;

public class Random {
    public RandomListNode Clone(RandomListNode pHead)
	    {
		  if(pHead == null){
			  return null;
		  }
	        copyList(pHead);
	        connectList(pHead);
	       return reConnectList(pHead);
	    }
	  //在每个节点的右边复制并加上一个节点
	  public void copyList(RandomListNode pHead){
		  RandomListNode pNode = pHead;
		  while(pNode!=null){
			  RandomListNode pClone = new RandomListNode(pNode.label);
			  pClone.next = pNode.next;
			  pNode.next = pClone;
			  pNode = pClone.next;
		  }
		  
	  }
	  //设置被复制的节点的random指向原节点random下一个节点
	  public void connectList(RandomListNode pHead){
		  RandomListNode pNode = pHead;
		 
		  while(pNode!=null){
			  RandomListNode pClone = pNode.next;
			  if(pNode.random != null){
			 pClone.random = pNode.random.next;
			
			  }
              pNode = pClone.next;
		  }
	  }
	  //拆分链表,奇为原链表，偶为复制的链表
	  public RandomListNode reConnectList(RandomListNode pHead){
		  RandomListNode pNode = pHead;
		  RandomListNode pClone = null;
		  RandomListNode pCloneHead = null;
		  if(pNode!=null){
			  pClone = pCloneHead = pNode.next;
			  pNode.next = pClone.next; 
			  pNode = pNode.next;
		  }
		 
		  while(pNode!=null){
			 pClone.next = pNode.next;
			 pClone = pClone.next;
			 pNode.next = pClone.next;
			 pNode = pNode.next;
			  }
		  return pCloneHead;
		  }
	  
	  
	  public class RandomListNode {
		    int label;
		    RandomListNode next = null;
		    RandomListNode random = null;

		    RandomListNode(int label) {
		        this.label = label;
		    }
		}
}
