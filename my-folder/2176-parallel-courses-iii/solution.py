class Solution:
    def minimumTime(self, n: int, relations: List[List[int]], time: List[int]) -> int:
        adj = [[] for _ in range(n)]
        par = [[] for _ in range(n)]

        for rel in relations:
            u = rel[0] - 1
            v = rel[1] - 1

            adj[u].append(v)
            par[v].append(u)
        
        # topo kahn
        indeg = [len(par[v]) for v in range(n)]

        courses = []
        
        queue = deque(c for c in range(n) if indeg[c] == 0)

        while queue:
            course = queue.popleft()
            courses.append(course)

            for nxt in adj[course]:
                indeg[nxt] -= 1
                if indeg[nxt] == 0:
                    queue.append(nxt)
        

        """
        dp[i] = earliest time you can finish class i
        """
        dp = {}
        
        ans = -1

        for course in courses:
            dp[course] = time[course]
            if par[course]:
                dp[course] += max(dp[p] for p in par[course])
            
            ans = max(ans, dp[course])
        
        return ans
            
        

