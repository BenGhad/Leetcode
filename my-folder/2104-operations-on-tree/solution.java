class LockingTree {
    List<Integer>[] children;
    int[] parent;
    int[] lock;
    public LockingTree(int[] parent) {
        int n = parent.length;
        this.parent = parent;
        
        lock = new int[n];

        children = new ArrayList[n];
        for(int i = 0; i < n; i++) children[i] = new ArrayList<>();
        for(int i = 1; i < n; i++){
            children[parent[i]].add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if(lock[num] == 0){
            lock[num] = user;
            return true;
        }
        return false;
    }
    
    public boolean unlock(int num, int user) {
        if(lock[num] == user){
            lock[num] = 0;
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        if(lock[num] != 0) return false;

        //parents
        for(int par = parent[num]; par != -1; par = parent[par]){
            if(lock[par] != 0) return false;
        }

        // do ts shit
        boolean changed = false;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(num);
        
        while(!q.isEmpty()){
            int thing = q.poll();
            if(lock[thing] != 0) changed = true;
            lock[thing] = 0;

            for(int child : children[thing]){
                q.offer(child);
            }
        }
        if(changed) lock[num] = user;
        return changed;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */
