package com.java.graph.topologicalSort;

import java.util.*;

// https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
// https://leetcode.com/explore/learn/card/graph/623/kahns-algorithm-for-topological-sorting/3909/
public class AlienDictionary {
    public static void main(String[] args) {
        //String[] input = {"wrt", "wrf", "er", "ett", "rftt"};
//        String[] input = {"z","x"};
//        String[] input = {"z", "x", "z"};
//        String[] input = {"z", "z"};
        String[] input = {"ab","adc"};
        AlienDictionary alienDictionary = new AlienDictionary();
        System.out.println(alienDictionary.alienOrder(input));
    }

    public String alienOrder(String[] words) {

        if (words == null || words.length == 0) return "";

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.put(c-'a', 0);
                graph.put(c-'a', new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // Check that word2 is not a prefix of word1.
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                int source = word1.charAt(j) - 'a';
                int destination = word2.charAt(j) - 'a';
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (indegree.get(destination) == null) {
                        indegree.put(destination, 1);
                    } else {
                        int degree = indegree.get(destination);
                        indegree.put(destination, degree + 1);
                    }

                    if (graph.containsKey(source)) {
                        ArrayList<Integer> list = graph.get(source);
                        if (list == null) {
                            ArrayList<Integer> newList = new ArrayList<>();
                            newList.add(destination);
                            graph.put(source, newList);
                        } else {
                            list.add(destination);
                            graph.put(source, list);
                        }
                    } else {
                        ArrayList<Integer> newList = new ArrayList<>();
                        newList.add(destination);
                        graph.put(source, newList);
                    }

                    if (!graph.containsKey(destination)) {
                        graph.put(destination, null);
                    }

                    if (!graph.containsKey(source)) {
                        graph.put(source, null);
                    }

                    if (!indegree.containsKey(source)) {
                        indegree.put(source, 0);
                    }
                    break;
                } else {
                    if (!graph.containsKey(destination)) {
                        graph.put(destination, null);
                        indegree.put(destination, 0);
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        Iterator iterator = indegree.keySet().iterator();
        while (iterator.hasNext()) {
            int node = (int) iterator.next();
            if (indegree.get(node) == 0) {
                queue.add(node);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();

            ArrayList<Integer> edges = graph.get(node);
            result.append((char) (node + 'a'));


            if (edges != null) {
                for (Integer edge : edges) {
                    indegree.put(edge, indegree.get(edge) - 1);

                    if (indegree.get(edge) == 0) {
                        queue.add(edge);
                    }
                }
            }

            count++;
        }

        //System.out.println("Count: " + count + " Graph.size(): " + graph.size());

        if (count != graph.size()) {
            return "";
        }

        return result.toString();
    }

}
