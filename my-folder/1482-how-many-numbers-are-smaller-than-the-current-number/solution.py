class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [0] * n
        for i in range(n):
            cout = 0
            for j in range(n):
                if i == j: continue
                if nums[j] < nums[i]: cout += 1
            ans[i] = cout
        return ans
