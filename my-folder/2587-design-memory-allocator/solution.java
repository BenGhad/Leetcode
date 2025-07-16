class Allocator {
    int[] mem; //mem[i] == id
    int n;
    public Allocator(int n) {
        mem = new int[n];
        this.n = n;
    }
    
    public int allocate(int size, int mID) {
        int l = 0;
        for(int r = 0; r < n; r++){
            if(mem[r] != 0) l = r + 1;

            if(r - l + 1 >= size){
                Arrays.fill(mem, l, r + 1, mID);
                return l;
            }
        }


        return -1;
    }
    
    public int freeMemory(int mID) {
        int count = 0;
        for(int i = 0; i < n; i++){
            if(mem[i] == mID){
                count++;
                mem[i] = 0;
            }
        }
        return count;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */
