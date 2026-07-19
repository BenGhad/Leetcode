class Solution:
    def transformArray(self, nums: List[int]) -> List[int]:
        
        ting = [0, 0]
        for num in nums:
            ting[num % 2] += 1
        
        return [0] * ting[0] + [1] * ting[1]
