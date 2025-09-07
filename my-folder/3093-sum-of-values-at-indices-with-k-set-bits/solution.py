class Solution(object):
    def sumIndicesWithKSetBits(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        result = 0
        for i, num in enumerate(nums):
            result += num if kBit(i, k) else 0
        return result

def kBit(num, k):
    count = 0
    while num > 0:
        count += num & 1
        num >>= 1
    return count == k
        
