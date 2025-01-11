class Solution {
    public boolean canConstruct(String s, int k) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        int odds = 0;
        int possibles = 0;
        for(int i = 0; i < 26; i++){
            if(freq[i] % 2 != 0) odds++;
            possibles += freq[i];
            
        }

        if(odds > k || possibles < k) return false;


        return true;

    }
}
