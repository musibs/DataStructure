package com.codefountain.ds.lds.ll;

import java.util.Arrays;

public class Runner {

	public static void main(String[] args) {
		
		//LinkedList<Integer> list = ListUtils.newList(Arrays.asList(0,1,2,3));
		//LinkedList<Integer> list = ListUtils.newList(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16));
		//list.iterate();
		/*System.out.println(list.length());
		System.out.println(list.lengthRecursively());
		list.iterate();
		list.deleteHead();
		list.iterate();
		list.deleteLast();
		list.iterate();
		list.deleteAfter(list.find(1));
		list.iterate();*/
		
		//list.iterate();
		/*System.out.println(list.findNthElementFromLast(2));
		System.out.println(list.findNthElementFromLastUsing2P(2));*/
		
		//System.out.println(list.findMiddleElement());
		
		/*list.reverse();
		list.iterate();
		
		System.out.println(list.repeatCount("E"));*/
		/*list.find("L").setNext(list.find("C"));
		System.out.println(list.lengthOfLoop());*/
		
		//list.removeDuplicateInUnsortedLinkedList1_BF();
		//list.removeDuplicateInUnsortedLinkedlist2_Hashing();
		//list.swapData(1, 5);
		//list.swapNodes(1, 12);
		/*list.pairwiseSwap();
		list.iterate();
		list.pairwiseSwapRec();
		list.iterate();*/
		
		/*list.moveLastElementToTheFront();*/
		
		/*LinkedList<Integer> list1 = ListUtils.newList(Arrays.asList(1,2,3,4,6));
		LinkedList<Integer> list2 = ListUtils.newList(Arrays.asList(2,4,6,8));
		LinkedList.intersectionOfTwoSortedLinkedList(list1, list2);*/
		
		LinkedList<Integer> list1 = ListUtils.newList(Arrays.asList(3,6,9,15,30));
		LinkedList<Integer> list2 = ListUtils.newList(Arrays.asList(10));
		
		LinkedList.intersectionOfTwoSortedLinkedList(list1, list2);
		
		//list.iterate();
	}
}
