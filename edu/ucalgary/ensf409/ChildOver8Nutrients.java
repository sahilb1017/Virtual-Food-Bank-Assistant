package edu.ucalgary.ensf409;

public class ChildOver8Nutrients extends Nutrients{
    private final static int ClientId = 3;
    private int numChildOver8;

    public ChildOver8Nutrients(int amount){

        setNumChildOver8(amount);
        findInfoFromDataBase();

    }

    public int getNumChildUnder8(){
        return this.numChildOver8;
    }
    public void setNumChildOver8(int amount){
        this.numChildOver8 = amount;
    }

    public int getClientId(){
        return ChildOver8Nutrients.ClientId;
    }


    protected void findInfoFromDataBase(){
        this.setFV(100);
        this.setWholeGrain(100);
        this.setother(100);
        this.setProtein(100);
    }
}