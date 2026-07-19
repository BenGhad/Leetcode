class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        ans = []
        for num in nums:
            ans.append(0)
            for n2 in nums:
                if n2 < num:
                    ans[-1] += 1
        return ans
                
