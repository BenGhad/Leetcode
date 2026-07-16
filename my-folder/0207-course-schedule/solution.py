class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        adj = [[] for _ in range(numCourses)]
        indeg = [0 for _ in range(numCourses)]
        for a, b in prerequisites:
            adj[b].append(a)
            indeg[a] += 1
        
        vis = 0
        q = deque()
        for c in range(numCourses):
            if indeg[c] == 0:
                q.append(c)

        while q:
            c = q.popleft()
            vis += 1

            for neigh in adj[c]:
                indeg[neigh] -= 1
                if indeg[neigh] == 0:
                    q.append(neigh)

        return vis == numCourses       
        
        

