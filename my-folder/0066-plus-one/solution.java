class Solution {
    public int[] plusOne(int[] digits) {
        int[] d = new int[digits.length + 1];
        System.arraycopy(digits, 0, d, 1, digits.length);        
        for(int i = d.length - 1; i > 0; i--){
            if(d[i] != 9){
                d[i]++;
                return Arrays.copyOfRange(d, 1, d.length);
            } else {
                d[i] = 0;
            }
        }
        d[0] = 1;
        return d;

    }
}
