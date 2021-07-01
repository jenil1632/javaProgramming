package com.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {

    public static void main(String[] args) {
        BellmanFord bellmanFord = new BellmanFord();
        Map<Integer, List<Node>> gp = bellmanFord.createGraph();

        Map<Integer, Integer> sp = bellmanFord.getShortestDistance(gp, 0);
        bellmanFord.display(sp);
    }

    public Map<Integer, Integer> getShortestDistance(Map<Integer, List<Node>> gp, int s){
        Map<Integer, Integer> sp = new HashMap<>();
        for(Integer k : gp.keySet())
            sp.put(k, Integer.MAX_VALUE);
        sp.replace(s, 0);
        for(int i=0; i<=gp.keySet().size()-1; i++){
            int change = 0;
            for(Integer k : gp.keySet()){
                if(sp.get(k) == Integer.MAX_VALUE)
                    continue;
                List<Node> neighbours = gp.get(k);
                for(Node n : neighbours){
                    if(sp.get(n.id) > n.distance + sp.get(k)){
                        sp.replace(n.id, sp.get(k) + n.distance);
                        change++;
                    }
                }
            }
            if(change == 0)
                break;
        }
        return sp;
    }

    public Map<Integer, List<Node>> createGraph(){
        Map<Integer, List<Node>> gp = new HashMap<>();
        List<Node> l0 = new ArrayList<>();
        l0.add(new Node(1, -1));
        l0.add(new Node(2, 4));
        gp.put(0, l0);
        List<Node> l1 = new ArrayList<>();
        l1.add(new Node(2, 3));
        l1.add(new Node(3, 2));
        l1.add(new Node(4, 2));
        gp.put(1, l1);
        List<Node> l2 = new ArrayList<>();
        gp.put(2, l2);
        List<Node> l3 = new ArrayList<>();
        l3.add(new Node(1, 1));
        l3.add(new Node(2, 5));
        gp.put(3, l3);
        List<Node> l4 = new ArrayList<>();
        l4.add(new Node(3, -3));
        gp.put(4, l4);
        return gp;
    }

    public void display(Map<Integer, Integer> sp){
        for(Integer k : sp.keySet())
            System.out.println(k+"\t"+sp.get(k));
    }
}
