package com.self.java25.graph;

import java.util.*;

public class SurroundingRegion {
    int length;
    int breadth;
    public void solve(char[][] board) {
         length = board.length;
         breadth = board[0].length;

        for (int i = 0; i < length; i++) {
            dfs(board, i, 0);
            dfs(board, i, breadth-1);
        }
        for (int j=0; j < breadth; j++){
            dfs(board, 0, j);
            dfs(board, length-1, j);
        }
        for (int i = 0; i < length; i++) {
            for (int j=0; j < breadth; j++){
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
      if(i < 0 || j < 0 || board[i][j] != 'O' || i >= length || j >= breadth)
          return;
      board[i][j] = 'T';
      dfs(board,i, j-1);
      dfs(board,i, j+1);
      dfs(board, i-1, j);
      dfs(board, i+1, j);

    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(!adjList.containsKey(manager[i])){
                adjList.put(manager[i], new ArrayList<>());
            }
            adjList.get(manager[i]).add(i);
        }
        return dfs1(adjList, headID, informTime);
    }

    public int dfs1(Map<Integer, List<Integer>> adjList,int headID, int[] informTime){
        int currentMax = 0;
        if(!adjList.containsKey(headID)){
            return currentMax;
        }
        for (int subordinate : adjList.get(headID)){
            currentMax = Math.max(currentMax, dfs1( adjList, subordinate, informTime));

        }
        return currentMax + informTime[headID];
    }

}
