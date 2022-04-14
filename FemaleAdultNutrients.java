package edu.ucalgary.ensf409;

public class FemaleAdultNutrients extends Nutrients{
    
    private final static int ClientId = 2;
    private int numFemales;

    public FemaleAdultNutrients(int amount){

        setNumFemale(amount);
        findInfoFromDataBase();

    }

    public int getNumFemale(){
        return this.numFemales;
    }
    public void setNumFemale(int amount){
        this.numFemales = amount;
    }

    public int getClientId(){
        return FemaleAdultNutrients.ClientId;
    }


    protected void findInfoFromDataBase(){
        this.setFV(150);
        this.setWholeGrain(150);
        this.setother(150);
        this.setProtein(150);

    }

    
}

