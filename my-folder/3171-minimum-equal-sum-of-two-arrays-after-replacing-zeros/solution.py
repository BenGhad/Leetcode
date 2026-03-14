class Solution:
    def minSum(self, nums1: List[int], nums2: List[int]) -> int:
        s1 = sum(nums1)
        s2 = sum(nums2)

        z1 = False
        z2 = False

        for i in range(len(nums1)):
            if nums1[i] == 0:
                s1 += 1
                z1 = True
                
        for i in range(len(nums2)):
            if nums2[i] == 0:
                z2 = True
                s2 += 1
        
        if not z1 and not z2:
            return s1 if s1 == s2 else -1
        
        if z1 and z2:
            return max(s1, s2)
        
        if z1:
            return s2 if s2 >= s1 else -1
        
        return s1 if s1 >= s2 else -1

        """
        no zeros: s1 == s2 then s1
        zero in both: max(s1, s2) + 1 i think
        zero in s1:
        s1 > s2 false
        s1 < s2 s2
        """

