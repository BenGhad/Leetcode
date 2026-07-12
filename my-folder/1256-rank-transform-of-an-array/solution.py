class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        dupe = sorted(set(arr))
        rank = {}
        for r, num in enumerate(dupe):
            rank[num] = r + 1 
        
        return [rank[i] for i in arr]

        
