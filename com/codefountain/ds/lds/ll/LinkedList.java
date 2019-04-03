package com.codefountain.ds.lds.ll;

import java.util.HashSet;
import java.util.Objects;

/**
 * This is an implementation of linked list data structure
 * 
 * @author Somnath Musib 
 *
 * @param <E>
 */
public class LinkedList<E> {
	
	/**
	 * Reference to the head of the listedlist
	 */
	private Node<E> head;
	
	
	/**
	 * Creates an empty list
	 */
	public LinkedList() {
		head = null;
	}
	
	/**
	 * Create a list with an item
	 * 
	 * @param item
	 * @param link
	 */
	public LinkedList(E item) {
		head = new Node<E>(item, null);
	}
	
	/**
	 * Traverse the linked list
	 */
	public void iterate() {
		System.out.println();
		if(Objects.isNull(head)) {
			throw new IllegalArgumentException("Empty list");
		}
		Node<E> tempNode = head;
		while(Objects.nonNull(tempNode.next)) {
			System.out.print(tempNode.item+" -> ");
			tempNode = tempNode.next;
		}
		System.out.print(tempNode.item);
		System.out.println();
	}	
	
	/**
	 * Add an item before the first node
	 * 
	 * @param item
	 * @return true, if added successfully
	 */
	public boolean linkBefore(E item) {
		
		if(Objects.isNull(head)) {
			head = new Node<E>(item, null);
			return true;
		}
		
		Node<E> tempNode = new Node<E>(item, null);
		tempNode.next = head;
		head = tempNode;
		return true;
	}
	
	/**
	 * Add an element after a given item
	 * 
	 * @param previousNode
	 * @param item
	 * @return
	 */
	public boolean linkAfter(Node<E> previousNode, E item) {
		
		if(Objects.isNull(previousNode)) {
			return false;
		}
		
		Node<E> tempNode = new Node<E>(item, null);
		tempNode.next = previousNode.next;
		previousNode.next=tempNode;
		
		return false;
		
	}
	
	/**
	 * Add an element at the end of the linked list
	 * 
	 * @param item
	 * @return
	 */
	public boolean add(E item) {
		if(Objects.isNull(head)) {
			head = new Node<E>(item, null);
			return true;
		}
		
		Node<E> tempNode = head;
		while(Objects.nonNull(tempNode.next)) {
			tempNode = tempNode.next;
		}
		
		Node<E> newNode = new Node<E>(item, null);
		tempNode.next = newNode;
		return true;
	}
	
	/**
	 * Finds a given element from the list
	 * 
	 * @param item
	 * @return
	 */
	public Node<E> find(E item){
		
		if(Objects.isNull(head)) {
			throw new IllegalArgumentException("Empty list");
		}
		
		Node<E> tempNode = head;
		while(Objects.nonNull(tempNode)) {
			if(item.equals(tempNode.item)) {
				return tempNode;
			}
			tempNode = tempNode.next;
		}
		
		throw new IllegalArgumentException("Item not found");
	}
	
	/**
	 * Delete the first element from the list
	 * 
	 * @return
	 */
	public boolean deleteHead() {
		if(Objects.isNull(head)) {
			throw new IllegalArgumentException("Empty list");
		}
		
		head = head.next;
		return true;
	}

	/**
	 * Deletes the last element from the list
	 * 
	 * @return
	 */
	public boolean deleteLast() {
		if(Objects.isNull(head)) {
			throw new IllegalArgumentException("Empty list");
		}
		
		Node<E> tempNode = head;
		Node<E> previous = null;
		
		
		while(Objects.nonNull(tempNode.next)) {
			previous = tempNode;
			tempNode = tempNode.next;
		}
		
		previous.next = null;
		return true;
	}
	
	/**
	 * Delete an item from a specific position
	 * 
	 * @param previousNode
	 * @return
	 */
	public boolean deleteAfter(Node<E> previousNode) {
		if(Objects.isNull(previousNode)) {
			throw new IllegalArgumentException("Empty list");
		}
		
		Node<E> nodeToBeDeleted = previousNode.next;
		previousNode.next = nodeToBeDeleted.next;
		return true;
	}
	
	/**
	 * Deletes the list
	 * 
	 * @return
	 */
	public boolean deleteList() {
		head = null;
		return true;
	}
	
	/**
	 * Finds the length of the list
	 * 
	 * @return
	 */
	public long length() {
		if(Objects.isNull(head)) {
			return 0;
		}
		
		long count = 0;
		Node<E> tempNode = head;
		while(Objects.nonNull(tempNode)) {
			count++;
			tempNode = tempNode.next;
		}
		return count;
	}
	
	
	private long lengthRecursive(Node<E> node, long count) {
		if(Objects.isNull(node)) {
			return count;
		}
		
		return 1 + lengthRecursive(node.next, count);
	}
	
	/**
	 * Finds the length of the list recursively
	 * 
	 * @return
	 */
	public long lengthRecursively() {
		return lengthRecursive(head, 0);
	}
	

	
	public Node<E> findNthElement(int nthPosition){
		if(Objects.isNull(head)) {
			throw new IllegalArgumentException("Empty list");
		}
		
		Node<E> tempNode = head;
		for(int i=0; i<nthPosition-1; i++) {
			if(Objects.isNull(tempNode)) {
				throw new IllegalArgumentException("Invalid position provided");
			}
			tempNode = tempNode.next;
		}
		return tempNode;
	}
	
	/**
	 * Finds the nth element from the end of the list
	 * 
	 * Implementation note: This is not an effective implementation as
	 * this traverse the list nearly twice. Once to calculate the length
	 * of the list and another to find the item in nth position
	 * 
	 * @param nthPosition
	 * @return
	 */
	public Node<E> findNthElementFromLast(int nthPosition){
		if(Objects.isNull(head)) {
			throw new IllegalArgumentException("Empty list");
		}
		
		Node<E> tempNode = head;
		for(int i=1; i< length()-nthPosition+1; i++) {
			tempNode = tempNode.next;
		}
		return tempNode;
	}
	
	/**
	 * Finds the nth element from the end of the list
	 * 
	 * <b>Implementation Note:</b> This is a better approach as in this approach, we traverse the 
	 * list only once. It uses two reference pointer to traverse the list simultaneously. 
	 * At first, First pointer traverse first n elements. Next, both the pointers traverse 
	 * the list simultaneously until first pointer reaches the end of the list. This leaves 
	 * the second pointer in the nth position
	 * 
	 * @param nthPosition
	 * @return
	 */
	public Node<E> findNthElementFromLastUsing2P(int nthPosition){
		if(Objects.isNull(head)) {
			throw new IllegalArgumentException("Empty list");
		}
		
		Node<E> firstPointer = head;
		Node<E> secondPointer = head;
		
		for(int i=1; i<nthPosition; i++) {
			firstPointer = firstPointer.next;
		}
		
		while(Objects.nonNull(firstPointer.next)) {
			firstPointer = firstPointer.next;
			secondPointer = secondPointer.next;
		}
		
		return secondPointer;
	}
	
	
	public Node<E> findMiddleElement(){
		if(Objects.isNull(head)) {
			throw new IllegalArgumentException("Empty list");
		}
		
		Node<E> fastPointer = head;
		Node<E> slowPointer = head;
		
		
		while(Objects.nonNull(fastPointer) && Objects.nonNull(fastPointer.next)) {
			fastPointer = fastPointer.next.next;
			if(Objects.isNull(fastPointer)) {
				return slowPointer;
			}
			slowPointer = slowPointer.next;
		}
		
		return slowPointer;
	}
	
	/**
	 * Reverse a linked list
	 */
	public void reverse() {
		if(Objects.isNull(head)) {
			throw new IllegalArgumentException("Empty list");
		}
		
		Node<E> previous = null;
		Node<E> current = head;
		Node<E> next = null;
		
		while(Objects.nonNull(current)) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}
	
	
	public int repeatCount(E item) {
		if(Objects.isNull(head)) {
			throw new IllegalArgumentException("Empty list");
		}
		
		Node<E> current = head;
		int count = 0;
		while(Objects.nonNull(current.next)) {
			if(item.equals(current.item)) {
				count++;
			}
			current = current.next;
		}
		return count;	
	}
	
	public Node<E> detectCycle() {
		Objects.requireNonNull(head, "Empty list");
		
		Node<E> fastPointer = head;
		Node<E> slowPointer = head;
		
		while(Objects.nonNull(slowPointer) && Objects.nonNull(fastPointer) && Objects.nonNull(fastPointer.next)) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			
			if(slowPointer.equals(fastPointer)) {
				return slowPointer;
			}
		}
		
		return null;
	}
	
	
	public Node<E> findStartOfLoop() {
		Node<E> loopNode = detectCycle();
		if(Objects.nonNull(loopNode)) {
			
			Node<E> startNode = head;
			
			while(!loopNode.equals(startNode)) {
				startNode = startNode.next;
				loopNode = loopNode.next;
			}
			return startNode;
		}
		return null;
	}
	
	public int lengthOfLoop() {
		Node<E> startOfTheLoop = findStartOfLoop();
		
		Node<E> endOfTheLoop = startOfTheLoop;
		int count = 0;
		while(!startOfTheLoop.next.equals(endOfTheLoop)) {
			count++;
			startOfTheLoop = startOfTheLoop.next;
		}
		return count;
	}
	
	/**
	 * Assumes the list is sorted
	 */
	public void removeDuplicateInSortedLinkedList() {
		Objects.requireNonNull(head, "Empty list");
		
		Node<E> previous = null;
		Node<E> current = head;
		
		while(Objects.nonNull(current) && Objects.nonNull(current.next)) {
			previous = current;
			current = current.next;
			if(previous.item.equals(current.item)) {
				System.out.println("Duplicate "+previous.item);
				previous.next = current.next;
				
				if(head.item.equals(previous.item)) {
					head.next = previous.next;
				}
			}
		}
	}
	
	/**
	 * Assumes the list is sorted
	 */
	public void removeDuplicateInSortedLinkedlist2() {
		Objects.requireNonNull(head, "Empty list");
		
		Node<E> current = head;
		Node<E> nextNext = null;
		while(Objects.nonNull(current.next)) {
			if(current.item.equals(current.next.item)) {
				nextNext = current.next.next;
				current.next = nextNext;
			}
			else {
				current = current.next;
			}
		}
	}
	
	/**
	 * Removes duplicates from a UNSORTED linked list. This is a Brute force
	 * algorithm and runs in O(n^2) time
	 */
	public void removeDuplicateInUnsortedLinkedList1_BF() {
		Objects.requireNonNull(head, "Empty list");
		
		Node<E> startPointer = head;
		Node<E> runnerPointer = null;
		
		while(Objects.nonNull(startPointer) && Objects.nonNull(startPointer.next)) {
			
			runnerPointer = startPointer;
			while(Objects.nonNull(runnerPointer.next)) {
				if(startPointer.item.equals(runnerPointer.next.item)) {
					runnerPointer.next = runnerPointer.next.next;
				}
				else {
					runnerPointer = runnerPointer.next;
				}
			}
			startPointer = startPointer.next;
		}
	}
	
	/**
	 * Removes duplicates from a UNSORTED linked list. This is an slightly optimized
	 * algorithm and runs in O(n) time but requires O(n) space
	 */
	public void removeDuplicateInUnsortedLinkedlist2_Hashing() {
		Objects.requireNonNull(head, "Empty list");
		
		Node<E> tempNode = head;
		Node<E> previous = null;
		
		HashSet<E> container = new HashSet<>();
		
		while(Objects.nonNull(tempNode)) {
			
			if(container.contains(tempNode.item)) {
				previous.next = tempNode.next;
			}
			else {
				container.add(tempNode.item);
				previous = tempNode;
			}
			tempNode = tempNode.next;
		}
	}
	
	
	public void swapData(E key1, E key2) {
		Objects.requireNonNull(head, "Empty list");
		
		
		Node<E> tempNode = head;
		
		while(Objects.nonNull(tempNode)) {
			
			if(tempNode.item.equals(key1)) {
				tempNode.item = key2;
				tempNode = tempNode.next;
				continue;
			}
			
			if(tempNode.item.equals(key2)) {
				tempNode.item = key1;
				tempNode = tempNode.next;
				continue;
			}
			tempNode = tempNode.next;
		}
	}
	
	public void swapNodes(E key1, E key2) {
		Objects.requireNonNull(head, "Empty list");
		
		if(key1.equals(key2)) {
			return;
		}
		
		Node<E> previousKey1 = null;
		Node<E> currentKey1 = head;
		
		while(Objects.nonNull(currentKey1) && !currentKey1.item.equals(key1)) {
			previousKey1 = currentKey1;
			currentKey1 = currentKey1.next;
		}
		
		Node<E> previousKey2 = null;
		Node<E> currentKey2 = head;
		
		while(Objects.nonNull(currentKey2) && !currentKey2.item.equals(key2)) {
			previousKey2 = currentKey2;
			currentKey2 = currentKey2.next;
		}
		
		
		if(Objects.isNull(currentKey1) || Objects.isNull(currentKey2)) {
			return;
		}
		
		if(Objects.nonNull(previousKey1)) {
			previousKey1.next = currentKey2;
		}
		else {
			head = currentKey2;
		}
		
		
		if(Objects.nonNull(previousKey2)) {
			previousKey2.next = currentKey1;
		}
		else {
			head = currentKey1;
		}
		iterate();
		Node<E> temp = currentKey1.next;
		currentKey1.next = currentKey2.next;
		currentKey2.next = temp;
	}
	
	
	public void pairwiseSwap() {
		Objects.requireNonNull(head, "Empty list");
		
		Node<E> tempNode = head;
		
		while(Objects.nonNull(tempNode) && Objects.nonNull(tempNode.next)) {
			E data = tempNode.item;
			tempNode.item = tempNode.next.item;
			tempNode.next.item = data;
			tempNode = tempNode.next.next;
		}
	}
	
	private void pairWiseSwapRecursive(Node<E> node) {
		if(Objects.isNull(node)) {
			return;
		}
		
		E data = node.item;
		node.item = node.next.item;
		node.next.item = data;
		
		pairWiseSwapRecursive(node.next.next);
	}
	
	public void pairwiseSwapRec() {
		pairWiseSwapRecursive(head);
	} 
	
	public void moveLastElementToTheFront() {
		Objects.requireNonNull(head, "Empty list");
		
		Node<E> tempNode = head;
		Node<E> previous = null;
		
		while(Objects.nonNull(tempNode.next)) {
			previous = tempNode;
			tempNode = tempNode.next;
		}
		
		previous.next = null;
		tempNode.next = head;
		head = tempNode;
	}
	
	public static void intersectionOfTwoSortedLinkedList(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		
		Objects.requireNonNull(list1);
		Objects.requireNonNull(list2);
		list1.iterate();
		list2.iterate();
		Node<Integer> tempNode1 = list1.head;
		Node<Integer> tempNode2 = list2.head;
		
		Objects.requireNonNull(tempNode1);
		Objects.requireNonNull(tempNode2);
		
		LinkedList<Integer> intersectionList = new LinkedList<>();
		
		while(Objects.nonNull(tempNode1) && Objects.nonNull(tempNode2)) {
			if(tempNode1.item.equals(tempNode2.item)) {
				intersectionList.add(tempNode1.item);
				tempNode1 = tempNode1.next;
				tempNode2 = tempNode2.next;
			}
			else if(tempNode1.item < tempNode2.item) {
				tempNode1 = tempNode1.next;
			}
			else {
				tempNode2 = tempNode2.next;
			}
		}
		intersectionList.iterate();
	}
	
	public static Node<Integer> findIntersectionOfTwoLinkedList(LinkedList<Integer> list1, LinkedList<Integer> list2){
		
		Objects.requireNonNull(list1);
		Objects.requireNonNull(list2);
		list1.iterate();
		list2.iterate();
		Node<Integer> tempNode1 = list1.head;
		Node<Integer> tempNode2 = list2.head;
		
		Objects.requireNonNull(tempNode1);
		Objects.requireNonNull(tempNode2);
		
		while(Objects.nonNull(tempNode1.next) && Objects.nonNull(tempNode2.next)) {
			if(tempNode1.next.equals(tempNode2.next)) {
				return tempNode1.next;
			}
			else {
				tempNode1 = tempNode1.next;
				tempNode2 = tempNode2.next;
			}
		}
		return null;
	}
	
	static class Node<E>{
		
		private E item;
		private Node<E> next;
		
		public Node(E item, Node<E> link){
			this.item = item;
			this.next = link;
		}

		
		public E getItem() {
			return item;
		}

		public Node<E> getNext() {
			return next;
		}


		public void setNext(Node<E> next) {
			this.next = next;
		}


		@Override
		public String toString() {
			return "Node [item=" + item + "]";
		}
	}
}
