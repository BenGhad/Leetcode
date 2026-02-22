class Solution(object):
    def largestRectangleArea(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        n = len(heights)
        nextSmall = [(n) for _ in range(n)]
        prevSmall = [-1 for _ in range(n)]

        st = []

        # nextSmall pass
        for i in range(n):
            while len(st) > 0 and heights[st[-1]] > heights[i]:
                idx = st.pop()
                nextSmall[idx] = i 
            
            st.append(i)
        st = []        
        # prevSmall
        for i in range(n-1, -1, -1):
            while len(st) > 0 and heights[st[-1]] > heights[i]:
                idx = st.pop()
                prevSmall[idx] = i
            st.append(i)
        
        ans = -1

        
        dbug = True
        if dbug:
            for i in range(n):
                print(str(nextSmall[i]), end=" ")
            
            print("")
            
            for i in range(n):
                print(prevSmall[i], end =" ")

            print("")

        for i in range(n):
            r = nextSmall[i]
            l = prevSmall[i]

            ans = max(
                ans, 
                heights[i] * (r - l -1)
            )

        return ans
