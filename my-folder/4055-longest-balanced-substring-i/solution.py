class Solution(object):
    def longestBalanced(self, s):
        n = len(s)
        dp = [[0 for _ in range(26)] for _ in range(n + 1)]

        for i in range(1, n+1):
            dp[i] = dp[i-1][:]
            dp[i][ord(s[i-1]) - ord('a')] += 1

        ans = 1
        for l in range(n):
            for r in range(l, n):
                prev = -1
                good = True
                for c in range(26):
                    cnt = dp[r+1][c] - dp[l][c]
                    if cnt == 0: continue
                    if prev == -1:
                        prev = cnt
                    
                    if cnt != prev:
                        good = False
                        break
                if good:
                    ans = max(ans, r - l + 1)

        return ans

