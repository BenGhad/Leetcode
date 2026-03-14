class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        ans = []
        chars = ['a', 'b', 'c']
        
        def dfs(cur):
            if len(ans) >= k:
                return
            if len(cur) == n:
                ans.append("".join(cur))
                return
            
            for ch in chars:
                if not cur or cur[-1] != ch:
                    cur.append(ch)
                    dfs(cur)
                    cur.pop()
        
        dfs([])
        return ans[k - 1] if k <= len(ans) else ""
