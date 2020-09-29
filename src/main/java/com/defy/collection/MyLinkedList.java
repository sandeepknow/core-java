package com.defy.collection;

public class MyLinkedList {

	static Node head = null;

	static class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
			next = null;
		}
	}

	static Node reverseList(Node node) {

		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		return prev;
	}
	
	static void printList(Node node) {
		
		while(node!=null) {
			System.out.println(node.value);
			node = node.next;
		}
	}
	
	public static void main(String[] a) {
		
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.head = new Node(1);
		myLinkedList.head.next = new Node(2);
		myLinkedList.head.next.next = new Node(3);
		myLinkedList.head.next.next.next = new Node(4);
		myLinkedList.head.next.next.next.next = new Node(5);
		
		System.out.println("Print original List");
		printList(myLinkedList.head);
		
		System.out.println("Print List after reversed");
		printList(reverseList(myLinkedList.head));
		
	}

}
