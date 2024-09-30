class CustomStack {
    private int[] stacky;
    int top = -1;
    public CustomStack(int maxSize) {
        stacky = new int[maxSize];
    }
    
    public void push(int x) {
        if(top != stacky.length - 1){
            top++;
            stacky[top] = x;
        }
    }
    
    public int pop() {
        if(top == -1){
            return -1;
        } else {
            top--;
            return stacky[top + 1];
        }
    }
    
    public void increment(int k, int val) {
        for(int i = 0; i < k && i <= top; i++){
            stacky[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
