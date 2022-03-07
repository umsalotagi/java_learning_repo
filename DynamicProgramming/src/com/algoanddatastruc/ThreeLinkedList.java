package com.algoanddatastruc;

import java.util.Arrays;
import java.util.LinkedList;

public class ThreeLinkedList {
	
	public static void main(String[] args) {
		// when inserting and deleting data is more frequent than accessign then we need to use LinkedList 
		// each element is contained of node. node also stores the reference of next Node.
		
		Node x = new Node("apple");
		System.out.println(x);
		
		SinglyLinkedList ll = new SinglyLinkedList();
		ll.head = x;
		ll.add("Two");
		ll.add("Three");
		System.out.println(ll.size());
		System.out.println(ll);
		//System.out.println(ll.search("Twoo"));
		ll.insert("One", 2);
		System.out.println(ll);
		System.out.println(ll.remove("Threee"));
		System.out.println(ll);
		
		LinkedList<String> dl = new LinkedList<String>(Arrays.asList("One","Two", "Three"));
		System.out.println(dl.get(2) + " .." + dl.getLast()); // we have get by index here
		dl.addFirst("Zero");
		dl.addLast("Four");
		System.out.println(dl + dl.peek());
		
	}
	
	// Object for storing single node of linked list 
	static class Node {
		Node nextNode = null;
		String data = null;
		
		public Node(String data) {
			this.data = data;
		}
		
		public String toString() {
			return "<Node data: " + data + ">";
		}
	}
	
	static class SinglyLinkedList {
		Node head = null;
		
		// we are hiding this constructor to facilitate creation of empty linked list
//		public SinglyLinkedList (Node head) {
//			this.head = head;
//		}
		
		// TODO:
		// remove by index
		// node at index
		
		public boolean isEmpty() {
			return this.head==null;
		}
		
		public int size() {
			// takes liner time 
			int total=0;
			Node current = head;
			while (current!=null) {
				total+=1;
				current = current.nextNode;
			}
			return total;
		}
		
		public void add(String x) {
			// adds new not containing data at head of list
			// takes constant time
			Node node = new Node(x);
			node.nextNode = head;
			head = node;
		}
		
		public Node search(String key) {
			// search for first Node containing data which matches key. returns null if not found
			// takes liners time. O(n)
			Node current = head;
			while(current!=null) {
				if (current.data.equals(key)) {
					return current;
				}
				current = current.nextNode;
			}
			return null;
		}
		
		public void insert(String data, int index) {
			// takes liner time as transversing list is necessary to find element at given index
			// transversing list takes linear time, hence function takes liner time
			if (index==0) {
				add(data);
				return;
			}
			Node prev = null;
			Node next = head;
			int count = index;
			while(count>0 && next!=null) {
				prev = next;
				next = next.nextNode;
				count--;
				//if (next==null) break; // or we can use try catch , for NullPointerException
			}
			if (count==0) {
				Node n = new Node(data);
				n.nextNode = next;
				prev.nextNode = n;
			} else {
				System.out.println("Index out of bound, "+index);
			}
		}
		
		public Node remove(String key) {
			// removes the Node that matches key data. returns the Node removed or null if not present
			// takes linear time
			Node current = head;
			boolean isFound = false;
			Node priv = null;
			
			while( current!=null && !isFound) {
				if (current.data.equals(key) && current == head) {
					isFound = true;
					head = current.nextNode;
				} else if (current.data.equals(key)) {
					isFound = true;
					priv.nextNode = current.nextNode;
				} else {
					priv = current;
					current = current.nextNode;
				}
			}
			return current;
		}
		
		public Node nodeAt(int index) {
			Node current = this.head;
			int position = 0;
			while(position < index) {
				current = current.nextNode;
				position++;
			}
			return current;
		}
		
		public String toString() {
			// takes liner time O(n)
			Node current = head;
			StringBuilder sb = new StringBuilder();
			while(current!=null) {
				
				if (current==head) {
					// this is head
					sb.append("Head : " + current.data + "-> ");
				} else if (current.nextNode==null) {
					// this is tail
					sb.append("Tail: " + current.data);
				} else {
					sb.append(current.data+"-> ");
				}
				current = current.nextNode;
				
			}
			return sb.toString();
		}
	}

}