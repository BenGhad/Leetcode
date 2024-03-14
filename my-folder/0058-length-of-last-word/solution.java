class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) != ' '){
                count++;
            } else {
                if(count > 0){return count;}
            }
        }
        return count; 
    }
}



        /** int count = 0;
        boolean space = false;
        for(int i = 0; i < s.length(); i++){
            if(s.substring(i, i+1).equals(" ")){
                space = true;
            } else if(space){
                count = 1;
                space = false;
            } else{
                count++;
            }
        }
        return count;
        */
