class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        n = len(nums)
        minF = n // 3 + 1
        
        frq = defaultdict(int)
        ans = []
        for num in nums:
            frq[num] += 1
            if frq[num] == minF:
                ans.append(num)
        return ans
