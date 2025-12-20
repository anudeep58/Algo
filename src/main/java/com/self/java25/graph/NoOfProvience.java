package com.self.java25.graph;

public class NoOfProvience {

    private int[] parentList;
    private int[] size;
    public NoOfProvience(int[][] isConnected){

        for (int i = 0; i < isConnected.length; i++) {
            parentList[i] = i;
            size[i] =1;

        }
    }
    public NoOfProvience(){

    }

    public int getParent(int x) {
        if (parentList[x] != x) {
            parentList[x] = getParent(parentList[x]);
        }
        return parentList[x];
    }

    public int getSize(int x) {
        return size[x];
    }
   public void unionBySize(int x, int y){
        int xp = getParent(x);
        int yp = getParent(y);
        if(xp != yp) {
            if (getSize(x) > getSize(y)) {
                parentList[y] = parentList[x];
                size[x] = getSize(x) + getSize(y);
            } else {
                parentList[x] = parentList[y];
                size[y] = getSize(y) + getSize(x);
            }
        }
   }

    public boolean isConnected(int x, int y){
        int xp = getParent(x);
        int yp = getParent(y);
        if(xp != yp) return false;
        return true;
    }

    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        int count =0;
        parentList=new int[n+1];//1 to n nodes
        size=new int[n+1];
        for (int i = 0; i < isConnected.length; i++) {
            parentList[i] = i;
            size[i] =1;

        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i+1; j < n ; j++) {
                if(i!=j && isConnected[i][j] == 1){
                    unionBySize(i+1, j+1);
                }
            }
        }
        for(int i=1;i<n+1;i++){
            if(parentList[i]==i)count++;
        }
        return count;
    }

}


