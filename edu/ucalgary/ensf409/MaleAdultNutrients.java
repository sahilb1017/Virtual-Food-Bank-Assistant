package edu.ucalgary.ensf409;

public class MaleAdultNutrients extends Nutrients{

    private final static int ClientId = 1;
    private int numMales;

    public MaleAdultNutrients(int amount){

        setNumMales(amount);
        findInfoFromDataBase();

    }

    public int getNumMales(){
        return this.numMales;
    }
    public void setNumMales(int amount){
        this.numMales = amount;
    }

    public int getClientId(){
        return MaleAdultNutrients.ClientId;
    }


    protected void findInfoFromDataBase(){

        this.setFV(200);
        this.setWholeGrain(200);
        this.setother(200);
        this.setProtein(200);

    }

    
}
