package com.sorting;

public class MergeSort {
    private int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};

    public static void main(String[] args) {
     MergeSort mergeSort = new MergeSort();
     mergeSort.display(mergeSort.sort(0, mergeSort.arr.length-1));
    }

    public int[] sort(int l, int u) {
        if(l==u){
            int[] ans = new int[1];
            ans[0] = arr[l];
            return ans;
        }
        else {
            int mid = (l+u)/2;
            int[] ans1 = sort(l, mid);
            int[] ans2 = sort(mid+1, u);
            int[] ans = new int[u-l+1];
            int count = 0, flag1 = 0, flag2 = 0;
            for(int i=l; i<=u; i++){
                if(flag1==ans1.length){
                    ans[count] = ans2[flag2];
                    flag2++;
                }
                else if(flag2==ans2.length){
                    ans[count] = ans1[flag1];
                    flag1++;
                }
                else {
                    if(ans1[flag1]>ans2[flag2]){
                        ans[count] = ans2[flag2];
                        flag2++;
                    }
                    else {
                        ans[count] = ans1[flag1];
                        flag1++;
                    }
                }
                count++;
            }
            return ans;
        }
    }

    public void display(int[] a){
        for (int x: a) {
            System.out.print(x + "\t");
        }
    }
}
