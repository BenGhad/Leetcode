class LUPrefix {
    int longest;
    int n;
    boolean[] uploads;
    public LUPrefix(int n) {
        uploads = new boolean[n];
        this.n = n;
    }
    
    public void upload(int video) {
        video--; // BOI TS SO 0 INDEXED

        uploads[video] = true;
        while(longest < n && uploads[longest]) longest++;
    }
    
    public int longest() {
        return longest;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */
