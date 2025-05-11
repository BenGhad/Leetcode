class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        // base case:
        if(arr.length < 3) return false;   
        
        int count = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 == 1){
                count++;
                if(count == 3) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }
}
