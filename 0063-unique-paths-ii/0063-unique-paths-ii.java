class Solution {
    public boolean isValid(int i, int j, int[][] obstacleGrid) {
        if (i < 0 || j < 0 || i >= obstacleGrid.length || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1) {
            return false;
        }

        return true;
    }

    public int uniquePathsWithObstaclesHelper(int[][] obstacleGrid, int i, int j, int[][] memo) {
        if (!isValid(i, j, obstacleGrid))
            return 0;
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = uniquePathsWithObstaclesHelper(obstacleGrid, i, j + 1, memo) +
                uniquePathsWithObstaclesHelper(obstacleGrid, i + 1, j, memo);

        memo[i][j] = res;
        return res;

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return uniquePathsWithObstaclesHelper(obstacleGrid, 0, 0, memo);
    }
}