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
        this.setFruitsVeggies(50 * numChildUnder8);
        this.setWholeGrain(50 * numChildUnder8);
        this.setother(50 * numChildUnder8);
        this.setProtein(50 * numChildUnder8);
    }
}
