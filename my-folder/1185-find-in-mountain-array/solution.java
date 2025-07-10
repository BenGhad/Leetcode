/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    MountainArray marr;
    int length;
    int target;
    
    int[] arr; // avoid recompute

    public int findInMountainArray(int t, MountainArray mountainArr) {
        marr = mountainArr;
        target = t;
        length = marr.length();
        
        arr = new int[length];
        Arrays.fill(arr, -1);
        
        int peak = findPeak();

        int left = searchLeft(0, peak);
        if(left != -1) return left;

        int right = searchRight(peak + 1, length - 1);
        if(right != -1) return right;

        return -1;
    }

    int findPeak(){
        int l = 0;
        int r = length - 1;
        
        while(l < r){
            int m = l + (r - l) / 2;
            int mid = get(m);

            if(mid < get(m + 1)){
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        return l;
    }

    public int searchLeft(int l, int r){
        while(l <= r){
            int m = l + (r - l) / 2;
            
            if(get(m) == target){
                return m;
            } else if(get(m) < target){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public int searchRight(int l, int r){
        while(l <= r){
            int m = l + (r - l) / 2;
            
            if(get(m) == target){
                return m;
            } else if(get(m) > target){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    

    public int get(int idx){
        if(arr[idx] != -1) return arr[idx];
        arr[idx] = marr.get(idx);
        return arr[idx];
    }
}
