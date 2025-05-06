class Solution {
    public boolean asteroidsDestroyed(int m, int[] asteroids) {
        Arrays.sort(asteroids);
        long mass = m;
        for(int ass : asteroids){
            if(ass > mass) return false;
            mass += ass;
        }   
        return true;
    }
}
