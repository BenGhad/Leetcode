class Solution {
    public String makeFancyString(String s) {
        if(s.length() < 3) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, 2));
        for(int i = 2; i < s.length(); i++){
            char c = s.charAt(i);
            if(sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2) && sb.charAt(sb.length() - 1) == c) continue;
            sb.append(c);
        }
        return sb.toString();
    }
}
