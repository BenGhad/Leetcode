class Solution:
    def nthUglyNumber(self, n: int) -> int:
        pq = []
        vis = set()
        heapq.heappush(pq, 1)
        mults = [2, 3, 5]

        while n > 1:
            ug = heapq.heappop(pq)
            n -= 1
            nxt = [ug * m for m in mults]
            for nx in nxt:
                if nx not in vis:
                    vis.add(nx)
                    heapq.heappush(pq, nx)
        
        return heapq.heappop(pq)


