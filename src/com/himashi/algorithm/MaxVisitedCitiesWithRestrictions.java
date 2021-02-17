package com.himashi.algorithm;

import java.util.*;

public class MaxVisitedCitiesWithRestrictions {
    private static int maxCitiesVisited = 0;
    public static int solution(int[] T) {
        if (T == null) return 0;
        // if number of cities equals to one return 1
        if (T.length == 1) return 1;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        generateGraph(T, graph);

        int startingCity = 0; // this is always zero as John lives in city zero
        Set<Integer> visitedCities = new HashSet<>(); // collection of visited cities
        visitedCities.add(startingCity);
        List<Integer> path = new ArrayList<>();
        path.add(startingCity);
        checkMaximumVisitedCities(graph, startingCity, 0, visitedCities, path);

        return maxCitiesVisited;
    }

    /**
     * Use to generate graph when nodes are given as list of int array
     * @param t
     * @param graph
     */
    private static void generateGraph(int[] t, Map<Integer, List<Integer>> graph) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] != i) {
                if (graph.containsKey(i))
                    graph.get(i).add(t[i]);
                else {
                    final ArrayList<Integer> list = new ArrayList<>();
                    list.add(t[i]);
                    graph.put(i, list);
                }

                if (graph.containsKey(t[i]))
                    graph.get(t[i]).add((i));
                else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    graph.put(t[i], list);
                }
            }
        }
    }

    // Depth First Search with back tracking to visit cities
    private static void checkMaximumVisitedCities(Map<Integer, List<Integer>> graph, int currentCity, int oddNumberCount, Set<Integer> visitedCities,  List<Integer> path){
        if (visitedCities.size() > maxCitiesVisited) {
            maxCitiesVisited = visitedCities.size();
        }
        for (int nextCity : graph.get(currentCity)) {
            // if John already visited the next city before or john is going to visit odd numbered city and he has visited
            // already visited the odd numbered city previously, then continue to next available city
            if(oddNumberCount ==1 && nextCity %2 != 0 || visitedCities.contains(nextCity))
                continue;
//            path.add(nextCity);
            visitedCities.add(nextCity);
            checkMaximumVisitedCities(graph, nextCity, oddNumberCount+ nextCity %2 ==0 ? 0: 1, visitedCities, path);
//            path.remove(path.size()-1);
            visitedCities.remove(nextCity);
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 9, 0, 2, 6, 8, 0, 8, 3, 0};
        System.out.println(solution(array));
    }
}


