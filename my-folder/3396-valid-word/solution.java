class Solution {
    public boolean isValid(String word) {
        boolean mango = false;
        boolean massive = word.length() >= 3;
        boolean mustard = false;

        String gyatts = "aeiouAEIOU";
        String rizzlers = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(gyatts.indexOf(c) != -1){
                mango = true;
            } else if (rizzlers.indexOf(c) != -1){
                mustard = true;
            } else if (!Character.isDigit(c)){
                return false;
            }
        }
        return mango && massive && mustard;
    }
}
