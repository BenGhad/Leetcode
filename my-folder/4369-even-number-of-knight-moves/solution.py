class Solution:
    def canReach(self, start: list[int], target: list[int]) -> bool:
        """
        x, y
        x+2, y+1
        x+1, y+2
        wait im stupid this is a chess puzzle
        """
        sx = start[0]
        sy = start[1]

        dx = target[0]
        dy = target[1]
        white = (sx + sy + 1) % 2
        black = (dx + dy + 1) %2

        return white == black
