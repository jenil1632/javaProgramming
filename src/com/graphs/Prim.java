package com.graphs;

import java.util.*;

public class Prim {

    public static void main(String[] args) {
        Prim prim = new Prim();
        Map<Integer, List<Node>> gp = prim.createGraph();
        int costMST = prim.getCost(gp);
        System.out.println(costMST);
    }

    public int getCost(Map<Integer, List<Node>> gp){
        HashSet<Integer> mst = new HashSet<>();
        mst.add(0);
        int edges = 0;
        int cost = 0;
        while(edges < gp.keySet().size()-1){
            Node minNode = new Node(-1, Integer.MAX_VALUE);
            for(Integer n : mst){
                List<Node> neighbours = gp.get(n);
                for(Node x : neighbours){
                    if(x.distance < minNode.distance && !mst.contains(x.id)){
                        minNode = x;
                    }
                }
            }
            edges++;
            cost += minNode.distance;
            mst.add(minNode.id);
        }
        return cost;
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
}
