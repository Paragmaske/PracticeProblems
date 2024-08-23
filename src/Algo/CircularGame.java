package Algo;


class LinkedList1 {
	
}

public class CircularGame {
	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	static Node addNode(Node head, int data) {

		if (head == null) {
			head = new Node(data);
		} else {

			Node curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = new Node(data);
		}

//		Node p = head;
//		while (p != null) {
//			System.out.print(p.data+" ");
//			p = p.next;
//		}
//		System.out.println();
		return head;

	}
	public static int findTheWinner(int n, int k) {
		
		head = new Node(1);
		for (int i = 2; i <= n; i++) {
			addNode(head, i);
		}
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = head;

		int count = 1;
		Node pi = head;
		while (pi.next != null) {
			if (count == (k - 1) ) {
				Node next = pi.next.next;
				pi.next.next = null;
				pi.next = next;
				
				count = 1;
			} else {

				count++;
			}
			
			pi = pi.next;
			if(pi.data==pi.next.data) return pi.data;
		}
		return -1;

	}

	public static void main(String[] args) {
		System.out.println(findTheWinner(6, 1));
	}
}
