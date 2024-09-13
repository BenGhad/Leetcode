class Solution {
    public int appendCharacters(String t, String s) {
        if(s.length() == 0){return 0;}
        int subLen = 0;
        char crnt = s.charAt(subLen);
    
        for(int i = 0; i < t.length(); i++){
            char tmp = t.charAt(i);
            if(tmp == crnt){
                if(subLen == s.length() - 1){
                    return 0;
                }
                subLen++;
                crnt = s.charAt(subLen);
            }
        }
        return s.length() - subLen;
    }
}


