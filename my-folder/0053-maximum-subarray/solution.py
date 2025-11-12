class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        mSum = nums[0]
        s = 0
        i = 0

        for j in range(len(nums)):
            while i < j and s <= 0:
                s -= nums[i]
                i += 1

            s += nums[j]
            
            mSum = max(mSum, s)
        
        return mSum
