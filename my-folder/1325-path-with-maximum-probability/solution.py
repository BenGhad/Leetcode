class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], src: int, dst: int) -> float:
        adj = [[] for _ in range(n)]

        for i in range(len(edges)):
            a, b = edges[i]
            w = succProb[i]
            adj[a].append((b, w))
            adj[b].append((a, w))
        
        pq = []
        prob = [0.0] * n

        prob[src] = 1.0
        heapq.heappush(pq, (-1.0, src))


        while pq:
            p, node = heapq.heappop(pq)
            p = -p # actual prob

            if p < prob[node]:
                continue

            for neigh, w in adj[node]:
                if (p * w) > prob[neigh]:
                    prob[neigh] = p * w
                    heapq.heappush(pq, (-prob[neigh], neigh))
        return prob[dst]
