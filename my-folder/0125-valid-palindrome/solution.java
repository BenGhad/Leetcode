class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            } else if(Character.isDigit(c)){
                sb.append(c);
            }
        }
        
        
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) return false;
        }
        
        return true;
    }
}
