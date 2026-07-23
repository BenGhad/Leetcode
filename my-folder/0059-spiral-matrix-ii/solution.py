class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        ans = [[-1 for _ in range(n)] for _ in range(n)]
        
        dirs = [
            [0, 1],
            [1, 0],
            [0, -1],
            [-1, 0]
        ]
        d = 0 
        
        cout = 1
        x, y = (0, 0)
        
        for i in range(n * n):
            ans[x][y] = cout
            cout += 1
            
            dx, dy = dirs[d]
            if x + dx >= n or y + dy >= n or ans[x+dx][y+dy] != -1:
                d = (d + 1) % 4
                dx, dy = dirs[d]
            x += dx
            y += dy
        
        return ans
        
        
