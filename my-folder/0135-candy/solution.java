class Solution {
    public int candy(int[] ratings) {
        int c = 0;
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]){
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            } 
        }
        
        //Right to left:
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            } 
        }


        for(int i = 0; i < candy.length; i++){
            c += candy[i];
        }


        return c;

    }
}
