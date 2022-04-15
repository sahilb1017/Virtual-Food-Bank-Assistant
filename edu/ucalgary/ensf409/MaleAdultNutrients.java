package edu.ucalgary.ensf409;
public class MaleAdultNutrients extends Nutrients{

    private final static int CLIENTID = 1;
    private int numMales;

    public MaleAdultNutrients(int amount){
        this.numMales = amount;
        findInfoFromDataBase();
    }

    public int getNumMales(){
        return this.numMales;
    }

    public void setNumMales(int amount){
        this.numMales = amount;
    }

    public int getClientId(){
        return MaleAdultNutrients.CLIENTID;
    }

    protected void findInfoFromDataBase(){
        this.setFruitsVeggies(200 * numMales);
        this.setWholeGrain(200* numMales);
        this.setother(200* numMales);
        this.setProtein(200* numMales);
    }

}
