class MyQueue {
    Stack<Integer> offer;
    Stack<Integer> poll;
    int mode;
    
    public MyQueue() {
        offer = new Stack<>();
        poll = new Stack<>();
        mode = 0;
    }
    
    public void push(int x) {
        if(mode == 1) swp();
        offer.push(x);
        
    }
    
    public int pop() {
        if(mode == 0) swp();
        return poll.pop();
    }
    
    public int peek() {
        if(mode == 0) swp();
        return poll.peek();
    }
    
    public boolean empty() {
        return offer.isEmpty() && poll.isEmpty();
    }
    
    public void swp(){
        if(mode == 0){
            while(!offer.isEmpty()){
                poll.push(offer.pop());
            }  
        } else if(mode == 1){
            while(!poll.isEmpty()){
                offer.push(poll.pop());
            }
        }
        mode = (mode + 1) % 2;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
