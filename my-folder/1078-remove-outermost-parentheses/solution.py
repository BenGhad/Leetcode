class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        ans = []
        l = 0
        
        n = len(s)
        while l < n:
            # l == (
            lP = 1
            
            r = l + 1
            while r < n:
                if s[r] == "(":
                    lP += 1
                else:
                    lP -= 1
                
                if lP == 0:
                    l = r+1
                    break
                ans.append(s[r])
                r += 1
                
        return "".join(ans)
