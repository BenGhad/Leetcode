class SmallestInfiniteSet {
    int smallest;
    int[] set;
    public SmallestInfiniteSet() {
        set = new int[1001];
        smallest = 1;
    }
    
    public int popSmallest() {
        set[smallest] = 1;
        int ans = smallest;
        while(smallest <= 1000 && set[smallest] == 1){
            smallest++;
        }

        return ans;
    }
    
    public void addBack(int num) {
        if(set[num] == 1) set[num] = 0;
        if(num < smallest) smallest = num;
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
