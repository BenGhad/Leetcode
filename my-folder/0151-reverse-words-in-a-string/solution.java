class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i = str.length - 1; i >= 0; i--){
            if(!str[i].equals("")){
                ans.append(str[i]);
                if(i != 0){
                    ans.append(" ");
                }
            }
        }
        String res = ans.toString();
        if(res.charAt(res.length() - 1) == ' '){
            res = res.substring(0, res.length() - 1);
        }
        return res;
    }
}
