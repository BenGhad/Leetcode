class Solution:
    def customSortString(self, order: str, s: str) -> str:
        freq = [0] * 26
        for c in s:
            freq[ord(c) - ord('a')] += 1
        
        ans = ""
        
        for c in order:
            for _ in range(freq[ord(c) - ord('a')]):
                ans += c
        
        
        for i in range(26):
            c = chr(ord('a') + i)
            if c not in order:
                for _ in range(freq[ord(c) - ord('a')]):
                    ans += c
                    
        return ans
