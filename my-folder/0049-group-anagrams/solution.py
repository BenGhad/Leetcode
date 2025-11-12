class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        freqs = {}
        for s in strs:
            key = "".join(sorted(s))
            if key not in freqs:
                freqs[key] = []
            freqs[key].append(s)
        
        ans = []
        for key in freqs:
            ans.append(freqs[key])
        
        return ans
