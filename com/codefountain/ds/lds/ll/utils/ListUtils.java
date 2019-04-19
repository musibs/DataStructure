package com.codefountain.ds.lds.ll.utils;

import java.util.List;

import com.codefountain.ds.lds.ll.DoubleLinkedList;
import com.codefountain.ds.lds.ll.LinkedList;

public final class ListUtils {

	
	public static <E> LinkedList<E> newList(List<E> items){
		LinkedList<E> newList = new LinkedList<>();
		for(E item : items) {
			newList.add(item);
		}
		return newList;
	}
	
	public static <E> DoubleLinkedList<E> newDoubleLinkedList(List<E> items){
		DoubleLinkedList<E> newList = new DoubleLinkedList<>();
		for(E item : items) {
			newList.add(item);
		}
		return newList;
	}

	
}
