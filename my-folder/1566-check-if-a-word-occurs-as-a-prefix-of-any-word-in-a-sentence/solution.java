class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int s = 0;
        int n = searchWord.length();
        int ans = 1;
        for(int i = 0; i < sentence.length(); i++){
            if(sentence.charAt(i) == ' '){
                if(s + n > sentence.length()) return -1;
                if(sentence.substring(s, s + n).equals(searchWord)){
                    return ans;
                }
                s = i + 1;
                ans++;
            }
        }
        if(s + n > sentence.length()) return -1;
        if(sentence.substring(s, s + n).equals(searchWord)){ return ans;}
        return -1;
    }
}
