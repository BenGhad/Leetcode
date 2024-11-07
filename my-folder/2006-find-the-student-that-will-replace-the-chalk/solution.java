class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long cSum = 0;
        for(int i : chalk){
            cSum += i;
        }
        long l = (long)k % cSum;
        for(int i = 0; i < chalk.length; i++){
            if(l < chalk[i]){
                return i;
            } else {
                l -= chalk[i];
            }
        }
        return 0;
    }
}
