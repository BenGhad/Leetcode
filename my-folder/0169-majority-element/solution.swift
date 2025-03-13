class Solution {
    func majorityElement(_ nums: [Int]) -> Int {
        var leader = -1
        var votes = 0
        for num in nums{
            if(leader == num){
                votes += 1
            } else {
                if(votes == 0){
                    leader = num
                } else {
                    votes -= 1
                }
                
            }
        }
        return leader
    }
}
