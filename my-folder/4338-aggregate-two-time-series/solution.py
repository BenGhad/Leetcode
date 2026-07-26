class Solution:
    def aggregateTimeSeries(self, s1: list[list[int]], s2: list[list[int]]) -> list[list[int]]:
        ans = []

        """
        take i
        EOJ or i better
        take j
        take ij
        same timestamp
        """

        i = 0
        j = 0
        n = len(s1)
        m = len(s2)

        while i < n or j < m:
            t1, v1 = s1[i] if i < n else (float('inf'), 0)
            t2, v2 = s2[j] if j < m else (float('inf'), 0)
            
            vals = v1 + v2

            if t1 < t2:
                ans.append((t1, vals))
                i += 1

            elif t2 < t1:
                ans.append((t2, vals))
                j += 1

            else:
                ans.append((t1, vals))
                i += 1
                j += 1
        
        return ans
