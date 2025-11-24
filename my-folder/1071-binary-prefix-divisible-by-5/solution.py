class Solution:
    def prefixesDivBy5(self, nums: List[int]) -> List[bool]:
        ans = []
        prf = 0
        for num in nums:
            prf = (prf << 1) | num
            ans.append(prf % 5 == 0)
        return ans
