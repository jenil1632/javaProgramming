package com.sorting;

public class BubbleSort {
    int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort();
        bubbleSort.display();
    }

    public void sort(){
        for(int i = 0; i< arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public void display(){
        for (int x: arr) {
            System.out.print(x + "\t");
        }
    }
}
