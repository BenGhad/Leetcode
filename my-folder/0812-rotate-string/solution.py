class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        # i forgot my KMP bullshit but whatever fuck this n^2 is fine even if bounds suggest n^3
        
        if len(s) != len(goal):
            return False
        
        n = len(s)
        for i in range(n):
            if s[i] != goal[0]:
                continue
                
            good = True
            for cnt in range(n):
                if s[(i+cnt) % n] != goal[cnt]:
                    good = False
                    break
            if good:
                return True
            
            
        
        return False
