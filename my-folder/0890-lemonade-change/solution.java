class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int i : bills){
            if(i == 5) five++;
            if(i == 10) {
                ten++;
                if(five-- < 1) return false;
            }
            
            if(i == 20) {
                if(five == 0) return false;
                if(ten > 0){
                    ten--;
                    five--;
                } else if(five >= 3){
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
