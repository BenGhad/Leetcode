class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
            }
        if(x < 10) { 
            return true;
            }
        if(x < 100) {
            return (x % 10) == (x/10);
            }

        String str = Integer.toString(x);
        int len = str.length();
        String one = str.substring(0, (len / 2));
        StringBuilder two = new StringBuilder();

        int startIdx = len % 2 == 0 ? len / 2 : len / 2 + 1; 
        for(int i = len - 1; i >= startIdx; i--){
            two.append(str.charAt(i));
        }

        return one.equals(two.toString());
    }
}

