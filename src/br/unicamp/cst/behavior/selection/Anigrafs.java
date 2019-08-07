///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.unicamp.cst.behavior.selection;
//
//import br.unicamp.cst.core.entities.Codelet;
//import br.unicamp.cst.core.entities.Memory;
//import br.unicamp.cst.core.entities.MemoryObject;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author lruel
// */
//public class Anigrafs {
////    public String name;
////    public double x, y;
////    public double eval;
////    public ArrayList<MemoryObject> edges;
//
//    private static final int NO_PARENT = -1;
//
//    public Memory Condorcet(ArrayList<Memory> graph, int mode) {
//        double CodeletDistance[][] = new double[graph.size()][graph.size()];
//        if ((mode == 2) || (mode == 3)) {
//            for (int i = 0; i < graph.size(); i++) {
//                for (int j = i + 1; j < graph.size(); j++) {
//                    CodeletDistance[i][j] = (float) Math.pow(((float) Math.pow(graph.get(i).getX() - graph.get(j).getX(), 2) + (float) Math.pow(graph.get(i).getY() - graph.get(j).getY(), 2)), 1.0 / 2.0);
//                    CodeletDistance[j][i] = CodeletDistance[i][j];
//                }
//                CodeletDistance[i][i] = 0;
//            }
//        }
//        if ((mode == 1) || (mode == 2)) {
//            // Dijkstra's algorithm //////////////////////////////////////////////////////////////////////
//            int actualCodelet;
//            //   Codelet a = new Codelet();
//            int nVertices = CodeletDistance[0].length;
//            double CodeletDistance_path[][] = new double[graph.size()][graph.size()];
//            // atualiza CodeletDistance
//            for (int i = 0; i < graph.size(); i++) {
//                for (int l = 0; l < Anigrafs.get(i).edges.size(); l++) {
////                    System.out.println(graph.get(i).edges.size());
//                    for (int j = 0; j < graph.size(); j++) {
//                        if (graph.get(j).getName() == graph.get(i).edges.get(l).name) {
//                            if (mode == 1) {
//                                CodeletDistance_path[i][j] = CodeletDistance[i][j];
//                            }
//                            if (mode == 2) {
//                                CodeletDistance_path[i][j] = 1;
//                            }
//                        }
//                    }
//                }
//            }
//            if ((mode == 2) || (mode == 3)) {
//                for (int i = 0; i < graph.size(); i++) {
//                    for (int j = 0; j < graph.size(); j++) {
//                        CodeletDistance[i][j] = CodeletDistance_path[i][j];
//                    }
//                }
//            }
//            for (int o = 0; o < nVertices; o++) {
//                actualCodelet = o;
//
//                // shortestDistances[i] will hold the shortest distance from actualCodelet to i 
//                double[] shortestDistances = new double[nVertices];
//
//                // added[i] will true if vertex i is 
//                // included / in shortest edge tree 
//                // or shortest distance from src to  
//                // i is finalized 
//                boolean[] added = new boolean[nVertices];
//
//                // Initialize all distances as  
//                // INFINITE and added[] as false 
//                for (int vertexIndex = 0; vertexIndex < nVertices;
//                        vertexIndex++) {
//                    shortestDistances[vertexIndex] = Integer.MAX_VALUE;
//                    added[vertexIndex] = false;
//                }
//
//                // Distance of source vertex from 
//                // itself is always 0 
//                shortestDistances[actualCodelet] = 0;
//
//                // Parent array to store shortest 
//                // edge tree 
//                int[] parents = new int[nVertices];
//
//                // The starting vertex does not  
//                // have a parent 
//                parents[actualCodelet] = NO_PARENT;
//
//                // Find shortest edge for all  
//                // vertices 
//                for (int i = 1; i < nVertices; i++) {
//
//                    // Pick the minimum distance vertex 
//                    // from the set of vertices not yet 
//                    // processed. nearestCodelet is  
//                    // always equal to startNode in  
//                    // first iteration. 
//                    int nearestCodelet = -1;
//                    int shortestDistance = Integer.MAX_VALUE;
//                    for (int vertexIndex = 0;
//                            vertexIndex < nVertices;
//                            vertexIndex++) {
//                        if (!added[vertexIndex]
//                                && shortestDistances[vertexIndex]
//                                < shortestDistance) {
//                            nearestCodelet = vertexIndex;
//                            shortestDistance = (int) shortestDistances[vertexIndex];
//                        }
//                    }
//
//                    // Mark the picked vertex as 
//                    // processed 
//                    added[nearestCodelet] = true;
//
//                    // Update dist value of the 
//                    // adjacent vertices of the 
//                    // picked vertex. 
//                    for (int vertexIndex = 0;
//                            vertexIndex < nVertices;
//                            vertexIndex++) {
//                        double edgeDistance = CodeletDistance[nearestCodelet][vertexIndex];
//
//                        if (edgeDistance > 0
//                                && ((shortestDistance + edgeDistance)
//                                < shortestDistances[vertexIndex])) {
//                            parents[vertexIndex] = nearestCodelet;
//                            shortestDistances[vertexIndex] = shortestDistance
//                                    + edgeDistance;
//                        }
//                    }
//                }
//                for (int p = 0; p < nVertices; p++) {
//                    CodeletDistance[o][p] = shortestDistances[p];
//                }
//            }
//            ////////////////////////////////////////////////////////////////////////////////////////////////////////
//        }
//        // Condorcet de fato
//        int m_contest[] = new int[((int) Math.pow(graph.size(), 2) - graph.size()) / 2];
//        int votes[][] = new int[graph.size()][2]; // votes[0][] -> number of wins, votes[1][] -> number of total votes
//        int z = 0;
//        for (int i = 0; i < graph.size(); i++) {
//            for (int j = i + 1; j < graph.size(); j++) {
//                for (int k = 0; k < graph.size(); k++) {
//                    if (CodeletDistance[k][i] < CodeletDistance[k][j]) {
//                        m_contest[z] += graph.get(k).getEvaluation();
//                        votes[i][1] += graph.get(k).getEvaluation();
//                    }
//                    if (CodeletDistance[k][i] > CodeletDistance[k][j]) {
//                        m_contest[z] -= graph.get(k).getEvaluation();
//                        votes[j][1] += graph.get(k).getEvaluation();
//                    }
////                    if (CodeletDistance[k][i] == CodeletDistance[k][j]) {
////                        // nao faz nada
////                        m_contest[z] -= graph.get(k).getEvaluation();
////                        votes[j][1] += graph.get(k).getEvaluation();
////                    }
//                }
//                if (m_contest[z] > 0) {
//                    votes[i][0] += 1;
//                }
//                if (m_contest[z] < 0) {
//                    votes[j][0] += 1;
//                }
//                z += 1;
//            }
//        }
//        z = 0;
//        for (int i = 1; i < graph.size(); i++) {
//            if (votes[i][0] == votes[z][0]) {
//                if (votes[i][1] > votes[z][1]) {
//                    z = i;
//                }
//            }
//            if (votes[i][0] > votes[z][0]) {
//                z = i;
//            }
//        }
//        return graph.get(z);
//    }
//
//    public Anigrafs() {
//
//    }
////
////    public Codelet(String name, double x, double y, double eval) {
////        this.name = name;
////        this.x = x;
////        this.y = y;
////        this.eval = eval;
////    }
////
////    public Codelet(String name, double x, double y, double eval, ArrayList<Codelet> p) {
////        this.name = name;
////        this.x = x;
////        this.y = y;
////        this.eval = eval;
////        this.edges = p;
////    }
////
////    public String getName() {
////        return name;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
////
////    public double getX() {
////        return x;
////    }
////
////    public void setX(double x) {
////        this.x = x;
////    }
////
////    public double getY() {
////        return y;
////    }
////
////    public void setY(double y) {
////        this.y = y;
////    }
////
////    public double getEval() {
////        return eval;
////    }
////
////    public void setEval(double eval) {
////        this.eval = eval;
////    }
////
////    public ArrayList<Codelet> getEdge() {
////        return edges;
////    }
////
////    public void setEdge(ArrayList<Codelet> p) {
////      //  Codelet q[] = new Codelet[p.size()];
////        this.edges = p;
////    }
////
////    public ArrayList<String> getVEdgeNames() {
////        ArrayList<String> p = new ArrayList<>();
////        for (int i = 0; i < edges.size(); i++) {
////            p.add(edges.get(i).name);
////        }
////        return p;
////    }
//}
