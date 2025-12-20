package com.self.java25.graph;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {
        public int countComponents(int n, int[][] edges) {
            List<List<Integer>> adj = new ArrayList<>();
            boolean[] visit = new boolean[n];
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }
            System.out.println(adj);
            int res = 0;
            for (int node = 0; node < n; node++) {
                if (!visit[node]) {
                    dfs(adj, visit, node);
                    res++;
                }
            }
            return res;
        }

        private void dfs(List<List<Integer>> adj, boolean[] visit, int node) {
            visit[node] = true;
            for (int nei : adj.get(node)) {
                if (!visit[nei]) {
                    dfs(adj, visit, nei);
                }
            }
    }

    public static void main(String[] args) {
        System.out.println(new ConnectedComponents().countComponents(4,new int[][] {
                {1, 2},
                {0, 1},
                {3, 3
                }
        }));
    }
}
