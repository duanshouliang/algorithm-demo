package com.dsl.algorithms.shortest.path.dijkstra;

public class Graph {
    private char vertexs[];
    private int vertexNum;
    private int edgeNum;
    private int matrix[][];

    public char[] getVertexs() {
        return vertexs;
    }

    public void setVertexs(char[] vertexs) {
        this.vertexs = vertexs;
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public void setVertexNum(int vertexNum) {
        this.vertexNum = vertexNum;
    }

    public int getEdgeNum() {
        return edgeNum;
    }

    public void setEdgeNum(int edgeNum) {
        this.edgeNum = edgeNum;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
