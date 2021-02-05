package com.himashi.algorithm;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1){
                    count += 1;
                    depthFirstSearch(grid,i, j);
                }
            }
        }

        return count;
    }

    private static void depthFirstSearch(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0)
            return;

        grid[i][j] = 0;
        depthFirstSearch(grid, i - 1, j ); //left
        depthFirstSearch(grid, i + 1, j ); //right
        depthFirstSearch(grid, i, j - 1 ); //up
        depthFirstSearch(grid, i, j + 1 ); //left


    }

    public static void main(String[] args) {
        char [][] grid1 = {{1,1,1,1,0}, {1,1,0,1,0}, {1,1,0,0,0}, {0,0,0,0,0}};
        char [][] grid2 = {{1,1,0,0,0}, {1,1,0,0,0}, {0,0,1,0,0}, {0,0,0,1,1}};
        System.out.println(numIslands(grid1));
        System.out.println(numIslands(grid2));
    }
}
