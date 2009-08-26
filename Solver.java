import java.util.ArrayList;

public class Solver {
    private Board b;
    
    public Solver(Board b) { this.b = b; }
    public Board getBoard() { return b; }
    
    public boolean solve() {
        int x = 0;
        int y = 0;
        boolean backtrack = false;
        
        while(inBounds(x,y)) {
            if(!backtrack && b.getVal(x,y) == 0) {
                backtrack = forward(x,y,backtrack);
            } else {
                backtrack = backtrack(x,y,backtrack);
            }
            
            int oldX = x;
            int oldY = y;
            if(backtrack) {
                x = prevX(oldX,oldY);
                y = prevY(oldX,oldY);
            } else {
                x = nextX(oldX,oldY);
                y = nextY(oldX,oldY);
            }
        }
        return b.isSolved();
    }
    
    private boolean backtrack(int x, int y, boolean bt) {
        if(b.getCell(x,y).multiple()) {
            b.getCell(x,y).removeVal();
            return false;
        }
        if(!b.getCell(x,y).isSafe())
            b.getCell(x,y).setVal(0);
        
        return bt;     
    }
    
    private boolean forward(int x, int y, boolean bt) {
        ArrayList<Integer> poss = b.possibleCellValues(x,y);
        if(poss.isEmpty()) {
            return true;
        } else {
            b.getCell(x,y).setVals(poss);
        }
        return bt;
    }
    
    private boolean inBounds(int x, int y) {
        return x > -1 && y > -1 && x < 9 && y < 9;
    }
        
    private int nextX(int x, int y) { return nextPos(x,y)[0]; }
    private int nextY(int x, int y) { return nextPos(x,y)[1]; }
    private int prevX(int x, int y) { return prevPos(x,y)[0]; }
    private int prevY(int x, int y) { return prevPos(x,y)[1]; }
    
    private int[] nextPos(int x, int y) {
        if((x+1) % 9 == 0) {
            y++;
            x = 0;
        } else {
            x++;
        }
        int[] a = { x,y };
        return a;
    }
    
    private int[] prevPos(int x, int y) {
        if(x == 0) {
            y--;
            x = 8;
        } else {
            x--;
        }
        int[] a = { x,y };
        return a;
    }
}