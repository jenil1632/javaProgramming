package com.graphs;

import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        Map<Integer, List<Node>> gp = dijkstra.createGraph();
        Map<Integer, Integer> sp = dijkstra.findShortestPaths(gp, 6);
        dijkstra.display(sp);
    }

    public Map<Integer, Integer> findShortestPaths(Map<Integer, List<Node>> gp, int s){
        Map<Integer, Integer> sp = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        for (Integer k : gp.keySet()){
            sp.put(k, Integer.MAX_VALUE);
            visited.put(k, false);
        }
        sp.replace(s, 0);
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(s);
        while(!queue.isEmpty()){
            int x = queue.poll();
            visited.replace(x, true);
            List<Node> neighbours = gp.get(x);
            for(Node n : neighbours){
                if(!visited.get(n.id) && sp.get(n.id) > sp.get(x) + n.distance){
                    sp.replace(n.id, sp.get(x) + n.distance);
                    queue.add(n.id);
                }
            }
        }
        return sp;
    }


    public Map<Integer, List<Node>> createGraph(){
        Map<Integer, List<Node>> gp = new HashMap<>();
        List<Node> l0 = new ArrayList<>();
        l0.add(new Node(1, 2));
        l0.add(new Node(2, 6));
        gp.put(0, l0);
        List<Node> l1 = new ArrayList<>();
        l1.add(new Node(0, 2));
        l1.add(new Node(3, 5));
        gp.put(1, l1);
        List<Node> l2 = new ArrayList<>();
        l2.add(new Node(0, 6));
        l2.add(new Node(3, 8));
        gp.put(2, l2);
        List<Node> l3 = new ArrayList<>();
        l3.add(new Node(1, 5));
        l3.add(new Node(2, 8));
        l3.add(new Node(5, 15));
        l3.add(new Node(4, 10));
        gp.put(3, l3);
        List<Node> l4 = new ArrayList<>();
        l4.add(new Node(3, 10));
        l4.add(new Node(6, 2));
        l4.add(new Node(5, 6));
        gp.put(4, l4);
        List<Node> l5 = new ArrayList<>();
        l5.add(new Node(6, 6));
        l5.add(new Node(3, 15));
        l5.add(new Node(4, 6));
        gp.put(5, l5);
        List<Node> l6 = new ArrayList<>();
        l6.add(new Node(5, 6));
        l6.add(new Node(4, 2));
        gp.put(6, l6);
        return gp;
    }

    public void display(Map<Integer, Integer> sp){
        for(Integer k : sp.keySet())
            System.out.println(k+"\t"+sp.get(k));
    }
}

class Node implements Comparator<Node> {
    int id;
    int distance;

    Node(int id, int distance){
        this.id = id;
        this.distance = distance;
    }

    @Override
    public int compare(Node o1, Node o2) {
        return o1.distance - o2.distance ;
    }
}
