class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int[] shift = new int[shifts.length];
        shift[shifts.length - 1] = shifts[shifts.length - 1];
        for(int i = shifts.length - 2; i >= 0; i--){
            shift[i] = (shift[i + 1] + shifts[i]) % 26;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            sb.append((char)((c - 'a' + shift[i]) % 26 + 'a'));
        }

        return sb.toString();
        
    }
}
