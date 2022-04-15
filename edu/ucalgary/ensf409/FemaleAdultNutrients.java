package edu.ucalgary.ensf409;

public class FemaleAdultNutrients extends Nutrients{
    
    private final static int CLIENTID = 2;
    private int numFemales;

    public FemaleAdultNutrients(int amount){
        this.numFemales = amount;
        findInfoFromDataBase();
    }

    public int getNumFemale(){
        return this.numFemales;
    }

    public void setNumFemale(int amount){
        this.numFemales = amount;
    }

    public int getClientId(){
        return FemaleAdultNutrients.CLIENTID;
    }


    protected void findInfoFromDataBase(){
        this.setFruitsVeggies(150 * numFemales);
        this.setWholeGrain(150* numFemales);
        this.setother(150* numFemales);
        this.setProtein(150* numFemales);

    }

    
}

