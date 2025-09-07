class Solution(object):
    def minLength(self, s):
        """
        :type s: str
        :rtype: int
        """
        minLen = len(s)
        stack = []
        for c in s:
            stack.append(c)
            while len(stack) >= 2 and canRemove(stack[-2], stack[-1]):
                stack.pop()
                stack.pop()
                minLen -= 2
        return minLen
    
def canRemove(a, b):
        return a == 'A' and b == 'B' or a == 'C' and b == 'D'
