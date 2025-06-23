class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] files = path.split("/");

        for(String s : files){
            if(s.equals(".")) continue;
            
            if(s.equals("..")){
                if(!stack.isEmpty()) stack.pop();
                continue;
            } 

            if(s.equals("")) continue;

            stack.push(s);

        }
        if(stack.isEmpty()){
            return "/";
        }
        Stack<String> reverse = new Stack<>();
        while(!stack.isEmpty()){
            reverse.push(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!reverse.isEmpty()){
            sb.append("/");
            sb.append(reverse.pop());    
        }
        return sb.toString();
    }
}
