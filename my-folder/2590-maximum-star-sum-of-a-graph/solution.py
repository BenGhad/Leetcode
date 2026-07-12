class Solution:
    def maxStarSum(self, vals: List[int], edges: List[List[int]], k: int) -> int:
        adjVals = defaultdict(list)

        for u, v in edges:
            
            if vals[v] > 0:
                heapq.heappush(adjVals[u], vals[v])
                if len(adjVals[u]) > k:
                    heapq.heappop(adjVals[u])

            if vals[u] > 0:
                heapq.heappush(adjVals[v], vals[u])
                if len(adjVals[v]) > k:
                    heapq.heappop(adjVals[v])

        ans = -float('inf')

        for i, val in enumerate(vals):
            ans = max(ans,
                val + sum(adjVals[i])
            )

        return ans
