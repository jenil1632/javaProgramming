package com.graphs;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {

        TopologicalSort sort = new TopologicalSort();
        Map<Integer, List<Integer>> gp = sort.createGraph();
        sort.topoSort(gp);

    }

    public void topoSort(Map<Integer, List<Integer>> gp){
        Stack<Integer> order = new Stack<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        for(Integer k : gp.keySet())
            visited.put(k, false);
        for(Integer k : gp.keySet()){
            Stack<Integer> st = new Stack<>();
            if(!visited.get(k)){
                st.push(k);
                performDFS(gp, st, order, visited);
            }
        }
        while(!order.empty())
            System.out.print(order.pop()+"\t");
    }

    public void performDFS(Map<Integer, List<Integer>> gp, Stack<Integer> st, Stack<Integer> order, Map<Integer, Boolean> visited){
        int x = st.pop();
        List<Integer> neighbours = gp.get(x);
        visited.replace(x, true);
        for(Integer n : neighbours){
            if(!visited.get(n)){
                st.push(n);
                performDFS(gp, st, order, visited);
            }
        }
        order.push(x);
    }

    public Map<Integer, List<Integer>> createGraph(){
        Map<Integer, List<Integer>> mp = new HashMap<>();
        List<Integer> a0 = new ArrayList<>();
        a0.add(1);
        a0.add(2);
        mp.put(0, a0);
        List<Integer> a1 = new ArrayList<>();
        a1.add(5);
        a1.add(2);
        mp.put(1, a1);
        List<Integer> a2 = new ArrayList<>();
        a2.add(3);
        mp.put(2, a2);
        List<Integer> a3 = new ArrayList<>();
        mp.put(3, a3);
        List<Integer> a4 = new ArrayList<>();
        mp.put(4, a4);
        List<Integer> a5 = new ArrayList<>();
        a5.add(3);
        a5.add(4);
        mp.put(5, a5);
        List<Integer> a6 = new ArrayList<>();
        a0.add(1);
        a0.add(5);
        mp.put(6, a6);
        return mp;
    }
}
