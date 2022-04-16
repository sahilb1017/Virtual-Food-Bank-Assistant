/**
@author Sahil Bhatt
@author Harshal Patel
@author Siwon Kim
@author Abhiraam Manchiraju    

<a href="mailto:sahil.bhatt@ucalgary.ca"> sahil.bhatt@ucalgary.ca</a>
<a href="mailto:harshal.patel@ucalgary.ca"> harshal.patel@ucalgary.ca</a>
<a href="mailto:siwon.kim@ucalgary.ca"> siwon.kim@ucalgary.ca</a>
<a href="mailto:abhiraam.manchiraju@ucalgary.ca"> abhiraam.manchiraju@ucalgary.ca</a>

@version 2.1
@since 1.0
*/

package edu.ucalgary.ensf409;
/**
 * This class is  an extention of Nutrients and is used for retreiving items from the database and 
 * creating an object with their nutrtional content information.
*/
public class Food extends Nutrients{
    private final String ITEMNAME;
    private final int ITEMID;

    /**
     * This constructor takes in the item ID, item name, and all nutritional info of a certain item in the database
     * and creates an object with the nutrtional content information stored, while converting the values from calorie
     * percentage to raw values.
     * @param ItemID The identification number of an item in the database.
     * @param ItemName The name of an item in the database.
     * @param grain The grain content of an item in the database, in terms of caloric percentage.
     * @param fv The fruits and veggies content of an item in the database, in terms of caloric percentage.
     * @param protein The protein content of an item in the database, in terms of caloric percentage.
     * @param other -The other nutrtional content of an item in the database, in terms of caloric percentage.
     * @param calories The caloric content of an item in the database.
    */ 
    public Food(int ItemID,String ItemName, double grain, double fv, double protein, double other, double calories){
        //Converting the nutrional contents from a percentage to a doube, and setting the item id and name
        this.setWholeGrain(( grain / 100) * calories);
        this.setFruitsVeggies((fv / 100) * calories);
        this.setProtein((protein / 100) * calories);
        this.setOther((other / 100) * calories);
        this.setCalories(calories);
        this.ITEMID = ItemID;
        this.ITEMNAME = ItemName;
    }


    /**
     * This method returns the item ID of an item in the database.
     * @param none
    */
    public int getItemID(){
        return ITEMID;
    }


    /**
     * This method returns the item name of an item in the database.
     * @param none
    */
    public String getItemName(){
        return ITEMNAME;
    }


    /**
     * This method retrieves the nutrional info of an item in the database.
    */	
    protected void findInfoFromDataBase(){}
}//End of Class Declaration
