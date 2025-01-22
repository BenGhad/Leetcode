class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int ans = 0;
        Arrays.sort(words, (str1, str2) -> Integer.compare(str1.length(), str2.length()));
        int[] chains = new int[n];
        for(int i = n - 1; i >= 0; i--){
            String word = words[i];
            chains[i] = 1;
            for(int j = i; j < n; j++){
                if(words[j].length() == word.length()) continue;
                if(words[j].length() > word.length() + 1) break;
                String next = words[j];
                if(chainable(word, next)) {
                    chains[i] = Math.max(chains[i], chains[j] + 1);
                    ans = Math.max(ans, chains[i]);
                }
            }
        }

        return Math.max(ans, 1);
    }

    public boolean chainable(String word, String next){
        if(word.length() + 1 != next.length()) return false;
        int i = 0;
        int j = 0;
        while(i < word.length()){
            if(word.charAt(i) != next.charAt(j)){
                if(i != j || word.charAt(i) != next.charAt(j + 1)) return false;
                j++;
            } 
            i++;
            j++;
        }
        return true;
    }
}
