class Solution:
    def smallestSubsequence(self, s: str) -> str:
        last = {}
        n = len(s)
        for i in range(n):
            last[s[i]] = i

        stack = []
        used = set()

        for i in range(n):
            c = s[i]
            if c in used:
                continue
                

            while stack and stack[-1] > c and last[stack[-1]] > i:
                used.remove(stack.pop())

            stack.append(c)
            used.add(c)

        return "".join(stack)
