class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(1);
            } else {
                if(stack.isEmpty()) {
                count++;
                } else {
                    stack.pop();
                }
            }
        }
        return count + stack.size();
    }
}
