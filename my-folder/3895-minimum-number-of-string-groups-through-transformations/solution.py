class Solution:
    def minimumGroups(self, words: List[str]) -> int:
        # I do not remember KMP but this is probably KMP
        # abb is ab, a
        # bba is ba, b
        # so can ab and ba be thingied
        # can define hash of subsequence 
        myHash = set()

        for word in words:
            even = []
            odd = []

            nw = len(word)
            for i in range(0, nw, 2):
                even.append(word[i])
            for i in range(1, nw, 2):
                odd.append(word[i])

            # stupid cheat idea:
            k1 = self.keyDat(even)
            k2 = self.keyDat(odd)
            myHash.add(
                (k1, k2)
            )

        return len(myHash)
    
    def keyDat(self, word):
        chars = [0] * 26
        #pairs = [0] * 26 * 26
        # triples = [0] * (26 * 26 * 26)
        n = len(word)
        k1 = 0
        k2 = 0
        MOD = 1000000007
        MOD67 = 1000000067
        for i in range(n):
            a = ord(word[i]) - ord('a')
            b = ord(word[(i+1) % n]) - ord('a')
            c = ord(word[(i+2) % n]) - ord('a')
            chars[a] += 1
            #pairs[a * 26 + b] += 1
            #triples[(a * 26 + b) * 26 + c] += 1
            pair = a * 26 + b 
            k1 = (k1 + pair * pair * 911382323) % MOD
            k2 = (k2 + pair * pair * pair * 972663749) % MOD67

        return (
            "".join(sorted(word)), len(word), tuple(chars), k1, k2
        )
        
