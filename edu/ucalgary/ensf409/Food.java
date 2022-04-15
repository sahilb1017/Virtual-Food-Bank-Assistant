package edu.ucalgary.ensf409;

public class Food extends Nutrients{
    private final String ITEMNAME;
    private final int ITEMID;

    public Food(int ItemID,String ItemName, double grain, double fv, double protein, double other, double calories){
        this.setWholeGrain(( grain / 100) * calories);
        this.setFruitsVeggies((fv / 100) * calories);
        this.setProtein((protein / 100) * calories);
        this.setOther((other / 100) * calories);
        this.setCalories(calories);
        this.ITEMID = ItemID;
        this.ITEMNAME = ItemName;
    }

    public int getItemID(){
        return ITEMID;
    }

    public String getItemName(){
        return ITEMNAME;
    }

    protected void findInfoFromDataBase(){
        
    }
}
