class RLEIterator {
    int[] enc;
    int idx;
    int ptr;
    public RLEIterator(int[] encoding) {
        enc = encoding;
        idx = 0;
        ptr = 0;
    }
    
    public int next(int n) {
        // enc[idx] = count, enc[idx+1] = val
        while(idx < enc.length){
            if(n > enc[idx] - ptr){
                n -= enc[idx] - ptr;
                ptr = 0;
                idx += 2;
            } else {
                ptr += n;
                return enc[idx+1];
            }
        }
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */
