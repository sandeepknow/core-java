package com.defy.cache;

import java.util.HashMap;

public class LRUCache {

	int limit;
	HashMap<Integer, Node> map = null;
	Node start = null;
	Node end = null;

	LRUCache(int limit) {
		this.limit = limit;
		map = new HashMap<Integer, Node>();
	}

	int getEntry(int key) {

		if (map.containsKey(key)) {
			Node node = map.get(key);
			addToTop(node);
			removeNode(node);
			return node.value;
		}

		return -1;
	}

	void putEntry(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			addToTop(node);
			removeNode(node);
		} else {
			Node newNode = new Node();
			newNode.key = key;
			newNode.value = value;
			newNode.left = null;
			newNode.right = null;
			if (map.size() > limit) {
				map.remove(end.key);
				removeNode(end);
				addToTop(newNode);
			} else {
				addToTop(newNode);
			}
			map.put(key, newNode);
		}
	}

	void addToTop(Node node) {
		node.right = start;
		node.left = null;
		if (start != null)
			start.left = node;
		start = node;
		if (end == null)
			end = start;
	}

	void removeNode(Node node) {
		if (node.left != null) {
			node.left.right = node.right;
		} else {
			start = node.right;
		}

		if (node.right != null) {
			node.right.left = node.left;
		} else {
			end = node.left;
		}
	}
	
	
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		LRUCache lrucache = new LRUCache(5);
		lrucache.putEntry(1, 1);
		lrucache.putEntry(10, 15);
		lrucache.putEntry(15, 10);
		lrucache.putEntry(10, 16);
		lrucache.putEntry(12, 15);
		lrucache.putEntry(18, 10);
		lrucache.putEntry(13, 16);

		System.out.println(lrucache.getEntry(1));
		System.out.println(lrucache.getEntry(10));
		System.out.println(lrucache.getEntry(15));

	}

	class Node {
		int key;
		int value;
		Node left;
		Node right;
	}
}
