class Solution:
    def minSideJumps(self, obstacles: List[int]) -> int:
        n = len(obstacles)
        lanes = [1, 0, 1]
        
        for o in obstacles:
            if o > 0:
                lanes[o - 1] = float('inf')
            
            for i in range(3):
                if o != i + 1:
                    lanes[i] = min(
                        lanes[i], min(
                            lanes[(i + 1) % 3], 
                            lanes[(i + 2) % 3]) + 1
                    )
        return min(lanes)
