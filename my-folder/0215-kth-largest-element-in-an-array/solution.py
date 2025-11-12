class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        freq = {}

        for num in nums:
            if num not in freq:
                freq[num] = 0
            freq[num] += 1
        
        larg = 0
        for i in range(10000, -10000, -1):
            if i not in freq: continue
            larg += freq[i]
            if larg >= k:
                return i
        

        return -67676767676776
