class Solution:
    def minCost(self, m: int, n: int, penalty: List[List[int]]) -> int:
        cost = 1

        """
        dp[parity][pos]
        """

        dp = [[[float('inf') for _ in range(2)] for _ in range(n)] for _ in range(m)]

        dp[0][0][0] = 1


        dirs = [
            [0, 1], [1, 0], [0,-1], [-1,0]
        ]

        pq = [(1, 0, 0, 0)]

        while pq:
            c, i, j, par = heapq.heappop(pq)

            nextpar = (par+1)%2

            for dx, dy in dirs:
                nx = i + dx
                ny = j + dy
                ni = nx
                nj = ny
                di = dx
                dj = dy

                if nx < 0 or ny < 0 or nx >=m or ny >= n:
                    continue

                moveCost = c + (ni+1)*(nj+1)

                if not ((nextpar and (di==1or dj==1)) or (not nextpar and (di==-1 or dj==-1))):
                    moveCost += penalty[i][j]

                if moveCost < dp[ni][nj][nextpar]:
                    dp[ni][nj][nextpar] = moveCost
                    heapq.heappush(pq, (moveCost, ni, nj, nextpar))


            wc = c + penalty[i][j]
            if wc < dp[i][j][nextpar]:
                dp[i][j][nextpar] = wc
                heapq.heappush(pq, (wc, i,j,nextpar))

                

        return min(dp[m-1][n-1])
