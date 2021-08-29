package com.strings;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {
    public static void main(String[] args) {
        StringPermutation stringPermutation = new StringPermutation();
        String s = "AABC";
        Map<Character, Integer> mp = new HashMap<>();
        for(char c : s.toCharArray()){
            mp.computeIfPresent(c, (key, value)-> value+1);
            mp.computeIfAbsent(c, (key)-> 1);
        }
        stringPermutation.printPermutation(mp, 0, new char[s.length()]);
    }

    public void printPermutation(Map<Character, Integer> mp, int level, char[] arr){
        if(level==arr.length){
            for(char c : arr)
                System.out.print(c + "\t");
            System.out.println();
        }
        else {
            for(Map.Entry<Character, Integer> x : mp.entrySet()){
                if(x.getValue()>0){
                    arr[level] = x.getKey();
                    x.setValue(x.getValue()-1);
                    printPermutation(mp, level+1, arr);
                    x.setValue(x.getValue()+1);
                }
            }
        }
    }
}
