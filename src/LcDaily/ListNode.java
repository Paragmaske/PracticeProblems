package LcDaily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ListNode {
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

	static int numComponents(ListNode head, int[] nums) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i : nums) {
			hs.add(i);
		}
		int count = 0;
		ListNode curr = head;
		while (curr != null) {
			while (curr != null && !hs.contains(curr.val)) {
				curr = curr.next;
			}

			if (head != null) {
				count++;
				while (curr != null && hs.contains(curr.val)) {
					curr = curr.next;
				}
			}
		}
		return count;

	}

	public static void main(String[] args) {

		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		//head.next.next.next = new ListNode(3);
		int[] nums = { 1,0 };
		System.out.println(numComponents(head, nums));
	}

}