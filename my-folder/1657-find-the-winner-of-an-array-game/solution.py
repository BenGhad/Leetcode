class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        if k > len(arr):
            return max(arr)
        
        arr = deque(arr)

        winner = arr.popleft()
        conseq = 0

        while conseq < k:
            cand = arr.popleft()
            
            if cand > winner:
                arr.append(winner)
                winner = cand
                conseq = 1
            else:
                arr.append(cand)
                conseq += 1

        return winner
