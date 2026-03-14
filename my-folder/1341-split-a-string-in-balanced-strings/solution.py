class Solution:
    def balancedStringSplit(self, s: str) -> int:
        ans = 0
        l = 0
        r = 0
        
        for c in s:
            if c == 'R':
                r += 1
            else:
                l += 1
            
            if l == r:
                ans += 1
                
        return ans
