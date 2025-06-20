class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < 26; i++){
            int min = freq[i];
            int del = 0;
            for(int j = 0; j < 26; j++){
                if(i == j) continue;
                if(freq[j] < freq[i]){
                    del += freq[j];
                } else {
                    del += Math.max(freq[j] - freq[i] - k, 0);
                }
            }
            ans = Math.min(ans, del);
        }
        

        
        return ans;

    }
}
