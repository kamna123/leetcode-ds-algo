import "fmt"

func isVisited(visited [][]bool, i, j int) bool {
	if i < 0 || j < 0 || i >= len(visited) || j >= len(visited[0]) || visited[i][j] {
		return true
	}
	return false
}

func numIslandsHelper(grid [][]byte, visited [][]bool, i, j int) {
	if isVisited(visited, i, j) {
		return
	}
	if grid[i][j] == '1' {
		visited[i][j] = true
		numIslandsHelper(grid, visited, i+1, j)
		numIslandsHelper(grid, visited, i, j+1)
		numIslandsHelper(grid, visited, i-1, j)
		numIslandsHelper(grid, visited, i, j-1)
		//visited[i][j] = false
	}
}

func numIslands(grid [][]byte) int {
	visited := make([][]bool, len(grid))
	for i := 0; i < len(visited); i++ {
		visited[i] = make([]bool, len(grid[i]))
	}
	res := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			if !visited[i][j] && grid[i][j] == '1' {
				res++
				numIslandsHelper(grid, visited, i, j)
			}
		}
	}
	return res
}
