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
        Database db = this.getDB();
        int[] values = db.getClientNeeds(MaleAdultNutrients.CLIENTID);

        this.setWholeGrain(((double)values[0] / 100) * values[4]* numMales * 7);
        this.setFruitsVeggies(((double)values[1] / 100) * values[4]* numMales * 7);
        this.setProtein(((double)values[2] / 100) * values[4]* numMales * 7);
        this.setOther(((double)values[3] / 100) * values[4]* numMales * 7);
        this.setCalories(values[4]);
        db.close();
    }
}
