package com.self.java25.graph;

import java.util.*;

class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new ArrayDeque<>();  // Queue for BFS (stores [row, col])

        // Step 1: Add all land cells (value 1) to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        // Edge cases: no land or entire grid is land → no water cell exists
        if (q.isEmpty() || q.size() == n * n) {
            return -1;
        }

        int distance = -1;  // Will become 0 after first level, 1 after second, etc.

        // Step 2: Multi-source BFS from all land cells
        while (!q.isEmpty()) {
            int size = q.size();  // Number of cells at current distance level

            // Process all cells at the current distance
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int x = cell[0];  // current row
                int y = cell[1];  // current column

                // Explore UP: (x-1, y)
                if (x - 1 >= 0 && grid[x - 1][y] == 0) {
                    grid[x - 1][y] = 1;           // mark as visited
                    q.offer(new int[]{x - 1, y}); // add to next level
                }

                // Explore DOWN: (x+1, y)
                if (x + 1 < n && grid[x + 1][y] == 0) {
                    grid[x + 1][y] = 1;
                    q.offer(new int[]{x + 1, y});
                }

                // Explore LEFT: (x, y-1)
                if (y - 1 >= 0 && grid[x][y - 1] == 0) {
                    grid[x][y - 1] = 1;
                    q.offer(new int[]{x, y - 1});
                }

                // Explore RIGHT: (x, y+1)
                if (y + 1 < n && grid[x][y + 1] == 0) {
                    grid[x][y + 1] = 1;
                    q.offer(new int[]{x, y + 1});
                }
            }

            distance++;  // All cells processed in this level → move to next distance
        }

        return distance;  // Maximum Manhattan distance from any land
    }

    public int[][] updateMatrix(int[][] mat) {
        int length = mat.length;
        int height = mat[0].length;

        int[][] dist = new int[length][height];

        Queue<int[]> nodesToIterate =  new ArrayDeque();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {

                if (mat[length][height] == 0){
                    dist[length][height] = 0;
                    nodesToIterate.offer(new int[]{length, height});
                }
                else {
                    dist[length][height] = -1;
                }

            }

            while (!nodesToIterate.isEmpty()){
                for (int j = 0; j < nodesToIterate.size(); j++) {

                   int[] cell = nodesToIterate.poll();
                   int x = cell[0];
                   int y = cell[1];

                   if(x-1 > 0 || dist[x-1][y] == -1){
                       dist[x - 1][y] = dist[x][y] + 1;
                       nodesToIterate.offer(new int[]{x-1, y});
                   }

                    if(x+1 < length || dist[x+1][y] == -1){
                        dist[x + 1][y] = dist[x][y] + 1;
                        nodesToIterate.offer(new int[]{x+1, y});
                    }

                    if(y > 0 || dist[x][y-1] == -1){
                        dist[x][y-1] = dist[x][y] + 1;
                        nodesToIterate.offer(new int[]{x, y-1});
                    }

                    if(y+1 > height || dist[x][y+1] == -1){
                        dist[x][y+1] = dist[x][y] + 1;
                        nodesToIterate.offer(new int[]{x, y+1});
                    }


                }
            }

        }
       return dist;
        }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] d : dislikes) {
            graph[d[0]].add(d[1]);
            graph[d[1]].add(d[0]);
        }
        // 0 = uncolored, 1 = color A, -1 = color B
        int[] color = new int[n + 1];

        for (int i = 0; i < graph.length; i++) {
            Queue<Integer> queue =  new LinkedList<>();
            queue.offer(graph[i].get(0));
            color[graph[i].get(0)] = 1;
            while (!queue.isEmpty()){
                int current = queue.poll();
                for (int neighbor: graph[current]) {
                    if (color[neighbor] == 0) {
                        color[neighbor] = -color[current];
                        queue.offer(neighbor);
                    } else if (color[neighbor] == color[current]) {
                        return false; // conflict
                    }
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] visitedColour = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (visitedColour[i] != 0) continue;
            queue.offer(i);
            visitedColour[i] = 1;
            while (!queue.isEmpty()){
                int currElement = queue.poll();
                for (int neighbor: graph[currElement]) {
                    if(visitedColour[neighbor]==0){
                        visitedColour[neighbor] =  -visitedColour[currElement];;
                        queue.offer(neighbor);
                    }else if(visitedColour[neighbor] == visitedColour[currElement]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
       List<List<Integer>> graph = new ArrayList<>();
        // Initialize graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] node:
             prerequisites) {
            graph.get(node[1]).add(node[0]);
        }

        int[] visitedArray = new int[numCourses]; //0,1,2

        for (int i = 0; i < numCourses; i++) {
            if(visitedArray[i] == 0){
                if(hadCycle(i, visitedArray, graph)){
                    return false;
                }
            }
        }
        return true;

    }

    private boolean hadCycle(int sourceNode, int[] visitedArray, List<List<Integer>> graph) {

        if (visitedArray[sourceNode] == 1) return true;
        if (visitedArray[sourceNode] == 2) return false;

        visitedArray[sourceNode] = 1;
        for (int neighbour: graph.get(sourceNode)
             ) {
            if (hadCycle(neighbour, visitedArray, graph)) {
                return true; // 🔴 propagate cycle detection
            }
        }

        visitedArray[sourceNode] = 2;
        return false;
    }

}