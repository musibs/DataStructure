package com.codefountain.ds.lds.ll;

import java.util.Arrays;

import com.codefountain.ds.lds.ll.utils.ListUtils;

public class DoubleLinkedListRunner {

	public static void main(String[] args) {
		
		
		DoubleLinkedList<Integer> list = ListUtils.newDoubleLinkedList(Arrays.asList(1,2,3,4));
		list.iterate();
		
		list.linkAtBegining(0);
		list.iterate();
		
		list.linkBeforeNode(list.find(2), 100);
		list.iterate();
		
		list.linkAfterNode(list.find(3), 5);
		list.iterate();
		
		System.out.println(list.find(3));
		
	}
}
