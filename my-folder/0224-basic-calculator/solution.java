class Solution {
    public int calculate(String s) {
        s = s.replaceAll("\\s", "");
        return calc(s, 0)[0];
    }

    // { value, idx }
    public int[] calc(String s, int l){
        int ans = 0;
        for(int i = l; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                int[] paren = calc(s, i + 1);
                ans += paren[0];
                i = paren[1];
            } else if(c == ')'){
                return new int[]{ans, i};    
            } else if(c == '-'){
                int j = i + 1;
                if(s.charAt(j) == '('){
                    int[] paren = calc(s, j + 1);
                    ans -= paren[0];
                    i = paren[1];
                } else {
                    int[] num = add(s, j);
                    ans -= num[0];
                    i = num[1];
                }
                
            } else if(c == '+'){
                int j = i + 1;
                if(s.charAt(j) == '('){
                    int[] paren = calc(s, j + 1);
                    ans += paren[0];
                    i = paren[1];
                } else {
                    int[] num = add(s, j);
                    ans += num[0];
                    i = num[1];
                }

            } else {    
                int[] sum = add(s, i);
                ans += sum[0];
                i = sum[1];
            }
        }
        return new int[]{ans, s.length()};
    }

    public int[] add(String s, int l){
        int r = l;
        while(r < s.length() && Character.isDigit(s.charAt(r))){
            r++;    
        }
        return new int[]{
            Integer.parseInt(s.substring(l, r)),
            r - 1
        };
    }
}
