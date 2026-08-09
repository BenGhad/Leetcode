class Solution:
    def weightedSum(self, parent: list[int], nums: list[int]) -> int:
        ans = 0
        n = len(parent)
        adj = defaultdict(list)

        for i in range(n):
            adj[parent[i]].append(i)



        q = deque()
        q.append(0)

        dep = [-1 for _ in range(n)]
        dep[0] = 1
 
        while q:        
            nd = q.popleft()

            for kid in adj[nd]:
                dep[kid] = dep[nd] + 1
                q.append(kid)
        h = max(dep)

        for i in range(n):
            ans += nums[i] * (h - dep[i] + 1)

        return ans
