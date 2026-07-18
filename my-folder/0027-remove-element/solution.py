class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        ans = 0
        
        l = 0
        
        n = len(nums)
        r = 0
        for i in range(n):
            if nums[i] != val:
                nums[r] = nums[i]
                r += 1
            else:
                ans += 1
        
        return r
