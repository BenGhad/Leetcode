class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        int ans = s.length();

        for(int i : freq){
            if(i > 2){
                ans -= ((i - 1) / 2) * 2;
                /*
                3 2
                4 2
                5 3
                6 3

                */
            }            
        }

        return ans;

    }
}
