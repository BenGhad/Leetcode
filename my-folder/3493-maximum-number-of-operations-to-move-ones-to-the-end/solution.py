class Solution:
    def maxOperations(self, s: str) -> int:
        # gaps = 0
        # ans = 0
        # iter backwards starting and pick 2 digs
        # 0100110
        

        # 00 -> do nothing
        # 10 -> gap += 1
        # 1 -> ans += gaps

        # 0 -> do nothing
        # 1 -> gaps++ and ans += gaps
        # 1-> ans += gaps

        gaps = 0
        ans = 0

        for i in range(len(s) - 2, -1, -1):
            if s[i] == "1":
                if(s[i + 1] == "0"):
                    gaps += 1
                ans += gaps

        return ans

        


