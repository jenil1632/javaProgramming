package com.sorting;

public class HeapSort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};
        for(int i=1; i<arr.length; i++){
            heapSort.createHeap(arr, i);
        }
        heapSort.sort(arr);
        heapSort.display(arr);
    }

    public void createHeap(int[] arr, int x){
        if(x > 0 && arr[x/2] < arr[x]){
            swap(arr,x/2, x);
            createHeap(arr, x/2);
        }

    }

    public void sort(int[] arr){
        for(int i=arr.length-1; i>0; i--){
            swap(arr, 0, i);
            heapify(arr, i-1, 0);
        }
    }

    public void heapify(int[] arr, int n, int i){

        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left <= n && right >n){
            if(arr[left] > arr[i]){
                swap(arr, left, i);
                heapify(arr, n, left);
            }
        }
        else if(left <=n && right <= n){
            int max = arr[left] > arr[right] ? left : right;
            if(arr[max] > arr[i]){
                swap(arr, max, i);
                heapify(arr, n, max);
            }
        }
    }

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void display(int[] arr){
        for (int x: arr) {
            System.out.print(x + "\t");
        }
    }
}
