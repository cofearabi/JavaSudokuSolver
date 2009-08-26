import java.util.ArrayList;

class Board {
    private Cell[][] data;
    
    /** 
     * Create a new 9x9 board from input matrix.
     */
    public Board(int[][] input) {
        data = new Cell[9][9];
        for(int x=0; x<9; x++) {
            for(int y=0; y<9; y++) {
                data[x][y] = new Cell(input[x][y]);
                if(input[x][y] != 0) data[x][y].setSafe();
            }
        }
                
    }
    
    public Cell getCell(int x, int y) {
        return data[x][y];
    }
    
    public int getVal(int x, int y) {
        return getCell(x,y).getVal();
    }
    
    /**
     * Checks if a board is solved (no zeroes).
     */ 
    public boolean isSolved() {
        for(int x=0; x<9; x++)
            for(int y=0; y<9; y++)
                if(getVal(x,y) == 0)
                    return false;
        return true;
    }
    
    /**
     * Find values to insert in an empty cell.
     */
    public ArrayList<Integer> possibleCellValues(int x, int y) {
        ArrayList<Integer> possibleValues = new ArrayList<Integer>();
        for(int val=1; val<10; val++)
            if(legal(x,y,val))
                possibleValues.add(val);
        return possibleValues;
    }
    
    /**
     * Check if a value is legal to insert in cell.
     */
    private boolean legal(int x, int y, int value) {
        
				// Check valid in row and column
				for (int i=0; i<9; i++)
	        	if (getVal(i,y) == value || getVal(x,i) == value)
		        		return false;
        
				// Find first element in box
	    	int offsetX = (x/3) * 3;
	    	int offsetY = (y/3) * 3;
	    
	    	// Check valid in box
				for (int i=0; i<3; i++)
						for (int j=0; j<3; j++)
								if (getVal(offsetX+i, offsetY+j) == value)
										return false;
        
				// The value is legal
	    	return true;
    }
    
    /**
     * Print the sudoku board.
     */
    public String toString() {
        String line = "-------------------------\n";
        String str = line;
        
        for(int i=0; i<9; i++) {
            str += "| ";
            for(int j=0; j<9; j++) {
                if(getVal(j,i) == 0) { 
                    str += "  ";
                } else { 
                    str += getVal(j,i) + " "; 
                }
                if((j+1) % 3 == 0) str+= "| ";
            }
            str += "\n";
            if((i+1) % 3 == 0) str+= line;
        }
        return str;
    }
}