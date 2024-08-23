package Wise;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

}

public class ReverseBetween {

	public static ListNode reverse(ListNode node) {
		ListNode prev = null;
		ListNode next = null;
		ListNode curr = node;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;

	}

	public static ListNode reverseBetween(ListNode head, int left, int right) {
		int count = 0;
		ListNode nodeleft = null;
		ListNode rightNode = null;
		ListNode curr = head;

		ListNode nodeToReverse = null;
		while (curr != null) {
			count++;
			if (count == left - 1) {
				nodeToReverse = curr.next;

				nodeleft = curr;
			}
			if (count == right) {
				rightNode = curr.next;
			}
			curr = curr.next;
		}
		nodeleft.next=null;
		ListNode rp=nodeToReverse;
		while(rp!=null)
		{
			if(rp.next==rightNode)
			{
				rp.next=null;
			}
			rp=rp.next;
		}
		
		ListNode reverse = reverse(nodeToReverse);
		
		nodeleft.next=reverse;
		ListNode rh=reverse;
		
		while(rh.next!=null)
		{
			rh=rh.next;
		}
		rh.next=rightNode;
		
		//print 
		
		while(nodeleft!=null)
		{
			System.out.println(nodeleft.val);
			nodeleft=nodeleft.next;
		}
		
		return nodeleft;
	}

	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
//		l.next.next = new ListNode(3);
//		l.next.next.next = new ListNode(4);
//		l.next.next.next.next = new ListNode(5);
//		l.next.next.next.next.next = new ListNode(6);
		reverseBetween(l, 1, 2);
	}

}
