class Solution {
    public int hIndex(int[] citations) {
        int low = 0;
        int high = citations.length - 1;
        int h = 0;
        if(citations[high] == 0){return 0;}        

        while(low <= high){
            int mid = low + (high - low) / 2; 
            h = citations.length - mid; 
            if(citations[mid] == h){
                return h;
            }
            if(citations[mid] > h){
                high = mid - 1;
            }
            if(citations[mid] < h){
                low = mid + 1;
            }
        }
        return citations.length - low;
    }
}
