class Solution:
    def minElements(self, nums: List[int], limit: int, goal: int) -> int:
        s = sum(nums)  
        return (abs(goal - s) + limit - 1) // limit
    

