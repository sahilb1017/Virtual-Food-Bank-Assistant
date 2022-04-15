package edu.ucalgary.ensf409;

public class Food extends Nutrients{

    private final String ITEMNAME;
    private final int ITEMID;

    public Food(int ItemID,String ItemName){
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
