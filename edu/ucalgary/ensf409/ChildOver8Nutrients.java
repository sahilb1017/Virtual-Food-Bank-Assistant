package edu.ucalgary.ensf409;

public class ChildOver8Nutrients extends Nutrients{
    private final static int CLIENTID = 3;
    private int numChildOver8;

    public ChildOver8Nutrients(int amount){
        this.numChildOver8 = amount;
        findInfoFromDataBase();
    }

    public int getNumChildUnder8(){
        return this.numChildOver8;
    }

    
    public void setNumChildOver8(int amount){
        this.numChildOver8 = amount;
    }

    public int getClientId(){
        return ChildOver8Nutrients.CLIENTID;
    }

    protected void findInfoFromDataBase(){
        Database db = this.getDB();
        int[] values = db.getClientNeeds(ChildOver8Nutrients.CLIENTID);

        this.setWholeGrain(((double)values[0] / 100) * values[4]* numChildOver8 * 7);
        this.setFruitsVeggies(((double)values[1] / 100) * values[4]* numChildOver8 * 7);
        this.setProtein(((double)values[2] / 100) * values[4]* numChildOver8 * 7);
        this.setOther(((double)values[3] / 100) * values[4]* numChildOver8 * 7);
        this.setCalories(values[4]);
        db.close();
    }
}