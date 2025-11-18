class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for num in nums:
            num = abs(num) - 1
            nums[num] = -abs(nums[num])
        
        cout = 0
        for i in range(len(nums)):
            if nums[i] > 0:
                nums[cout] = i+1
                cout += 1
        
        return nums[:cout]
