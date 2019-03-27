package com.codefountain.ds.lds.linkedlist;

public class LinkedListRunner {

	public static void main(String[] args) {
		
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.addFirst("1");
		linkedList.addFirst("2");
		linkedList.addFirst("3");
		linkedList.addFirst("4");
		linkedList.addFirst("5");
		linkedList.addLast("6");
		linkedList.addAfter(linkedList.find("3"), "3.5");
		linkedList.deleteHeadNode();
		linkedList.outputList();
		
	}
}
