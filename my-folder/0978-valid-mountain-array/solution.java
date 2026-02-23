class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3 || arr[1] <= arr[0]) return false;
        boolean inc = true;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == arr[i - 1]) return false;
            if(inc){
                if(arr[i] < arr[i-1]) inc = false;
            } else {
                if(arr[i] > arr[i-1]) return false;
            }
        }

        return !inc;
    }
}
