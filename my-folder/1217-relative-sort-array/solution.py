class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        freaky = defaultdict(int)
        
        for num in arr1:
            freaky[num] += 1
        
        ans = []
        
        for num in arr2:
            ans.extend([num] * freaky[num])
            freaky.pop(num)
        
        baboi = sorted(freaky.keys())
        for num in baboi:
            ans.extend([num] * freaky[num])
        return ans
