class Solution:
    def splitArray(self, nums: List[int]) -> int:
        if len(nums) == 2:
            return abs(nums[0] - nums[1])
        
        i = 1
        while i < len(nums):
            if nums[i] <= nums[i-1]:
                break
            i += 1
        
        # i CANT BRO
        if i == len(nums):
            return abs(sum(nums[:-1]) - nums[-1])

        j = i+1
        while j < len(nums):
            if nums[j] >= nums[j-1]:
                break
            j +=1 
        
        if j != len(nums):
            return -1


        s1 = sum(nums[:i])
        s2 = sum(nums[i:])

        

        ans= abs(s1 - s2)

        if nums[i-1] > nums[i]:
            s1 -= nums[i-1]
            s2 += nums[i-1]
            
            ans = min(ans, abs(s1 - s2))

        return ans
        # i can maybe go other side, ts a edge case tho

