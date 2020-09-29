package com.defy;

import java.util.HashMap;
import java.util.Map;

public class MyLRUCache {

	int capacity;
	Map<Integer, Node> cache = new HashMap<Integer, Node>();
	Node head = null;
	Node end = null;

	MyLRUCache(int capacity) {
		this.capacity = capacity;
	}

	int get(int key) {
		if (cache.containsKey(key)) {
			Node node = cache.get(key);
			delete(node);
			setHead(node);
			return node.value;
		}

		return -1;
	}

	void delete(Node node) {

		
	}

	void setHead(Node node) {

	}
	
	void set(int value) {
		
	}
}

class Node {
	int key;
	int value;
	Node prev;
	Node next;

	Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}