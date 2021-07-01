package com.graphs;

import java.util.*;

public class DFS {

    public static void main(String[] args) {
        DFS dfs = new DFS();
        DemoGraph graph = new DemoGraph();
        Stack<Integer> st = new Stack<>();
        st.push(0);
        Map<Integer, Boolean> visited = new HashMap<>();
        for(Integer k : graph.gp.keySet()){
            visited.put(k, false);
        }
        dfs.performDFS(graph.gp, st, visited);

    }

    public void performDFS(Map<Integer, List<Integer>> gp, Stack<Integer> st, Map<Integer, Boolean> visited){
        int x = st.pop();
        List<Integer> neighbours = gp.get(x);
        System.out.print(x+"\t");
        visited.replace(x, true);
        for(Integer n : neighbours){
            if(!visited.get(n)) {
                st.push(n);
                performDFS(gp, st, visited);
            }
        }
    }
}
