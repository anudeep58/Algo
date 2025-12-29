package com.self.java25.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CloseIsland {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int sum =0;
        int[] visitedArray = new int[rooms.size()];
        dfs(0,visitedArray, rooms);
        for (int i = 0; i < visitedArray.length; i++) {
            sum = sum + visitedArray[i];
        }
        return sum == rooms.size();
    }

    private void dfs(int startNode ,int[] visitedArray, List<List<Integer>> rooms) {
        visitedArray[startNode] = 1;
        List<Integer> keys = rooms.get(startNode);

            for (int i = 0; i <keys.size(); i++) {
                int nextRoom = keys.get(i);
                if(visitedArray[nextRoom] != 1) {
                    dfs(nextRoom, visitedArray, rooms);
                }
            }
    }

    public static void main(String[] args) {
        CloseIsland closeIsland = new CloseIsland();
        List<List<Integer>> rooms = new ArrayList<>(Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList()  // empty list
        ));
        System.out.println(closeIsland.canVisitAllRooms(rooms));
    }

}
