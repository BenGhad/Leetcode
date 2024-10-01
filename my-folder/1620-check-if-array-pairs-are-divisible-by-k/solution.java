class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] marray = new int[k];
        for(int i = 0; i < arr.length; i++){
            int mod = (arr[i] % k + k) % k;
            marray[mod] = marray[mod] + 1;

        }
        for(int i = 1; i < k; i++){
            if(i == k - i){
                return (marray[i] % 2 == 0);
            }
            if(marray[i] != marray[k-i]){
                return false;
            }
            
        }
        return true;
    }
}
