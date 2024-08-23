package Algo;

public class LinkedList {
	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.head = new ListNode(5);
		l.head.next = new ListNode(3);
		l.head.next.next = new ListNode(1);
		l.head.next.next.next = new ListNode(2);
		l.head.next.next.next.next = new ListNode(5);
		l.head.next.next.next.next.next = new ListNode(1);
		l.head.next.next.next.next.next.next = new ListNode(2);
		criticalPoints(l.head);
		// ListNode mergeNodes = mergeNodes(l.head);

//		while (mergeNodes != null) {
//			System.out.println(mergeNodes.val);
//			mergeNodes = mergeNodes.next;
//		}
	}

	private static int[] criticalPoints(ListNode head) {
		ListNode prev = null;
		ListNode next = null;

		return null;

	}

	public static ListNode mergeNodes(ListNode head) {
		ListNode curr = head;
		ListNode currZero = head;
		curr = curr.next;
		int Value = 0;
		while (curr != null) {
			if (curr.next.val == 0) {
				currZero.next = null;
				currZero.next = curr.next;
				currZero = curr.next;
				curr.next.val = Value + curr.val;
				curr = curr.next.next;
				Value = 0;
				continue;
			}
			Value += curr.val;
			curr = curr.next;

		}
		return head.next;
	}
}
