class Solution:
    dirs = (
        (1,0), (0, 1), (-1, 0), (0, -1)
    )

    def dfs(i, j, visited, grid) -> None:
        for d in Solution.dirs:
            di = i + d[0]
            dj = j + d[1]

            if 0 <= di < len(grid) and 0 <= dj < len(grid[0]) and not visited[di][dj] and grid[di][dj] == "1":
                visited[di][dj] = True
                Solution.dfs(di, dj, visited, grid)



    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        cout = 0
        visited = [[False for _ in range(n)] for _ in range(m)] 

        for  i in range(m):
            for j in range(n):
                if not visited[i][j] and grid[i][j] == "1":
                    visited[i][j] = True
                    Solution.dfs(i, j, visited, grid)
                    cout += 1
                visited[i][j] = True

        return cout
