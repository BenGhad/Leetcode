class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        n = len(grid)
        m = len(grid[0])
        lst = [num for row in grid for num in row]
        num_elem = len(lst)
        k %= num_elem

        unpack = lst[-k:] + lst[:-k]
        unpack.reverse()
        
        ans = []
        for i in range(n):
            ans.append([])
            for j in range(m):
                ans[-1].append(unpack.pop())
        return ans
