package edu.ucalgary.ensf409;

public class Food extends Nutrients{

    private  String ItemName;
    private  double ItemID;

    public Food(double ItemID,String ItemName){
        this.ItemID = ItemID;
        this.ItemName = ItemName;

    }

    public double getItemID(){
        return ItemID;
    }

    public String getItemName(){
        return ItemName;
    }

    protected void findInfoFromDataBase(){
        
    }

    
    






    
}
