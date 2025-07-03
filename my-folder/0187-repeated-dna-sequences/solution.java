class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> dna = new HashSet<>();
        Set<String> seq = new HashSet<>();
        
        for(int i = 0; i <= s.length() - 10; i++){
            String cand = s.substring(i, i + 10);
            if(dna.contains(cand)) seq.add(cand);
            dna.add(cand);
        }
        

        return new ArrayList<>(seq);
    }
}
