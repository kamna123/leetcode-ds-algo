class Solution {
    
    public boolean isValid(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return false;
        return true;
    }
    public int dfs(int i, int j, int[][] grid, int[][] visited) {
        if (isValid(i, j, grid) && visited[i][j] == 0) {
            visited[i][j] = 1;
            return 1 + dfs(i + 1, j, grid, visited) + dfs(i - 1, j, grid, visited) +
                dfs(i, j + 1, grid, visited) + dfs(i, j - 1, grid, visited);

        }
        return 0;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] == 0) {
                    area = Math.max(area,dfs(i, j, grid, visited));
                    
                }
            }
        }
        return area;
    }
}