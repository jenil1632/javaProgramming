package com.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoGraph {

    public Map<Integer, List<Integer>> gp;

    DemoGraph(){
        this.gp = new HashMap<>();
        List<Integer> a0 = new ArrayList<>();
        a0.add(1);
        a0.add(8);
        a0.add(3);
        gp.put(0, a0);
        List<Integer> a1 = new ArrayList<>();
        a1.add(0);
        a1.add(7);
        gp.put(1, a1);
        List<Integer> a2 = new ArrayList<>();
        a2.add(7);
        a2.add(3);
        a2.add(5);
        gp.put(2, a2);
        List<Integer> a3 = new ArrayList<>();
        a3.add(0);
        a3.add(4);
        a3.add(2);
        gp.put(3, a3);
        List<Integer> a4 = new ArrayList<>();
        a4.add(3);
        a4.add(8);
        gp.put(4, a4);
        List<Integer> a5 = new ArrayList<>();
        a5.add(2);
        a5.add(6);
        gp.put(5, a5);
        List<Integer> a6 = new ArrayList<>();
        a6.add(5);
        gp.put(6, a6);
        List<Integer> a7 = new ArrayList<>();
        a7.add(2);
        a7.add(1);
        gp.put(7, a7);
        List<Integer> a8 = new ArrayList<>();
        a8.add(0);
        a8.add(4);
        gp.put(8, a8);
    }

}
