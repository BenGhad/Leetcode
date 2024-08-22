class Solution {
    public int countTime(String time) {
        int hours = 1;
        if(time.charAt(0) == '?' && time.charAt(1) == '?'){ //??
            hours = 24;
        } else if(time.charAt(0) == '2' && time.charAt(1) == '?'){ //2?
            hours = 4;
        } else if(time.charAt(0) == '?'){
            hours = (Character.getNumericValue(time.charAt(1)) < 4) ? 3 : 2;
        } else if(time.charAt(1) == '?') {
            hours = 10;
        }



        //minutes:
        int minutes = 1;
        if(time.charAt(3) == '?'){
            minutes =  6;
        }
        if(time.charAt(4) == '?'){
            minutes = minutes * 10;
        }

        return minutes * hours;

    }
}
