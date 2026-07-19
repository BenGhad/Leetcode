class Solution:
    def frogPosition(self, n: int, edges: List[List[int]], t: int, target: int) -> float:
        """
        dp[node][t] = probability of being here at time T

        for node N
        dp[neighbour][t+1] += dp[node][t] * probability of that FUCK OFF
        if no children then it's just stop the thing here
        oh it's a tree thank FUCK
        """
        
        adj = [[] for _ in range(n)]
        par = [-1] * n
        for a, b in edges:
            a -=  1
            b -= 1
            adj[a].append(b)
            adj[b].append(a)
        
        q = deque()
        q.append(0)

        while q:
            node = q.popleft()
            for neigh in adj[node]:
                if neigh == par[node]:
                    continue
                par[neigh] = node
                q.append(neigh)
            
        
        prob = 1.0
        target -= 1
        node = target
        counter = 0
        while node != 0:
            dad = par[node]

            prob /= len(adj[dad]) - (dad != 0)

            node = dad
            counter += 1

        if counter > t:
            return 0.0

        
        target_children = len(adj[target]) - (target != 0)
        if counter < t and target_children > 0:
            return 0.0
        
        return prob
