package edu.ucalgary.ensf409;

public class Food {

    private static String ItemName;
    private static int ItemID;

    public Food(int ItemID){
        Food.ItemID = ItemID;
    }

    public int getItemID(){
        return Food.ItemID;
    }

    public String getItemName(){
        return Food.ItemName;
    }

    protected void findInfoFromDataBase(){
        
    }






    
}
