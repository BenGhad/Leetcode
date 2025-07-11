class SnapshotArray {
    int id = 0;
    List<Integer>[] snaps;
    List<Integer>[] ids;
    int n;

    public SnapshotArray(int length) {
        snaps = new ArrayList[length];
        ids = new ArrayList[length];
        n = length;
        for (int i = 0; i < n; i++) {
            snaps[i] = new ArrayList<>();
            snaps[i].add(0);

            ids[i] = new ArrayList<>();
            ids[i].add(0);
        }
    }

    public void set(int index, int val) {
        List<Integer> vals = snaps[index];
        List<Integer> idx = ids[index];

        if (idx.get(idx.size() - 1) == id) { 
            vals.set(vals.size() - 1, val); 
        } else { 
            vals.add(val);
            idx.add(id); 
        }
    }

    
    public int snap() {
        return id++;
    }

    public int get(int index, int snap_id) {
        List<Integer> vals = snaps[index];
        List<Integer> id = ids[index];

        int l = 0;
        int r = id.size() - 1;
        int snapshot = 0;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (id.get(m) <= snap_id) {
                snapshot = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return vals.get(snapshot);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
