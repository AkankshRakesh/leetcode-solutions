class Spreadsheet {
    HashMap<Character, HashMap<Integer, Integer>> hm = new HashMap<>();
    public Spreadsheet(int rows) {
        
    }
    
    public void setCell(String cell, int value) {
        char col = cell.charAt(0);
        if(!hm.containsKey(col)) hm.put(col, new HashMap<Integer, Integer>());
        HashMap<Integer, Integer> rows = hm.get(col);
        int row = 0;
        for(int i = 1; i < cell.length(); i++){
            row *= 10;
            row += (cell.charAt(i) - '0');
        }

        rows.put(row, value);
    }
    
    public void resetCell(String cell) {
        char col = cell.charAt(0);
        if(!hm.containsKey(col)) hm.put(col, new HashMap<Integer, Integer>());
        HashMap<Integer, Integer> rows = hm.get(col);
        int row = 0;
        for(int i = 1; i < cell.length(); i++){
            row *= 10;
            row += (cell.charAt(i) - '0');
        }

        rows.put(row, 0);
    }
    
    public int get(StringBuilder sb){
        int res = 0;
        if(sb.charAt(0) >= 'A' && sb.charAt(0) <= 'Z'){
            char col = sb.charAt(0);
            if(hm.containsKey(col)){
                HashMap<Integer, Integer> rows = hm.get(col);
                int row = 0;
                for(int i = 1; i < sb.length(); i++){
                    row *= 10;
                    row += (sb.charAt(i) - '0');
                }

                if(rows.containsKey(row)) res = rows.get(row);
            }
        }
        else res = Integer.parseInt(sb.toString());

        return res;
    }

    public int getValue(String formula) {
        StringBuilder x = new StringBuilder();
        int i = 1;
        for(i = 1; formula.charAt(i) != '+'; i++) x.append(formula.charAt(i));
        
        i++;
        StringBuilder y = new StringBuilder();
        for(; i < formula.length(); i++) y.append(formula.charAt(i));

        int xVal = get(x);
        int yVal = get(y);
        return xVal + yVal;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */