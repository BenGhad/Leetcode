class TopVotedCandidate {
    List<int[]> queries = new ArrayList<int[]>();
    int[] people = new int[5000];
    
    public TopVotedCandidate(int[] persons, int[] times) {
        // Create History by time
        int n = persons.length;
        //Simulate:
        queries.add(new int[]{0, 0});
        for(int i = 0; i < n; i++){
            int[] prev = queries.get(queries.size() - 1);
            int who = persons[i];
            int when = times[i];
            people[who]++;
            int winner = (people[who] >= people[prev[0]]) ? who : prev[0];
            
            if(when == prev[1]){
                queries.get(queries.size() - 1)[0] = winner;
            } else {
                queries.add(new int[]{winner, when});
            }
        }
    }
    
    public int q(int t) {
        int low = 0;
        int high = queries.size() - 1;
        while(low <= high){
            int mid = (low + high) /2;
            int time = queries.get(mid)[1];
            if(time <= t) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return queries.get(high)[0];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
