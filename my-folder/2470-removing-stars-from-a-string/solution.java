class Solution {
    public String removeStars(String s) {
        //Intended Stack sol, 2x storage, since we use 2 auxillary structures:
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '*'){
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();


        /*Trivial SB sol:
        StringBuilder sb = new StringBuilder();
        int rm = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '*') {
                rm++;
            } else {
                if (rm > 0) {
                    rm--;
                } else {
                    sb.append(c);
                }
            }
        }
        sb.reverse();
        return sb.toString();
        */
    }
}
