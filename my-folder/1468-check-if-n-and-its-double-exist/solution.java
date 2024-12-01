class Solution {
    public boolean checkIfExist(int[] arr) {
        int[] v = new int[2001];
        for(int i : arr){
            if(Math.abs(i) <= 500){
                int high = 2 * i;
                if(v[high + 1000] == 1){
                    return true;
                }
            }
            if(i % 2 == 0){
                int low = i / 2;
                if(v[low + 1000] == 1){
                    return true;
                }
            }
            v[i + 1000] = 1;
        }
        return false;
    }
}
