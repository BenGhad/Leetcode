class Solution:
    def buddyStrings(self, s: str, goal: str) -> bool:
        diffs = []
        if len(s) != len(goal):
            return False
        
        for ca, cb in zip(s, goal):
            if ca != cb:
                diffs.append((ca, cb))
                if len(diffs) > 2:
                    return False
        if len(diffs) == 0:
            return len("".join(dict.fromkeys(goal))) < len(goal)
        if len(diffs) != 2:
            return False
        ca1, ca2 = diffs[0]
        cb1, cb2 = diffs[1]
        
        return ca1 == cb2 and ca2 == cb1
