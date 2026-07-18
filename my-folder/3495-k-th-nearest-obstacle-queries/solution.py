class Solution:
    def resultsArray(self, queries: List[List[int]], k: int) -> List[int]:
        obstacles = []
        ans = []

        for q in queries:
            x = q[0]
            y = q[1]

            heapq.heappush(obstacles, -(abs(x) + abs(y)))

            while len(obstacles) > k:
                heapq.heappop(obstacles)

            if len(obstacles) < k:
                ans.append(-1)
            else:
                ans.append(abs(obstacles[0]))
        return ans
