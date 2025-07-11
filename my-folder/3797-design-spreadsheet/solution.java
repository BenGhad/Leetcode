class Spreadsheet {
    int[][] grid;
    public Spreadsheet(int rows) {
        grid = new int[26][rows];
    }
    
    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1));

        grid[col][row - 1] = value; 
    }
    
    public void resetCell(String cell) {
        setCell(cell, 0);
    }
    
    public int getValue(String formula) {
        String[] form = formula.split("\\+");
        String x = form[0].substring(1);
        String y = form[1];

        return calc(x) + calc(y);   
    }
    
    private int calc(String x){
        if(Character.isDigit(x.charAt(0))) return Integer.parseInt(x);

        int col = x.charAt(0) - 'A';
        int row = Integer.parseInt(x.substring(1));
        return grid[col][row - 1];
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
