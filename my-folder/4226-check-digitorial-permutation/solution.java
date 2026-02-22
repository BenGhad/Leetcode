class Solution {
    public boolean isDigitorialPermutation(int n) {
        int[] freq = new int[10];
        int ans = 0;
        while(n > 0){
            int dig = n % 10;
            freq[dig]++;
            n /= 10;
            ans += fac(dig);
        }

        while(ans > 0){
            int dig = ans % 10;
            freq[dig]--;
            if(freq[dig] < 0) return false;
            ans /= 10;
        }

        for(int f : freq){
            if(f != 0) return false;
        }
        return true;

        
    }

    public int fac(int n){
        int ans = 1;
        while(n > 0){
            ans *= n;
            n--;
        }
        return ans;
    }
}
