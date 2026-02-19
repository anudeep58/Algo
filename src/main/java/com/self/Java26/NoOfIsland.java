package com.self.Java26;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIsland {
    public int numIslands(char[][] grid) {
        int numOfIsland = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    numOfIsland++;
                }
            }
        }
        return numOfIsland;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i-1,j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);

    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue =  new LinkedList<>();
        int[][] visited = grid;
        int goodOranges = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
                if (grid[i][j] == 1){
                    goodOranges++;
                }
            }
        }
        if(goodOranges == 0){
            return 0;
        }
        int count = 0;

        while (!queue.isEmpty()){
            int size =  queue.size();
            boolean organgeRotten = false;
            for (int i = 0; i < size; i++) {
                int[] ele = queue.poll();
                int x = ele[0];
                int y = ele[1];
                //left
                if(x-1 >= 0  && visited[x-1][y] == 1){
                    visited[x-1][y] = 2;
                    queue.offer(new int[]{x-1, y});
                    organgeRotten = true;
                    goodOranges--;
                }
                //right
                if(x+1 < m  && visited[x+1][y] == 1){
                    queue.offer(new int[]{x+1, y});
                    visited[x+1][y] = 2;
                    organgeRotten = true;
                    goodOranges--;
                }
                //up
                if(y+1 < n  && visited[x][y+1] == 1){
                    queue.offer(new int[]{x, y+1});
                    visited[x][y+1] = 2;
                    organgeRotten = true;
                    goodOranges--;
                }

                //down
                //up
                if(y-1 >= 0  && visited[x][y-1] == 1){
                    queue.offer(new int[]{x, y-1});
                    visited[x][y-1] = 2;
                    organgeRotten = true;
                    goodOranges--;
                }


            }
            if(organgeRotten){
                count++;
            }
        }
        return goodOranges == 0 ? count : -1;
    }

    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        int columns = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(rooms[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] element = queue.poll();
                int row = element[0];
                int column = element[1];

                //left
                if(column - 1 >=0 && row < rows && rooms[row][column-1] == Integer.MAX_VALUE){
                    rooms[row][column-1] = rooms[row][column] + 1;
                    queue.offer(new int[]{row, column-1});
                }

                //right
                if(column + 1 <columns  && rooms[row][column+1] == Integer.MAX_VALUE){
                    rooms[row][column+1] = rooms[row][column] + 1;
                    queue.offer(new int[]{row, column+1});
                }

                //up
                if(row + 1 < rows && rooms[row+1][column] == Integer.MAX_VALUE){
                    rooms[row+1][column] = rooms[row][column] + 1;
                    queue.offer(new int[]{row+1, column});
                }

                //down
                if( row -1 >= 0 && rooms[row-1][column] == Integer.MAX_VALUE){
                    rooms[row-1][column] = rooms[row][column] + 1;
                    queue.offer(new int[]{row-1, column});
                }

            }
        }

        return;

    }

}
