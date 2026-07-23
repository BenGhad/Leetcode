class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        l = 0
        r = n-1
        
        if len(nums) == 1:
            return 0
        
        if nums[0] > nums[1]:
            return 0
        if nums[-1] > nums[-2]:
            return n-1
        
        while l <= r:
            m = l + (r-l)//2
            
            if nums[m] < nums[m-1]:
                r = m
            elif nums[m] < nums[m+1]:
                l = m
            else:
                return m
            
        
        return -1 
