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
        this.setFruitsVeggies(100 * numChildOver8);
        this.setWholeGrain(100 * numChildOver8);
        this.setother(100 * numChildOver8);
        this.setProtein(100 * numChildOver8);
    }
}