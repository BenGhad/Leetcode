class Solution:
    def missingInteger(self, nums: List[int]) -> int:
        rizz = nums[0]
        for i in range(1, len(nums)):
            if nums[i] == nums[i-1] + 1:
                rizz += nums[i]
            else:
                break
        poopie = set(nums)

        while rizz in poopie:
            rizz += 1
        return rizz

