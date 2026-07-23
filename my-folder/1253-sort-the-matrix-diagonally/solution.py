class Solution:
    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:
        n = len(mat)
        m = len(mat[0])
        # horizo
        for i in range(n):
            #FUCK
            pq = []
            
            for j in range(0, n-i):
                if j >= m:
                    break
                heapq.heappush(pq, mat[i+j][j])
            
            for j in range(0, n-i):
                if j >= m:
                    break
                mat[i+j][j] = heapq.heappop(pq)
        
        #vertico
        for i in range(m):
            #FUCK
            pq = []
            
            for j in range(0, m-i):
                if j >= n:
                    break
                heapq.heappush(pq, mat[j][i+j])
            
            for j in range(0, m-i):
                if j >= n:
                    break
                mat[j][i+j] = heapq.heappop(pq)
        
        return mat        
