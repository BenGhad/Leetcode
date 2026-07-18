class MagicDictionary {
    String[] dict;
    public MagicDictionary() {
        
    }
    
    public void buildDict(String[] dictionary) {
        dict = dictionary;
    }
    
    public boolean search(String searchWord) {
        for (String w : dict){
            if(w.length() != searchWord.length()) continue;
            int change = 0;
            for(int i = 0; i < searchWord.length(); i++){
                if(w.charAt(i) != searchWord.charAt(i)){
                    change += 1;
                }
                if (change > 1) break;
            }
            if (change == 1) return true;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
