class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        freq = defaultdict(int)
        ans = 0
        
        for num in nums:
            if freq[num] == 0:
                ans += freq[num - k] # num - i = k => i = num - k
                ans += freq[num + k] # num - i = -k =? i = num + k
                freq[num] = 1
            elif freq[num] == 1 and k == 0:
                ans += 1
                freq[num] += 1
        
        return ans
