package com.dsl.algorithms.shortest.path.dijkstra;


/**
 * 迪杰斯特拉(Dijkstra)算法是典型最短路径算法，用于计算一个节点到其他节点的最短路径
 * 它的主要特点是以起始点为中心向外层层扩展(广度优先搜索思想)，直到扩展到终点为止。
 * <p>
 * 原理：
 */
public class Dijkstra {


    public static void dijkstra(Graph graph, int vs, int prev[], int dist[]) {
        int i = 0, j = 0, k = 0;
        int min;
        int tmp;
        int flag[] = new int[7];

        for (i = 0; i < graph.getVertexNum(); i++) {
            flag[i] = 0;
            prev[i] = 0;
            dist[i] = graph.getMatrix()[vs][i];
        }
        flag[vs] = 1;
        dist[vs] = 0;

        for (i = 1; i < graph.getVertexNum(); i++) {
            min = Integer.MAX_VALUE;
            for (j = 0; j < graph.getVertexNum(); j++) {
                if (flag[j] == 0 && dist[j] < min) {
                    min = dist[j];
                    k = j;
                }
            }
            flag[k] = 1;

            for (j = 0; j < graph.getVertexNum(); j++) {
                tmp = graph.getMatrix()[k][j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : (min + graph.getMatrix()[k][j]);
                if (flag[j] == 0 && tmp < dist[j]) {
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }

    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.setEdgeNum(12);
        graph.setVertexNum(7);
        graph.setVertexs(new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'});
        int max = Integer.MAX_VALUE;
        int matrix[][] = new int[][]{

                {0, 12, max, max, max, 16, 14},
                {12, 0, 10, max, max, 7, max},
                {max, 10, 0, 3, 5, 6, max},
                {max, max, 3, 0, 4, max, max},
                {max, max, 5, 4, 0, 2, 8},
                {16, 7, 6, max, 2, 0, 9},
                {14, max, max, max, 8, 9, 0}};
        graph.setMatrix(matrix);
        int[] prev = new int[7];
        int dist[] = new int[7];

        dijkstra(graph, 3, prev, dist);
        for (int i = 0; i < graph.getVertexNum(); i++) {
            System.out.println(graph.getVertexs()[3] + " " + graph.getVertexs()[i] + " " + dist[i]);
        }
    }
}
