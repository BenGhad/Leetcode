class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        boolean found = false;

        for(int i = 0; i < word.length(); i++){
            if(!found){
                stack.push(word.charAt(i));
                
                if(word.charAt(i) == ch){
                    found = true;
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                }
            } else{
                sb.append(word.charAt(i));
            }
        }

        

        return (stack.isEmpty()) ? sb.toString() : word;
    }
}
