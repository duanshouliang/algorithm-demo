package com.dsl.algorithms.shortest.path.dp;

public class Edge {
    private int start;
    private int end;
    private String startVertex;
    private String endVertex;
    private int weight;

    public Edge(int start, int end, String startVertex, String endVertex, int weight) {
        this.start = start;
        this.end = end;
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(String startVertex) {
        this.startVertex = startVertex;
    }

    public String getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(String endVertex) {
        this.endVertex = endVertex;
    }
}
