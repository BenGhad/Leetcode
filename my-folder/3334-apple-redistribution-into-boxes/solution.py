class Solution:
    def minimumBoxes(self, apple: List[int], capacity: List[int]) -> int:
        app = sum(apple)
        capacity = sorted(capacity, key=lambda x: -x)
        ans = 0
        
        for c in capacity:
            if app > 0:
                app -= c
                ans += 1
            else:
                break
        return ans
