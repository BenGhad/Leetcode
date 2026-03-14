class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        freq = defaultdict(int)
        n = len(nums)
        ans = 0

        l = 0
        for r in range(0, n):
            num = nums[r]
            freq[num] += 1
            
            while freq[num] > k:
                freq[nums[l]] -= 1
                l += 1

            ans = max(ans, r-l+1)
        
        return ans


        

