class Solution:
    def maxArea(self, mat: List[List[int]]) -> int:
        n = len(mat)
        m = len(mat[0])

        """
        r1-r2 >= k
        c1-c2 >= k
        """

        pref = [[0] * (m+1) for _ in range(n+1)]

        for i in range(n):
            for j in range(m):
                pref[i+1][j+1] = mat[i][j] + pref[i][j+1] + pref[i+1][j] - pref[i][j]




        lo = 0
        ri = m+n
        ans = 0
        while lo <= ri:
            mid = lo+(ri-lo)//2

            minR = float('inf')
            maxR = -1
            minC = float('inf')
            maxC = -1

            for r in range(n-mid+1):
                for c in range(m-mid+1):
                    if pref[r+mid][c+mid] - pref[r][c+mid]-pref[r+mid][c] + pref[r][c] != mid * mid:
                        continue
                    minR = min(minR, r)
                    maxR = max(maxR, r)
                    minC = min(minC, c)
                    maxC = max(maxC, c)


            if maxR - minR >= mid or maxC - minC >= mid:
                ans = mid
                lo = mid + 1
            else:
                ri = mid - 1
        
        return ans * ans
