package com.codefountain.ds.lds.array;

public class ArrayBasics {

	private int[] theArray = new int[30];
	private int arraySize = 10;
	
	
	public void createArray() {
		for(int i=0; i<arraySize; i++) {
			theArray[i] = (int)(Math.random()*10) + 10;
		}
	}
	
	public void printArray() {
		System.out.println("---------");
		for(int i=0; i< arraySize; i++) {
			System.out.print("| "+i+" | ");
			System.out.println(theArray[i]+" |");
			System.out.println("---------");
		}
	}
	
	public int search(int index) {
		
		if(index < arraySize) {
			return theArray[index];
		}
		else {
			return -1;
		}
	}
	
	public boolean isExists(int number) {
		for(int i=0; i<arraySize; i++) {
			if(number == theArray[i]) {
				return true;
			}
		}
		return false;
	}
	
	public void deleteElement(int index) {
		if(index<arraySize) {
			for(int i=index; i< (arraySize-1); i++) {
				theArray[i] = theArray[i+1];
			}
		}
		arraySize--;
	}
	
	public void addElement(int element) {
		if(arraySize < 50) {
			theArray[arraySize] = element;
		}
		arraySize++;
	}
	
	public void addElementInSpecificIndex(int index, int element) {
		if(index > theArray.length-1) {
			throw new IllegalArgumentException("Invalid Index Poasition");
		}
		
		if(index > arraySize) {
			theArray[arraySize] = element;
			arraySize++;
			return;
		}
		
		else {
			for(int i=arraySize; i>=index; i--) {
				theArray[i+1] = theArray[i]; 
			} 
			theArray[index] = element;
			arraySize++;
		}
		
	}
	
	public void linearSerach(int value) {
		boolean isFound = false;
		System.out.print(value +" is found in follwing indexes: ");
		for(int i=0; i<arraySize; i++) {
			if(theArray[i]== value) {
				isFound = true;
				System.out.print(i+" ");
			}
		}
		if(!isFound) {
			System.out.println("none");
		}
	}
	
	public static void main(String[] args) {
		
		ArrayBasics array = new ArrayBasics();
		array.createArray();
		array.printArray();
		System.out.println(array.search(2));
		System.out.println(array.isExists(14));
		array.deleteElement(2);
		array.printArray();
		array.addElement(21);
		array.printArray();
		array.addElementInSpecificIndex(11, 56);
		array.printArray();
		array.linearSerach(12);
	}
	
	
	
}
