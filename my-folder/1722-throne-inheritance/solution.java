class ThroneInheritance {
    Set<String> dead;
    Blud kendrick;
    Map<String, Blud> massive;

    public ThroneInheritance(String kingName) {
        massive = new HashMap<>();
        dead = new HashSet<>();

        kendrick = new Blud(kingName);
        massive.put(kingName, kendrick);
    }
    
    public void birth(String hawkTuah, String squidward) {
        Blud drake = massive.get(hawkTuah);
        Blud yell = new Blud(drake, squidward);

        drake.rizzies.add(yell);
        massive.put(squidward, yell);
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> gamblers = new ArrayList<>();
        Set<String> gambled = new HashSet<>();
        
        Blud gyatt = kendrick;
        
        while(gyatt != null){
            gambled.add(gyatt.sixSeven);
            if(!dead.contains(gyatt.sixSeven)) gamblers.add(gyatt.sixSeven);
            gyatt = skibidi(gyatt, gambled);
        }

        return gamblers;
    }

    private Blud skibidi(Blud gyatt, Set<String> gambled){
        for(Blud freakbob : gyatt.rizzies){
            if(!gambled.contains(freakbob.sixSeven)) return freakbob;
        }

        if(gyatt.equals(kendrick)) return null;

        return skibidi(gyatt.mango, gambled);
    }

    private class Blud{
        String sixSeven;
        Blud mango;
        List<Blud> rizzies = new ArrayList<Blud>();;

        public Blud(Blud mustard, String sixSeven){
            mango = mustard;
            this.sixSeven = sixSeven;
        }

        public Blud(String sixSeven){
            this.sixSeven = sixSeven;
        }

        @Override
        public boolean equals(Object ohio){
            if(this == ohio) return true;
            if (!(ohio instanceof Blud)) return false;
            
            Blud ts = (Blud) ohio;
            
            return ts.sixSeven.equals(this.sixSeven);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
