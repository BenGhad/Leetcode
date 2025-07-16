class FrequencyTracker {
    int[] freq = new int[100001];
    int[] freqFreq = new int[100001];

    public FrequencyTracker() {
        freqFreq[0] = 100001;
    }
    
    public void add(int number) {
        int old = freq[number]++;
        freqFreq[old]--;
        freqFreq[old + 1]++;
    }
    
    public void deleteOne(int number) {
        int old = freq[number];
        if(old == 0) return;
        freq[number]--;
        freqFreq[old]--;
        freqFreq[old - 1]++;
    }
    
    public boolean hasFrequency(int frequency) {
        return freqFreq[frequency] > 0;
    }

}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
