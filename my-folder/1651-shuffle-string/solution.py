class Solution:
    def restoreString(self, s: str, indices: List[int]) -> str:
        n = len(s)
        
        thingy = ['' for _ in range(n)]
        
        for i in range(n):
            thingy[indices[i]] = s[i]
        
        return ''.join(thingy)
