package com.codefountain.ds.lds.array;

public class SortingAlgorithms {

	
	private int[] myArray = new int[30];
	private int arraySize = 10;
	
	private void createRandomArray() {
		for(int i=0; i<arraySize; i++) {
			myArray[i] = (int)(Math.random()*10)+10;
		}
	}
	
	private void printArray() {
		System.out.println("--------------------------------------------------");
		System.out.print("| ");
		for(int i=0; i<arraySize; i++) {
			System.out.print(myArray[i]+" | ");
		}
		System.out.println();
		System.out.println("---------------------------------------------------");
	}
	
	
	/**
	 * <p>
	 * This method sorts an array in ascending order using bubble sort
	 * algorithm.
	 * 
	 * <b>Logic:</b> Bubble sort logic is simple. There are two loops. First loop
	 * traverse each array element. In second loop, for each array element,
	 * each adjacent elements are compared. In ascending order, the biggest
	 * element keeps bubbling and reaches to the end. 
	 * 
	 * In next iteration of first loop, last loop runs (total elements - ith number) 
	 * as up to ith element from last is already sorted.
	 * </p>
	 * <p><b>Time Complexity:</b> O(n^2) as it runs two loops O(n*n) => O(n^2)<p>
	 * <p><b>Stable:</b> Yes</p>
	 * <p><b>InPlace:</b> Yes</p>
	 */
	private void bubbleSort() {
		for(int i=0; i<arraySize-1;i++) {
			for(int j=0;j<arraySize-1-i;j++) {
				if(myArray[j] >= myArray[j+1]) {
					int temp = myArray[j];
					myArray[j] = myArray[j+1];
					myArray[j+1] = temp;
				}
			}
		}
		System.out.println("Bubble Sort:");
		printArray();
	}
	
	/**
	 * <p> This algorithm sorts an array in ascending order using selection sort algorithm.
	 * </p>
	 * <p><b>Logic:</b> Selection sort uses two loops. First loops is to traverse
	 * all the array elements. Inner loop is to search for the smallest element 
	 * in entire unsorted array. There are two parts in selection sort: sorted array
	 * and unsorted array. At the beginning, first element is considered as the minimum 
	 * element and store in a variable min_index. 
	 * 
	 * Inner loop starts at (first element+1) and traverse
	 * up to end of the list. In each iteration, the inner loop search for the lowest
	 * element by comparing the element at min_index with j (inner loop invariant).
	 * If an element smaller than previously assumed  min_index is found, then min_index
	 * is set to the newly found lowest element.
	 * 
	 * At the end, if lowest element is found, ith value and min_index values are swapped.
	 * 
	 * Thus, as the outermost loop proceed, left side elements are kept sorted.
	 * 
	 * </p>
	 * 
	 * <p><b>Time Complexity:</b>O(n^2)</p>
	 * <p><b>In Place:</b>Yes</p>
	 * <p><b>Stable</b>Yes</p>
	 */
	
	private void selectionSort() {
		int min_index;
		for(int i=0; i<arraySize-1; i++) {	
			min_index = i;
			for(int j=i+1;j<arraySize; j++) {
				if(myArray[j] < myArray[min_index]) {
					min_index = j;
				}
			}
			int temp = myArray[i];
			myArray[i] = myArray[min_index];
			myArray[min_index] = temp;
		}
		System.out.println("Selection Sort:");
		printArray();
	}
	
	private void insertionSort() {
		for(int i=1; i<arraySize; i++) {
			int key = myArray[i];
			int j = i-1;
			while(j >=0 && myArray[j] > key) {
				myArray[j+1] = myArray[j];
				j = j-1;
			}
			myArray[j+1] = key;
		}
		System.out.println("Insertion Sort:");
		printArray();
	}
	
	protected static void mergeSort() {
		sort(a, 0, arraySize-1);
		printArray();
	}
	
	private static void sort(int a[], int left, int right) {
		if(left < right) {
			int middle = (left+right)/2;
			sort(a, left, middle);
			sort(a, middle+1, right);
			merge(a, left, middle, right);
		}
	}
	
	
	private static void merge(int[] myArray, int left, int middle, int right) {
		
		
		int firstArraySize = middle-left+1;
		int secondArraySize = right-middle;
		
		int[] firstSubArray = new int[firstArraySize];
		int[] secondSubArray = new int[secondArraySize];
		
		for(int i=0; i<firstArraySize; i++) {
			firstSubArray[i] = myArray[left+i];
		}
		
		for(int i=0; i<secondArraySize; i++) {
			secondSubArray[i] = myArray[middle+1+i];
		}
		
		int i=0, j=0, k=left;
		
		while(i < firstArraySize && j < secondArraySize) {
			
			if(firstSubArray[i] <= secondSubArray[j]) {
				myArray[k] = firstSubArray[i];
				i++;
			}
			else {
				myArray[k] = secondSubArray[j];
				j++;
			}
			k++;
		}
		
		while( i< firstArraySize) {
			myArray[k] = firstSubArray[i];
			i++;
			k++;
		}
		
		
		while(j < secondArraySize) {
			myArray[k] = secondSubArray[j];
			j++;
			k++;
		}
	}
	
	public static void main(String[] args) {
		SortingAlgorithms array = new SortingAlgorithms();
		array.createRandomArray();
		array.printArray();
		//array.bubbleSort();
		//array.selectionSort();
		array.insertionSort();
	}

}
