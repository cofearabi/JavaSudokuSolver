import java.util.ArrayList;

public class Cell {
    
    private ArrayList<Integer> vals;
    private boolean safe;
    
    public Cell(int val) {
        this.vals = new ArrayList<Integer>();
        this.vals.add(val);
    }
    
    public void setSafe() {
        this.safe = true;
    }
    
    public boolean isSafe() {
        return this.safe;
    }
    
    public void setVals(ArrayList<Integer> vals) {
        this.vals.clear();
        for(int val : vals) this.vals.add(val);
    }
    
    public void setVal(int val) {
        this.vals.clear();
        this.vals.add(val);
    }
    
    public int getVal() {
        return vals.get(0);
    }
    
    public void removeVal() {
        vals.remove(0);
    }
    
    public boolean multiple() {
        return vals.size() > 1;
    }
    
    public String toString() {
        return vals.toString();
    }
}
