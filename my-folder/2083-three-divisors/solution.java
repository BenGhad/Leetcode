class Solution {
    public boolean isThree(int n) {
        int div = 1;
        for(int i = 2; i <= n / 2; i++){
            if(n % i == 0){
                div++;
                if(div > 2){
                    return false;
                }
            }
        }
        return (div == 2);
    }
}
