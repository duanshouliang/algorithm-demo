package com.dsl.algorithms.shortest.path.dp;


import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用动态规划找到最短路径
 */
public class DynamicProgramming {
    static String[] vertexs = new String[]{"A", "B1", "B2", "C1", "C2", "C3", "C4", "D1", "D2", "D3", "E1", "E2", "E3", "F1", "F2", "G"};
    static int max = Integer.MAX_VALUE;

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {0, 5, 3, max, max, max, max, max, max, max, max, max, max, max, max, max},
                {max, 0, max, 1, 3, 6, max, max, max, max, max, max, max, max, max, max},
                {max, max, 0, max, 8, 7, 6, max, max, max, max, max, max, max, max, max},
                {max, max, max, 0, max, max, max, 6, 8, max, max, max, max, max, max, max},
                {max, max, max, max, 0, max, max, 3, 5, max, max, max, max, max, max, max},
                {max, max, max, max, max, 0, max, max, 3, 3, max, max, max, max, max, max},
                {max, max, max, max, max, max, 0, max, 8, 4, max, max, max, max, max, max},
                {max, max, max, max, max, max, max, 0, max, max, 2, 2, max, max, max, max},
                {max, max, max, max, max, max, max, max, 0, max, max, 1, 2, max, max, max},
                {max, max, max, max, max, max, max, max, max, 0, max, 3, 3, max, max, max},
                {max, max, max, max, max, max, max, max, max, max, 0, max, max, 3, 5, max},
                {max, max, max, max, max, max, max, max, max, max, max, 0, max, 5, 2, max},
                {max, max, max, max, max, max, max, max, max, max, max, max, 0, 6, 6, max},
                {max, max, max, max, max, max, max, max, max, max, max, max, max, 0, max, 4},
                {max, max, max, max, max, max, max, max, max, max, max, max, max, max, 0, 3},
                {max, max, max, max, max, max, max, max, max, max, max, max, max, max, max, 0}
        };
        Map<String, List<Vertex>> vertexs = getVertex(matrix);
        System.out.println(JSONObject.toJSONString(vertexs));

    }

    private static String[] getShortestPath(String start, String end, List<Edge> edges) {

        return null;
    }


    private static Map<String, List<Vertex>> getVertex(int[][] matrix) {
        Map<String, List<Vertex>> map = new HashMap<>();
        for (int i = matrix.length-1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                String endVertex = vertexs[i];
                String startVertex = vertexs[j];
                int weight = matrix[j][i];
                if (weight != max) {
                    if (map.containsKey(endVertex)) {
                        map.get(endVertex).add(new Vertex(startVertex, weight));
                    } else {
                        List<Vertex> startVertices = new ArrayList<>();
                        startVertices.add(new Vertex(startVertex, weight));
                        map.put(endVertex, startVertices);
                    }
                }
            }
        }
        return map;
    }

    private static List<Edge> getEdges(int[][] matrix) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                String startChar = vertexs[i];
                String endChar = vertexs[j];
                int weight = matrix[i][j];
                if (weight != max) {
                    Edge edge = new Edge(i, j, startChar, endChar, matrix[i][j]);
                    edges.add(edge);
                }
            }
        }
        return edges;
    }
}
