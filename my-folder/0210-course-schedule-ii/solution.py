class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        adj = [[] for _ in range(numCourses)]
        indeg = [0 for _ in range(numCourses)]
        for a, b in prerequisites:
            adj[b].append(a)
            indeg[a] += 1
        
        ans = []
        q = deque()
        for c in range(numCourses):
            if indeg[c] == 0:
                q.append(c)

        while q:
            c = q.popleft()
            ans.append(c)

            for neigh in adj[c]:
                indeg[neigh] -= 1
                if indeg[neigh] == 0:
                    q.append(neigh)

        return ans if len(ans) == numCourses else []       
        
        

        
