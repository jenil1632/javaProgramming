package com.sorting;

public class SelectionSort {
    int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort();
        selectionSort.display();
    }

    public void sort(){
        for(int i = 0; i< arr.length-1; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public void display(){
        for (int x: arr) {
            System.out.print(x + "\t");
        }
    }
}
