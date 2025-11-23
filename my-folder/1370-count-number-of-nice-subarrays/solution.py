class Solution:
    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        n = len(nums)
        cout = 0
        pref = 0
        count = defaultdict(int)
        count[0] = 1
        # count[i]: number of indices where there is i odds up to and including
        for num in nums:
            if num % 2 != 0:
                pref += 1
        
            count[pref] += 1

            if pref - k in count:
                cout += count[pref - k]
        
        return cout
