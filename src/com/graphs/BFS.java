package com.graphs;

import java.util.*;

public class BFS {

    public static void main(String[] args) {
        BFS bfs = new BFS();
        DemoGraph graph = new DemoGraph();
        System.out.println(bfs.performBFS(graph.gp, 8, 7));
    }

    public int performBFS(Map<Integer, List<Integer>> gp, int s, int e){

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        Map<Integer, Integer> distances = new HashMap<>();
        for(Integer k : gp.keySet()){
            visited.put(k, false);
            distances.put(k, Integer.MAX_VALUE);
        }

        queue.add(s);
        distances.replace(s, 0);

        int dist = 0;
        while(queue.size() > 0){
            int x = queue.poll();
            if(x == e) {
                dist = distances.get(x);
                break;
            }
            visited.replace(x, true);
            List<Integer> neighbours = gp.get(x);
            for(Integer n : neighbours){
                if(!visited.get(n)){
                    queue.add(n);
                    if(distances.get(n) > distances.get(x) + 1)
                        distances.replace(n, distances.get(x) + 1);
                }
            }
        }

        return dist;

    }
}
