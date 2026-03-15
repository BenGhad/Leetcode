class MyCircularDeque {
    int[] arr;
    int l;
    int r;
    int size;
    int k;
    public MyCircularDeque(int k) {
        arr = new int[k];
        l = 0; // can insert at L
        r = 0; // can insert at R + 1
        size = 0;
        this.k = k;
    }
    
    public boolean insertFront(int value) {
        if(size == arr.length) return false;
        arr[l] = value; 
        l = ((l - 1) + k) % k;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size == arr.length) return false;
        
        int rp = (r + 1) % k;

        arr[rp] = value;
        r = rp;

        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(size == 0) return false;
        l = (l + 1) % k;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(size == 0) return false;
        r = ((r - 1) + k) % k;
        size--;
        return true;
    }
    
    public int getFront() {
        return size == 0 ? -1 : arr[(l + 1) % k];
    }
    
    public int getRear() {
        return size == 0 ? -1 : arr[r];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
