class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        ans = 0
        n = len(strs[0])
        for col in range(n):
            prev = 'a'
            for word in strs:
                if word[col] < prev:
                    ans += 1
                    break
                prev = word[col]
        
        return ans
                
