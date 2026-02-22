class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        yum = [
        sum(sand == 0 for sand in students),
        sum(sand == 1 for sand in students) # meh but ok
        ]

        ans = len(students)
        
        for sandwich in sandwiches:
            if yum[sandwich] == 0: return ans
            yum[sandwich] -= 1
            ans -= 1
        
        return 0
                
