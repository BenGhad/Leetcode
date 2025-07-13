class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int count = 0;
        int t = 0;

        for(int i = 0; i < players.length; i++){
            while(t < trainers.length && trainers[t] < players[i]){
                t++;
            }
            if(t < trainers.length && trainers[t++] >= players[i]){
                count++;
            }
        }
        return count;
    }
}
