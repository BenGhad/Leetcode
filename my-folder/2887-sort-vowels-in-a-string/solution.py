class Solution(object):
    def sortVowels(self, s):
        vowels = set('AEIOUaeiou')
        chars = list(s)

        pos = [i for i, c in enumerate(chars) if c in vowels]
        vs = sorted(chars[i] for i in pos) 

        for i, v in zip(pos, vs):
            chars[i] = v

        return ''.join(chars)

