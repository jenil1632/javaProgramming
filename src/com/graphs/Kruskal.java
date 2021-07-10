package com.graphs;

import java.util.*;

public class Kruskal {

    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal();
        List<Edge> gp = kruskal.createGraph();
        int cost = kruskal.getMSTCost(gp, 7);
        System.out.println(cost);
    }

    public Queue<Edge> getMinheap(List<Edge> gp) {
        Queue<Edge> minHeap = new PriorityQueue<>();
        for(Edge n : gp){
            minHeap.add(n);
        }
        return minHeap;
    }

    public int getMSTCost(List<Edge> gp, int vertices){
        int cost = 0;
        Queue<Edge> minHeap = getMinheap(gp);
        int[] arr = new int[vertices];
        for(int i=0; i<arr.length; i++)
            arr[i] = -1;
        int edges = 0;
        while(edges < vertices-1){
            Edge e = minHeap.poll();
            int x = getRoot(e.from, arr);
            int y = getRoot(e.to, arr);
            if(x == y && x!=-1 && y!= -1){
                continue;
            } else{
                cost += e.distance;
                edges++;
                if(arr[x] <= arr[y]){
                    arr[x] += arr[y];
                    arr[y] = x;
                } else{
                    arr[y] += arr[x];
                    arr[x] = y;
                }
            }
        }
        return cost;
    }

    public int getRoot(int x, int[] arr){
        if(arr[x] <= -1)
            return x;
        else
            return getRoot(arr[x], arr);
    }

    public List<Edge> createGraph(){
        List<Edge> gp = new ArrayList<>();
        gp.add(new Edge(0, 1, 2));
        gp.add(new Edge(0, 2, 6));
        gp.add(new Edge(1, 3, 5));
        gp.add(new Edge(2, 3, 8));
        gp.add(new Edge(3, 5, 15));
        gp.add(new Edge(3, 4, 10));
        gp.add(new Edge(4, 5, 6));
        gp.add(new Edge(4, 6, 2));
        gp.add(new Edge(5, 6, 6));
        return gp;
    }
}

class Edge implements Comparable<Edge> {
    int from;
    int to;
    int distance;

    Edge(int from, int to, int distance){
        this.from = from;
        this.distance = distance;
        this.to = to;
    }

    @Override
    public int compareTo(Edge o) {
        return this.distance - o.distance;
    }
}

