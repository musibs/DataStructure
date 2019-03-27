package com.codefountain.ds.lds.linkedlist;

import java.util.Objects;

/**
 * Single Linked list implementation 
 * 
 * @author Somnath Musib [Tata Consultancy Services Ltd]
 *
 * @param <T>
 */
public class LinkedList<T> {
	
	/**
	 * Head of the node
	 */
	private Node<T> head;
	
	/**
	 * Creates the empty list
	 */
	public LinkedList() {
		this.head = null;
	}
	
	/**
	 * Add an element at the beginning of the list
	 * 
	 * @param item
	 */
	public void addFirst(T item) {
		this.head = new Node<T>(item, head); 
	}
	
	/**
	 * Add an element after a given node
	 * 
	 * @param previousNode
	 * @param item
	 * @return
	 */
	public boolean addAfter(Node<T> previousNode, T item) {
		if(Objects.isNull(previousNode)) {
			return false;
		}
		
		Node<T> newNode = new Node<T>(item, previousNode.next);
		previousNode.next = newNode;
		return true;
	}
	
	/**
	 * Add an item at the end of the list
	 * 
	 * @param item
	 */
	public void addLast(T item) {
		if(Objects.isNull(head)) {
			Node<T> node = new Node<T>(item, null);
			head = node;
			return;
		}
		
		Node<T> temp = head;
		while(Objects.nonNull(temp.next)) {
			temp = temp.next;
		}
		
		Node<T> lastNode = new Node<T>(item, null);
		temp.next = lastNode;
	}
	
	/**
	 * Deletes the head node of the list
	 * @return
	 */
	public boolean deleteHeadNode() {
		if(Objects.nonNull(head)) {
			head = head.next;
			return true;
		}
		return false;
	}
	
	public void deleteAnyElement(T key) {
		
		if(Objects.isNull(head)) {
			return;
		}
		
		if(head.item == key) {
			head = head.next;
			return;
		}
		
		Node<T> prev = null;
		Node<T> temp = head;
		
		while(Objects.nonNull(temp) && temp.item != key) {
			prev = temp;
			temp = temp.next;
		}
		
		if(temp == null) {
			System.out.println("Key not found");
			return;
		}
		
		prev.next = temp.next;
	}
	
	public void deleteSpecificPostion(int position) {
		if(Objects.isNull(head)) {
			return;
		}
		
		Node<T> prev = null;
		Node<T> temp = head;
		int count = 1;
		while(Objects.nonNull(temp)) {
			count++;
			prev = temp;
			temp = temp.next;
			if(count == position) {
				prev.next = temp.next;
				return;
			}
		}
	}
	
	public int lengthThgroughIterative() {
		
		int count = 0;
		if(Objects.isNull(head)) {
			return count;
		}
	
		Node<T> temp = head;
		while(Objects.nonNull(temp)) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	private int lengthRecursive(Node<T> node) {
		if(Objects.isNull(node)) {
			return 0;
		}
		else return 1+lengthRecursive(node.next);
	}
	
	public int lengthThgroughRecursive() {
		return lengthRecursive(head);
	}
	
	
	public boolean findByIteration(T key) {
		if(Objects.isNull(head)) {
			return false;
		}
		else {
			Node<T> temp = head;
			while(Objects.nonNull(temp) && temp.item != key) {
				temp = temp.next;
			}
			
			if(Objects.isNull(temp)) {
				return false;
			}
			else {
				return true;
			}
		}
	}
	
	private boolean findThroughRecursion(Node<T> node, T key) {
		if(Objects.isNull(node)) {
			return false;
		}
		if(node.item == key) {
			return true;
		}
		return findThroughRecursion(node.next, key);
	}
	
	public boolean findByRecursion(T key) {
		return findThroughRecursion(head, key);
	}
	
	//Bad impl : traversing the list twice!!
	public T findNthItem(int nthPosition) {
		if(Objects.isNull(head) || size() < nthPosition) {
			throw new IllegalArgumentException("Empty list or out of range");
		}
		
		Node<T> prev = null;
		Node<T> temp = head;
		for(int i=0; i<nthPosition; i++) {
			prev = temp;
			temp = temp.next;
		}
		return prev.item;
	}
	
	
	/**
	 * Returns the size of the list
	 * 
	 * @return
	 */
	public T findNthItemEff(int nthPosition) {
		
		Node<T> temp = head;
		int count = 0;
		
		while(Objects.nonNull(temp)) {
			if(count == nthPosition) {
				return temp.item;
			}
			temp = temp.next;
			count++;
		}
		throw new IllegalArgumentException("Invalid Position");
	}
	
	/**
	 * Returns the size of the list
	 * 
	 * @return
	 */
	public int size() {
		
		int count = 0;
		Node<T> position = head;
		while(Objects.nonNull(position)) {
			count++;
			position = position.next;
		}
		return count;
	}
	
	/**
	 * Finds an element from the list
	 * @param item
	 * @return
	 */
	public Node<T> find(T item) {
		Node<T> position = head;
		T itemAtPosition;
		while(Objects.nonNull(position)) {
			itemAtPosition = position.item;
			if(itemAtPosition.equals(item)) {
				return position;
			}
			position = position.next;
		}
		return null;
	}
	
	/**
	 * Verifies if the item contains in the list
	 * 
	 * @param item
	 * @return
	 */
	public boolean contains(T item) {
		return Objects.nonNull(find(item));
	}
	
	/**
	 * Prints the list
	 */
	public void outputList() {
		Node<T> position = head;
		while(Objects.nonNull(position)) {
			System.out.print(position.item+" ");
			position = position.next;
		}
	}
	
	
	public boolean isEmpty() {
		return Objects.isNull(head);
	}
	
	public void clear() {
		head = null;
	}

	private static class Node<T>{
		
		private T item;
		private Node<T> next;
		
		public Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;
		}
		
	}
	
}
