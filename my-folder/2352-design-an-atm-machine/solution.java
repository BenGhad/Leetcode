class ATM {
    int[] bills = new int[5];
    public ATM() {

    }
    
    public void deposit(int[] banknotesCount) {
        for(int i = 0; i < 5; i++){
            bills[i] += banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int[] billMe = new int[5];

        for (int i = 4; i >= 0; i--) {
            int v = val(i);
            int take = Math.min(amount / v, bills[i]);
            billMe[i] = take;
            amount -= take * v;
        }

        if(amount != 0) return new int[]{-1};

        for(int i = 0; i < 5; i++){
            bills[i] -= billMe[i];
        }
        
        return billMe;
    }

    private int val(int i){
        switch (i){
            case 0: return 20;
            case 1: return 50;
            case 2: return 100;
            case 3: return 200;
            case 4: return 500;
            default: return -1;
        }
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
