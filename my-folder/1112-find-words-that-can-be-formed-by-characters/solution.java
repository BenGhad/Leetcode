class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq = new int[26];
        for(int i = 0; i < chars.length(); i++){
            freq[chars.charAt(i) - 'a']++;
        }
        
        int sum = 0;
        for(String s : words){
            if(contains(s, freq)) sum += s.length();
        }
        return sum;
    }
    public boolean contains(String s, int[] freq){
        int[] wordFreq = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            wordFreq[s.charAt(i) - 'a']++;   
        }
        
        for(int i = 0; i < 26; i++){
            if(wordFreq[i] > freq[i]) return false;
        }
        
        return true;
    }
}
