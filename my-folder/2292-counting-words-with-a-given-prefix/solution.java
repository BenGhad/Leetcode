class Solution {
    public int prefixCount(String[] words, String pref) {
        int output = 0;

        for(String s : words){
            
            if(s.length() >= pref.length()){
                if(s.startsWith(pref)){
                    output++;
                }
            }


        }
        return output;
    }
}


