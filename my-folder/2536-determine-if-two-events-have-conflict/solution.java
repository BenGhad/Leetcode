class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int firstStart = minutes(event1[0]);
        int firstEnd = minutes(event1[1]);
        int secondStart = minutes(event2[0]);
        int secondEnd = minutes(event2[1]);

        if(firstEnd >= secondStart && firstStart <= secondStart){ return true; }
        if(secondEnd >= firstStart && secondStart <= firstStart){ return true;}

        return false;

    }

    public int minutes(String stringy){         //Strategy: Convert to Total minutes. O(1)
        int one = Character.getNumericValue(stringy.charAt(0));   
        int two = Character.getNumericValue(stringy.charAt(1));   
        int three = Character.getNumericValue(stringy.charAt(3));   
        int four = Character.getNumericValue(stringy.charAt(4));   
        
        return (((one * 10) + two) * 60) + (three * 10) + four;
    }

}
