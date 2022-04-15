package edu.ucalgary.ensf409;

public class ChildUnder8Nutrients extends Nutrients{
    private final static int CLIENTID = 4;
    private int numChildUnder8;

    public ChildUnder8Nutrients(int amount){
        this.numChildUnder8 = amount;
        findInfoFromDataBase();
    }

    public int getNumChildUnder8(){
        return this.numChildUnder8;
    }

    public void setNumChildUnder8(int amount){
        this.numChildUnder8 = amount;
    }

    public int getClientId(){
        return ChildUnder8Nutrients.CLIENTID;
    }

    protected void findInfoFromDataBase(){
        Database db = this.getDB();
        int[] values = db.getClientNeeds(ChildUnder8Nutrients.CLIENTID);

        this.setWholeGrain(((double)values[0] / 100) * values[4]* numChildUnder8 * 7);
        this.setFruitsVeggies(((double)values[1] / 100) * values[4]* numChildUnder8 * 7);
        this.setProtein(((double)values[2] / 100) * values[4]* numChildUnder8 * 7);
        this.setOther(((double)values[3] / 100) * values[4]* numChildUnder8 * 7);
        this.setCalories(values[4]);
        db.close();
    }
}
