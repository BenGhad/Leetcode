class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        ans = 0
        mx = 0
        
        for i, num in enumerate(arr):
            mx = max(mx, num)
            if mx == i:
                ans +=1 

        return ans
