package jianzheoffer_37_findFirstSame;
/**
 * 输入两个链表，找出它们的第一个公共结点。
 * @author linxj
 *思路一：要从尾部开始找，所以可以用两个栈。
 *思路二：先找出长的链表，计算出长的比短的长出n，让长的先走n，再进行比较，直到找到相同点。
 */
public class FindFirst {
	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next = node2;
		node3.next = node4;
		node2.next = node5;
		node4.next = node5;
		node5.next = node6;
		System.out.println(FindFirstCommonNode(node1,node3).val);
		
	}
	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 if(pHead1 == null || pHead2 == null){
			 return null;
		 }
		 int num1 = 0;
		 int num2 = 0;
		 int mul = 0;//相差步数
		 ListNode pSameFirst = null;
		 ListNode pLongFirst = null;
		 ListNode pShortFirst = null;
		 ListNode pHead1First = pHead1;
		 ListNode pHead2First = pHead2;
		 while(pHead1!=null){
			 num1++;
			 pHead1 = pHead1.next;
		 }
		 while(pHead2!=null){
			 num2++;
			 pHead2 = pHead2.next;
		 }
		 if(num1 > num2){//计算两链表相差步数
			mul = num1 - num2; 
			pLongFirst = pHead1First;
			pShortFirst = pHead2First;
		 }else{
			 mul = num2 - num1;
			 pLongFirst = pHead2First;
			 pShortFirst = pHead1First;
		 }
		 //长的先走步 
		 for(int i = 0;i < mul;i++){
			 pLongFirst = pLongFirst.next;
		 }
		 //一起比较
		 while(pLongFirst!=null&&pShortFirst!=null&&pLongFirst!=pShortFirst){
			 pLongFirst = pLongFirst.next;
			 pShortFirst = pShortFirst.next;
		 }
		 if(pLongFirst==pShortFirst){
		 pSameFirst = pLongFirst;
		 }
		 return pSameFirst;
    }
	
}
 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
