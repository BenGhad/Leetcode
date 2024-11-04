class Solution {
    public String compressedString(String word) {
        char[] cArr = word.toCharArray();
        int i = 0;
        StringBuilder ans = new StringBuilder();
        while(i < cArr.length){
            char l = cArr[i];
            int j = 0;
            while(i + j < cArr.length && cArr[j + i] == l && j < 9){
                j++;
            }
            ans.append(j);
            ans.append(l);
            i += j;
        }
        return ans.toString();
    }
}
