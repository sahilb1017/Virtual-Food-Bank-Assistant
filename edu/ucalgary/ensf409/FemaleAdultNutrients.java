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
        Database db = this.getDB();
        int[] values = db.getClientNeeds(FemaleAdultNutrients.CLIENTID);

        this.setWholeGrain(((double)values[0] / 100) * values[4]* numFemales * 7);
        this.setFruitsVeggies(((double)values[1] / 100) * values[4]* numFemales * 7);
        this.setProtein(((double)values[2] / 100) * values[4]* numFemales * 7);
        this.setOther(((double)values[3] / 100) * values[4]* numFemales * 7);
        this.setCalories((double)values[4]);
        db.close();
    }
}

