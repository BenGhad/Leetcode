class Solution {
    public int getKth(int lo, int hi, int k) {
        int n = hi - lo + 1;
        int[][] power = new int[n][2]; // {power, val}

        for(int i = 0; i < n; i++){
            power[i][1] = lo + i;
        }

        for(int[] num : power){
            int p = num[0];
            int val = num[1];
            if(p == 0){
                num[0] = calcPow(val, power, lo, hi);
            } else {
                if(val * 2 <= hi){
                    power[val * 2 - lo][0] = p + 1;
                } 
                if(val - 1 % 3 == 0){
                    power[(val - 1) / 3][0] = p + 1;
                }
            }
        }

        /*
        for(int[] pow : power){
            System.out.println(pow[0] + " " + pow[1]);
        }
        */


        Arrays.sort(power, (x, y) -> Integer.compare(x[0], y[0]));
        return power[k - 1][1];
    }

    int calcPow(int n, int[][] power, int lo, int hi){
        // base case:
        if(n == 1) return 0;
        if(n >= lo && n <= hi && power[n - lo][0] != 0) return power[n - lo][0];

        if(n % 2 == 0) return calcPow(n / 2, power, lo, hi) + 1;

        return calcPow(3 * n + 1, power, lo, hi) + 1;
    }
}
