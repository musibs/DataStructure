package com.codefountain.ds.lds.ll;

import java.util.Objects;

public class DoubleLinkedList<E> {

	private Node<E> head = null;
	private Node<E> tail = null;
	
	public DoubleLinkedList() {
		head = null;
	}
	
	public DoubleLinkedList(E element) {
		this.head = null;
		this.tail = null;
	}
	
	
	public void linkAtBegining(E element) {
		if(Objects.isNull(head)) {
			head = new Node<E>(element);
			return;
		}
		
		Node<E> newNode = new Node<E>(element);
		newNode.next = head;
		newNode.previous = null;
		
		head.previous = newNode;
		
		head = newNode;
	}
	
	public void linkBeforeNode(Node<E> givenNode, E element) {
		Objects.requireNonNull(givenNode, "Node can't be null");
		final Node<E> newNode = new Node<E>(element);
		
		newNode.previous = givenNode.previous;
		newNode.next = givenNode;
		
		if(givenNode.previous != null) {
			givenNode.previous.next = newNode;
		}
		else {
			head = newNode;
		}
		
		givenNode.previous = newNode;
	}

	
	public Node<E> find(E element){
		Objects.requireNonNull(head, "Empty list");
		
		
		Node<E> tempNode = head;
		
		while(Objects.nonNull(tempNode)) {
			if(tempNode.element.equals(element)) {
				return tempNode;
			}
			tempNode = tempNode.next;
		}
		return null;
	}
	
	public void linkAfterNode(Node<E> givenNode, E element) {
		Objects.requireNonNull(givenNode);
		
		final Node<E> newNode = new Node<E>(element);
		
		newNode.next = givenNode.next;
		givenNode.next = newNode;
		newNode.previous = givenNode;
		
		if(Objects.nonNull(givenNode.next)) {
			givenNode.next.previous = newNode;
		}
	}
	
	
	
	public void add(E element) {
		if(Objects.isNull(head)) {
			head = new Node<E>(element);
			return;
		}
		
		Node<E> runnerNode = head;
		
		while(Objects.nonNull(runnerNode.next)) {
			runnerNode = runnerNode.next;
		}
		
		Node<E> tempNode = new Node<E>(element);
		runnerNode.next = tempNode;
		tempNode.previous = runnerNode;
	}
	
	public void iterate() {
		Objects.requireNonNull(head, "Empty list");
		
		Node<E> runnerNode = head;
		while(Objects.nonNull(runnerNode.next)) {
			
			System.out.print(runnerNode.element+"=>");
			runnerNode = runnerNode.next;
		}

		System.out.println(runnerNode.element);
	}
	
	
	static class Node<E>{
		
		private E element;
		private Node<E> previous;
		private Node<E> next;
		
		public Node(E element){
			this.element = element;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getPrevious() {
			return previous;
		}

		public Node<E> getNext() {
			return next;
		}

		@Override
		public String toString() {
			return "Node [element=" + element +"]";
		}
	}
}
