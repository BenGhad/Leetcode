class TextEditor {
    Stack<Character> prev;
    Stack<Character> next;

    public TextEditor() {
        prev = new Stack<>();
        next = new Stack<>();
    }
    
    public void addText(String text) {
        for(int i = 0; i < text.length(); i++){
            prev.push(text.charAt(i));
        }
    }
    
    public int deleteText(int k) {
        for(int i = 0; i < k; i++){
            if(prev.isEmpty()) return i;
            prev.pop();
        }

        return k;
    }
    
    public String cursorLeft(int k) {
        for(int i = 0; i < k; i++){
            if(prev.isEmpty()) return "";
            next.push(prev.pop());
        }

        return peek10();
    }
    
    public String cursorRight(int k) {
        for(int i = 0; i < k; i++){
            if(next.isEmpty()) break;
            prev.push(next.pop());
        }

        return peek10();
    }

    public String peek10(){
        StringBuilder sb = new StringBuilder(10);

        int count = 0;
        while(count++ < 10 && !prev.isEmpty()){
            sb.append(prev.pop());
        }

        for(int i = sb.length() - 1; i >= 0; i--){
            prev.push(sb.charAt(i));
        }
        
        return sb.reverse().toString();
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
