class Solution(object):
    def maximumLengthSubstring(self, s):
        ans = 0
        l = 0
        freq = {}

        for r in range(len(s)):
            c = s[r]
            freq[c] = freq.get(c, 0) + 1

            while freq[c] > 2:
                freq[s[l]] -= 1
                l += 1

            ans = max(ans, r - l + 1)

        return ans
