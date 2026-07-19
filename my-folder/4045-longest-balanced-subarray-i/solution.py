class Solution:
    def longestBalanced(self, nums: List[int]) -> int:
        ans = 0

        n = len(nums)
        for i in range(n):
            odd = defaultdict(int)
            even = defaultdict(int)

            for j in range(i, len(nums)):
                if nums[j] % 2 != 0:
                    odd[nums[j]] = odd[nums[j]] + 1
                else:
                    even[nums[j]] = even[nums[j]] + 1
                
                if len(odd) == len(even):
                    ans = max(ans, j-i+1)
                    
        return ans
