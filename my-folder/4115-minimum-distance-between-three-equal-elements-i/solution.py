class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        freqs = {}
        for i in range(len(nums)):
            num = nums[i]
            if num not in freqs:
                freqs[num] = []
            freqs[num].append(i)

    
        ans = float('inf')
        for num in freqs:
            lst = freqs[num]
            n = len(lst)
            for i in range(n):
                for j in range(i+1, n):
                    for k in range(j+1, n):
                        ans = min(ans,
                        abs(lst[i] - lst[j]) +
                        abs(lst[j] - lst[k]) +
                        abs(lst[k] - lst[i])
                        )

        return ans if ans != float('inf') else -1
