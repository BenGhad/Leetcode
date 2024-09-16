class Solution {
    public int findMinDifference(List<String> timePoints) {
        int s = timePoints.size();
        if(s > 1440){return 0;}

        int[] minutes = new int[1440];
        int[] array = new int[s];

        for(int i = 0; i < s; i++){
            int minutia = convert(timePoints.get(i));
            if(minutes[minutia] == 1){return 0;}
            minutes[minutia]++;
        }
        int prev = -1;
        for(int i = 0; i < minutes.length; i++){
            if(minutes[i] == 1){
                prev = i;
                break;
            }
        }
        int first = prev; 
        int last = -1;
        
        
        int difference = Integer.MAX_VALUE;
        
        for(int i = prev + 1; i < minutes.length; i++){
            if(minutes[i] != 0){
                difference = Math.min(difference, i - prev);
                prev = i;     
                last = i; 
            }
        }
        
        return Math.min(difference, 1440 - last + first);
    }
    public int convert(String time){
        int hour = Integer.parseInt(time.substring(0, 2));
        return hour * 60 + Integer.parseInt(time.substring(3));
    }
}
