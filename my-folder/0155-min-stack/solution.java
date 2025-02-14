class MinStack {
    Stack<Integer> list = new Stack<>();
    Stack<Integer> mins = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(mins.isEmpty() || val <= mins.peek()){
            mins.push(val);
        }
        list.push(val);
    }
    
    public void pop() {
        if(list.pop() <= mins.peek()) mins.pop();
    }
    
    public int top() {
        return list.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
