class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        ans = 0
        cout = 0
        for i in nums:
            if i == 1:
                cout += 1
                ans = max(ans, cout)
            else:
                cout = 0
        return ans
