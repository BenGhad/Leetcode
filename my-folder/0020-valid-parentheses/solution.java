import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack1 = new Stack();

        for(char C : s.toCharArray()){
            if(C == '(' || C == '{' || C == '['){
                stack1.push(C);
            } else if(C == ')' && !stack1.isEmpty() && stack1.peek() == '('){
                stack1.pop();
            } else if(C == '}' && !stack1.isEmpty() && stack1.peek() == '{'){
                stack1.pop();
            } else if(C == ']' && !stack1.isEmpty() && stack1.peek() == '['){ 
                stack1.pop();
            } else {
                return false;
            } 
        }
        return stack1.isEmpty();
    }
}
