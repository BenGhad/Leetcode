class Solution:
    def flipAndInvertImage(self, image: List[List[int]]) -> List[List[int]]:
        ans = []
        
        for row in image:
            ans.append([])
            for dig in row[::-1]:
                ans[-1].append((dig+1)%2)
        return ans
