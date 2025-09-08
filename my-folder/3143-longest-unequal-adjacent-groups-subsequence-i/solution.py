class Solution(object):
    def getLongestSubsequence(self, words, groups):
        """
        :type words: List[str]
        :type groups: List[int]
        :rtype: List[str]
        """
        ans = []
        group = -1
        for i, string in enumerate(words):
            if groups[i] != group:
                ans.append(string)
                group = groups[i]
        return ans

        
