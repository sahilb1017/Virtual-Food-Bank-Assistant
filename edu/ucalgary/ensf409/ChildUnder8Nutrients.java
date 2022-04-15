package edu.ucalgary.ensf409;

public class ChildUnder8Nutrients extends Nutrients{
    private final static int ClientId = 4;
    private int numChildUnder8;

    public ChildUnder8Nutrients(int amount){

        setNumChildUnder8(amount);
        findInfoFromDataBase();

    }

    public int getNumChildUnder8(){
        return this.numChildUnder8;
    }
    public void setNumChildUnder8(int amount){
        this.numChildUnder8 = amount;
    }

    public int getClientId(){
        return ChildUnder8Nutrients.ClientId;
    }


    protected void findInfoFromDataBase(){
        
    }
}
