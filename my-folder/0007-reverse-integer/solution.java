class Solution {
    public int reverse(int x) {
        String str = Integer.toString(Math.abs(x));
        String result = "";
        if (x == Integer.MIN_VALUE) {
            return 0; // since 2^31 cannot be represented as a positive integer in Java
        }

        for(int i = str.length() -1; i >= 0; i--){
            result = result.concat(str.substring(i, i + 1));
        }

        if(Long.parseLong(result) > Integer.MAX_VALUE || Long.parseLong(result) < Integer.MIN_VALUE){
            return 0;
        }

        return (x > 0) ? (Integer.parseInt(result)) : (-1 * Integer.parseInt(result));
        
        
    }
}
