class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        //pass 1: identify bulls & do setup for cows
        int n = secret.length();
        int[] freqS = new int[10];
        int[] freqG = new int[10];
        for(int i = 0; i < n; i++){
            int sChar = Character.getNumericValue(secret.charAt(i));
            int gChar = Character.getNumericValue(guess.charAt(i));
            
            if(sChar == gChar){
                bulls++;
            } else {
                freqS[sChar]++;
                freqG[gChar]++;
            }
        }  

        //pass 2: identify cows:
        for(int i = 0; i < 10; i++){
            cows += Math.min(freqS[i], freqG[i]);
        }


        
        return "" + bulls + "A" + cows + "B";
    }
}
