// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> it;
    int pk = -1;

    public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    it = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(pk == -1) pk = it.next();
        return pk;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(pk != -1){
            int ans = pk;
            pk = -1;
            return ans;
        } else {
            return it.next();
        }
	}
	
	@Override
	public boolean hasNext() {
	    if(pk != -1) return true;
        return it.hasNext();
	}
}
