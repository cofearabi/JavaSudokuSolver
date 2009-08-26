class Sudoku {
    private Solver solver;
    
    /**
     * Takes a string and parses it into a sudoku board,
     * which is then solved.
     */
    Sudoku(String input) {
        this.solver = new Solver(new Board(parseInput(input)));
        
        System.out.println("Solving:");
        System.out.println(this.solver.getBoard());
        
        boolean solved = this.solver.solve();
        if(solved) {
            System.out.println("Solution:");
            System.out.println(this.solver.getBoard());            
        } else {
            System.out.println("No solution found! :(");
        }
    }
    
    /**
     * Parse the input string as a sudoku board.
     */
    private int[][] parseInput(String input) {
        String[] s = input.split(" ");
        int[][] data = new int[9][9];
        
        int j = 0;
        for(int i=0; i<s.length; i++) {
            data[i%9][j] = Integer.parseInt(s[i]);
            if((i+1) % 9 == 0) j++;
        }
        return data;
    }
    
    /**
     * Testing.
     */
    public static void main(String args[]) {
        String test1 = 
            "0 0 7 0 6 0 4 0 0 " +
            "5 0 0 4 0 7 0 0 8 " +
            "0 1 0 8 0 3 0 2 0 " +
            "0 6 2 7 0 9 3 4 0 " +
            "1 0 0 0 0 0 0 0 7 " +
            "0 3 9 5 0 4 2 6 0 " +
            "0 9 0 2 0 8 0 7 0 " +
            "2 0 0 9 0 5 0 0 6 " +
            "0 0 5 0 7 0 8 0 0";  
        
        String test2 = 
            "0 0 8 0 3 2 0 0 6 " +
            "0 0 0 0 0 0 2 3 0 " +
            "1 3 0 0 0 0 0 5 0 " +
            "0 8 3 0 4 0 6 7 0 " +
            "0 0 0 0 1 5 0 0 0 " +
            "9 1 0 7 0 8 3 0 0 " +
            "3 0 0 0 0 0 9 1 0 " + 
            "0 0 9 1 2 4 5 0 0 " +
            "0 2 0 9 0 0 0 0 8";
                
        String test3 = 
            "0 0 0 0 0 0 0 0 0 " +
            "0 0 0 0 0 0 0 0 0 " +
            "0 0 0 0 0 0 0 0 0 " +
            "0 0 0 0 0 0 0 0 0 " +
            "0 0 0 0 0 0 0 0 0 " +
            "0 0 0 0 0 0 0 0 0 " +
            "0 0 0 0 0 0 0 0 0 " + 
            "0 0 0 0 0 0 0 0 0 " +
            "0 0 0 0 0 0 0 0 0";
                    
        new Sudoku(test1);
        new Sudoku(test2);
        new Sudoku(test3);
    }
}