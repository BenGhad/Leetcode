class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        odds = 0
        n = len(matrix)
        zero = False
        ls = []
        for r in matrix:
            for c in r:
                if c < 0:
                    odds += 1
                elif c == 0:
                    zero = True
                ls.append(abs(c))
        
        if odds % 2 == 0:
            return sum(abs(num) for row in matrix for num in row)
        else:
            ls = sorted(ls)
            return sum(abs(num) for row in matrix for num in row) -2 * abs(ls[0])
