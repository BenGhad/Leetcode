class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int j = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) == str2.charAt(j)){
                j++;
                if(j == str2.length()) return true;
            }  else if(str1.charAt(i) == 'z' && str2.charAt(j) == 'a'){
                j++;
                if(j == str2.length()) return true;
            } else if((char)(str1.charAt(i) + 1) == str2.charAt(j)){
                j++;
                if(j == str2.length()) return true;
            }
        }

        return false;
    }
}
