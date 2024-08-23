/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
       int ans = 0;
       int low = 1;
       int high = n;
       boolean logged = true;
       while(logged){
        if(high < low){
            break;
        }

        int mid = low + (high - low) / 2;

        if(isBadVersion(mid)){
            high = mid - 1;
            ans = mid;
        } else {
            low = mid + 1;
        }
        
       }

       return ans;
    }
}
