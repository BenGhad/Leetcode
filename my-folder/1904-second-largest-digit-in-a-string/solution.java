class Solution {
    public int secondHighest(String s) {
        int big = -1;
        int second = -1;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!Character.isDigit(c)) continue;

            int n = (int)(c - '0');
            if(n > big){
                second = big;
                big = n;
            } else if (n > second && n != big){
                second = n;
            }

        }

        return second;
    }
}
