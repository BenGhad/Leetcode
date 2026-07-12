class Solution:
    def sortString(self, s: str) -> str:
        freq = [0 for _ in range(26)]
        
        for c in s:
            freq[ord(c) - ord('a')] += 1
        
        ans = []

        while len(ans) < len(s):
            for l in range(26):
                if freq[l] > 0:
                    freq[l] -= 1
                    
                    ans.append(chr(l + 97))
            
            for r in range(25, -1, -1):
                if freq[r] > 0:
                    freq[r] -= 1
                    
                    ans.append(chr(r+97))

        return "".join(map(str, ans))
