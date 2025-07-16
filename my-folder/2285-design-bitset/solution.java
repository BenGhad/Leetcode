class Bitset {
    int ones;
    boolean[] bits;
    int n;
    boolean flipped; // Makes flip() O(1) but also makes my code look ugly 

    public Bitset(int size) {
        bits = new boolean[size];
        n = size;
    }
    
    public void fix(int idx) {
        if(!bits[idx] ^ flipped){
            bits[idx] ^= true;
            ones++;
        } 
    }
    
    public void unfix(int idx) {
        if(bits[idx] ^ flipped){
            bits[idx] ^= true;
            ones--;
        }
    }
    
    public void flip() {
        flipped ^= true;
        ones = n - ones;
    }
    
    public boolean all() {
        return ones == n;
    }
    
    public boolean one() {
        return ones > 0;
    }
    
    public int count() {
        return ones;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(bits[i] ^ flipped ? "1" : "0");
        }
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */
