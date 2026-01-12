class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1: return 1
        if n == 2: return 2


        pref = [0] * (n) # pref[i] how many before INCLUDING
        suf = [0] * (n)
        
        for i in range(n):
            if i > 0 and nums[i] >= nums[i - 1]:
                pref[i] = pref[i - 1] + 1
            else:
                pref[i] = 1
        
        for i in range(n-1, -1, -1):
            if i < n-1 and nums[i] <= nums[i + 1]:
                suf[i] = suf[i + 1] + 1
            else:
                suf[i] = 1
        
        ans = max(
            suf[1] + 1,
            pref[n-2] + 1
        )
        
        for i in range(1, n-1):
            prv = nums[i - 1]
            cnt = nums[i]
            nxt = nums[i + 1]

            if prv <= nxt:
                ans = max(ans, pref[i-1] + suf[i+1] + 1)
            else:
                ans = max(ans,
                    max(pref[i-1], suf[i + 1]) + 1
                )

        return ans
