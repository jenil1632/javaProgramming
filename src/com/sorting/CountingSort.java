package com.sorting;

public class CountingSort {
    int[] arr = {13, 7, 6, 45, 21, 9, 98, 99};
    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        countingSort.display(countingSort.sort());
    }

    public int[] sort(){
        int[] count = new int[100];

        for(int i = 0; i< arr.length; i++){
            count[arr[i]-1] ++;
        }
        for(int i=1; i<count.length; i++){
            count[i] += count[i-1];
        }
        int[] ans = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            ans[count[arr[i]-1]-1] = arr[i];
            count[arr[i]-1]--;
        }
        return ans;
    }

    public void display(int[] q){
        for (int x: q) {
            System.out.print(x + "\t");
        }
    }
}
