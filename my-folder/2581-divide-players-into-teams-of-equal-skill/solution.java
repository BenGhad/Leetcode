class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int skillIssue = skill[0] + skill[skill.length - 1];
        long chem = 0;
        for(int i = 0; i < skill.length / 2; i++){
            if(skill[i] + skill[skill.length - 1 -i ] != skillIssue){
                return -1;
            }
            chem += skill[i] * skill[skill.length - 1 - i];
        }

        return chem;
    }
}
