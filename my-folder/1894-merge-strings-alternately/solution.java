class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        StringBuilder str = new StringBuilder(n + m);

        for(int i = 0; i < Math.min(n, m); i++){
            str.append(word1.charAt(i));
            str.append(word2.charAt(i));
        }

        if(n > m){
            str.append(word1.substring(m, n));
        }
        if(m > n){
            str.append(word2.substring(n, m));
        }
        return str.toString();
    }
}
