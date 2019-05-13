package com.sorting;

public class InsertionSort {
    int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort();
        insertionSort.display();
    }

    public void sort(){
        for(int i = 1; i< arr.length; i++){
            for(int j = i; j>0; j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    continue;
                }
                break;
            }
        }
    }

    public void display(){
        for (int x: arr) {
            System.out.print(x + "\t");
        }
    }
}


