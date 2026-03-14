class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        chrFreq = [0] * 26
        
        fst = words[0]
        for c in fst:
            chrFreq[ord(c) - ord('a')] += 1
        
        for word in words[0:]:
            freaky = [0] * 26
            for c in word:
                freaky[ord(c) - ord('a')] += 1
            
            for i in range(26):
                chrFreq[i] = min(chrFreq[i], freaky[i])
                
        ans = []
        for i in range(26):
            ltr = chr (i + 97)
            for _ in range(chrFreq[i]):
                ans.append(ltr)
        return ans
