package com.leetcode;

import java.util.*;

public class EvaludateDivision {

    public static void main(String[] args) {
       /* List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));*/

      /*  List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        equations.add(Arrays.asList("bc", "cd"));

        double[] values = {1.5, 2.5, 5.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("c", "b"));
        queries.add(Arrays.asList("bc", "cd"));
        queries.add(Arrays.asList("cd", "bc"));*/

        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("x1", "x2"));
        equations.add(Arrays.asList("x2", "x3"));
        equations.add(Arrays.asList("x1", "x4"));
        equations.add(Arrays.asList("x2", "x5"));

        double[] values = {3.0, 0.5, 3.4, 5.6};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("x2", "x4"));

        //[["x1","x2"],["x2","x3"],["x1","x4"],["x2","x5"]]

        double[] data = new EvaludateDivision().calcEquation(equations, values, queries);
        System.out.println(data);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] output = new double[queries.size()];

        Map<String, Map<String, Double>> map = new HashMap<>();
        int count = 0;
        int outcount = 0;
        for (List<String> equation : equations) {

            double value = values[count++];

            String first = equation.get(0);
            String second = equation.get(1);

            if (map.get(first) == null) {
                Map<String, Double> firstMap = new HashMap<>();
                firstMap.put(second, value);
                map.put(first, firstMap);
            } else {
                Map<String, Double> firstMap = map.get(first);
                firstMap.put(second, value);
                map.put(first, firstMap);
            }
            if (map.get(second) == null) {
                value = 1 / value;
                Map<String, Double> firstMap = new HashMap<>();
                firstMap.put(first, value);
                map.put(second, firstMap);
            } else {
                value = 1 / value;
                Map<String, Double> firstMap = map.get(second);
                firstMap.put(first, value);
                map.put(second, firstMap);
            }
        }

        for (List<String> query : queries) {
            String first = query.get(0);
            String second = query.get(1);

            if (map.get(first) == null || map.get(second) == null) {
                output[outcount++] = -1.0;
                continue;
            }
            if (first.equals(second)) {
                output[outcount++] = 1.0;
                continue;
            }
            List<String> visitedList = new ArrayList<>();
            boolean[] returnFlag = new boolean[1];
            double result = getResult(first, second, map, visitedList, returnFlag);
            if (!visitedList.contains(first) || !visitedList.contains(second)) {
                output[outcount++] = -1.0;
                continue;
            }
            output[outcount++] = result;
        }
        return output;
    }

    public double getResult(String first, String second, Map<String, Map<String, Double>> map, List<String> visited, boolean[] returnFlag) {

        double prod = 1.0;
        Map<String, Double> mapData = map.get(first);
        visited.add(first);
        if (returnFlag[0]) {
            return prod;
        }

        for (Map.Entry<String, Double> data : mapData.entrySet()) {
            if (!visited.contains(data.getKey())) {
                String key = data.getKey();
                Double val = data.getValue();
                prod = getResult(key, second, map, visited, returnFlag);
                prod = prod * val;
                if (returnFlag[0]) {
                    return prod;
                }
                if (key.equals(second)) {
                    visited.add(second);
                    returnFlag[0] = true;
                    return prod;
                }
            }
        }
        return prod;
    }
}


//[["x1","x2"],["x2","x3"],["x3","x4"],["x4","x5"]]
//      [3.0,4.0,5.0,6.0]
//     [["x1","x5"],["x5","x2"],["x2","x4"],["x2","x2"],["x2","x9"],["x9","x9"]]


//[["x1","x2"],["x2","x3"],["x1","x4"],["x2","x5"]]
//     [3.0,0.5,3.4,5.6]
//     [["x2","x4"],["x1","x5"],["x1","x3"],["x5","x5"],["x5","x1"],["x3","x4"],["x4","x3"],["x6","x6"],["x0","x0"]]
