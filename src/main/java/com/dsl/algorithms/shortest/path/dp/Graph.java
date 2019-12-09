package com.dsl.algorithms.shortest.path.dp;

import java.util.List;

public class Graph {
    private String vertexs[];
    private int vertexNum;
    protected List<Edge> edges;


    public String[] getVertexs() {
        return vertexs;
    }

    public void setVertexs(String[] vertexs) {
        this.vertexs = vertexs;
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public void setVertexNum(int vertexNum) {
        this.vertexNum = vertexNum;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}
