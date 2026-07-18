class Solution {
    public boolean isPalindrome(int x) {
        if(x == 0) return true;
        if(x < 0) return false;
        
        int numDigs = (int)Math.log10(x) + 1;
        
        Stack<Integer> digs = new Stack<>();
        
        for(int i = 0; i < numDigs / 2; i++){
            digs.push(x % 10);
            x /= 10;
        }
        
        if(numDigs % 2 != 0) x /= 10;
        
        while(!digs.isEmpty()){
            if(x % 10 != digs.pop()) return false;
            x /= 10;
        }
        return true;
    }
}
