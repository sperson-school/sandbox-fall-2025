package org.example.sandbox.collections;

import java.util.*;

public class CollectionsDemo {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        Set<String> set1 = new LinkedHashSet<>(); // maintains insertion order
        Set<String> set2 = new TreeSet<>();


        List<String> list = new ArrayList<>();
        List<String> vector = new Vector<>();

        Queue<String> queue = new LinkedList<>();
        Deque<String> deque = new LinkedList<>();
        List<String> linkedList = new LinkedList<>();

        Queue<String> priorityQueue = new PriorityQueue<>();

        Set<String> setAlias = set;

        System.out.println(list);
        System.out.println(setAlias);
    }
}
