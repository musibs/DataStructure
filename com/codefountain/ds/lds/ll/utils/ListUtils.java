package com.codefountain.ds.lds.ll.utils;

import java.util.List;

public final class ListUtils {

	
	public static <E> LinkedList<E> newList(List<E> items){
		LinkedList<E> newList = new LinkedList<>();
		for(E item : items) {
			newList.add(item);
		}
		return newList;
	}

	
}
