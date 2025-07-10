class Solution {
    public int getLucky(String s, int k) {
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - 'a' + 1;
            num += luckNum(c);
        }

        for(int i = 1; i < k; i++){
            num = luckNum(num);
        }

        return num;
    }

    public int luckNum(int n){
        int ans = 0;
        while(n > 0){
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }
}
