class Solution:
    def maximumProduct(self, nums: List[int]) -> int:
        """
        biggest pos,
        """
        nums = sorted(nums)

        if nums[-1] <= 0:
            return nums[-1] * nums[-2] * nums[-3]
        return nums[-1] * max(nums[0] * nums[1], nums[-2] * nums[-3])
