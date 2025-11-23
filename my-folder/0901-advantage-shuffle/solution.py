class Solution:
    def advantageCount(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n = len(nums1)
        ans = [0] * n
        nums1 = sorted(nums1)

        n2c = sorted([(-val, idx) for idx, val in enumerate(nums2)])

        lo = 0
        hi = n - 1

        for val, idx in n2c:
            if nums1[hi] > abs(val):
                ans[idx] = nums1[hi]
                hi -= 1
            else:
                ans[idx] = nums1[lo]
                lo += 1
        return ans
                
        
                
