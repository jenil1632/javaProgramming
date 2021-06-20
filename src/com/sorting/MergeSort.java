package com.sorting;

public class MergeSort {

    public static void main(String[] args) {
     MergeSort mergeSort = new MergeSort();
        int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};
        mergeSort.sort(arr, 0, arr.length-1);
        mergeSort.display(arr);
    }

    public void sort(int[] arr, int l, int u) {
        if(l < u){
            int mid = (l+u)/2;
            int arr1[] = new int[mid-l+1];
            int[] arr2 = new int[u-mid];
            int count =0;
            for(int i=0; i<arr1.length; i++){
                arr1[i] = arr[count];
                count++;
            }
            for(int i=0; i<arr2.length; i++){
                arr2[i] = arr[count];
                count++;
            }
            sort(arr1, l, mid);
            sort(arr2, mid+1, u);
            int a =0, b=0;
            for(int i=0; i<arr.length;i++){
             if(a == arr1.length){
                 arr[i] = arr2[b];
                 b++;
             }
             else if(b==arr2.length){
                 arr[i] = arr1[a];
                 a++;
             }
             else{
                 if(arr1[a] <= arr2[b]){
                     arr[i] = arr1[a];
                     a++;
                 } else{
                     arr[i] = arr2[b];
                     b++;
                 }
             }
            }
        }
    }

    public void display(int[] a){
        for (int x: a) {
            System.out.print(x + "\t");
        }
    }
}
