class Solution {
    public int findComplement(int num) {
        String binaryRepresentation = Integer.toBinaryString(num);
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < binaryRepresentation.length(); i++){
            char bit = binaryRepresentation.charAt(i);
            ans.append(bit == '0' ? '1' : '0');
        }
        return Integer.parseInt(ans.toString(), 2);

    }
}
