package com.sorting;

public class QuickSort {
    private int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.sort(quickSort.arr.length-1, 0, quickSort.arr.length-1);
        quickSort.display();
    }

    public void sort(int p, int l, int u){
        if(l!=u){
            int curr = p;
            for(int i=l; i<=u; i++){
                if(i==p)
                    continue;
                else{
                    if((arr[i]>arr[curr] && i < curr)|| (arr[i]<arr[curr] && i > curr)){
                        int temp = arr[i];
                        arr[i] = arr[curr];
                        arr[curr] = temp;
                        curr = i;
                    }
                }
            }
            if(curr==l){
                sort(u, l+1, u);
            }
            else if(curr==u) {
                sort(u-1, l, u-1);
            }
            else {
                sort(curr-1, l, curr-1);
                sort(u, curr+1, u);
            }
        }
    }

    public void display(){
        for (int x: arr) {
            System.out.print(x + "\t");
        }
    }
}
