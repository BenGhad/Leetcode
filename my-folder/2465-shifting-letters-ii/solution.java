class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int how_much_poop = s.length();
        int[] shitty = new int[how_much_poop + 1];

        for(int[] shit : shifts){
            int startShitting = shit[0];
            int endShitting = shit[1];
            int whereShitting = shit[2];
            if(whereShitting == 1){
                shitty[startShitting] += 1;
                shitty[endShitting + 1] -= 1;
            } else {
                shitty[startShitting] -= 1;
                shitty[endShitting + 1] += 1;
            }
        }

        int howMuchShit = 0;
        StringBuilder shit = new StringBuilder();
        for(int i = 0 ; i < how_much_poop; i++){
            char poop = s.charAt(i);
            howMuchShit = (howMuchShit + shitty[i]);
            int peepee = (poop - 'a' + howMuchShit) % 26;
            if(peepee < 0) peepee += 26;
            shit.append((char)(peepee + 'a'));
        }
        return shit.toString();
    }
}
