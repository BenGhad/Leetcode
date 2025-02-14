class ProductOfNumbers {
    List<Integer> prefix = new ArrayList<Integer>();
    public ProductOfNumbers() {
        prefix.add(1);
    }
    
    public void add(int num) {
        if(num == 0) {
            prefix = new ArrayList<Integer>();
            prefix.add(1);
        } else {
            prefix.add(prefix.get(prefix.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        if(k >= prefix.size()) return 0;
        int s = prefix.size();
        return prefix.get(s - 1) / prefix.get(s - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
