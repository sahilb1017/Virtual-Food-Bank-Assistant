/**
@author Sahil Bhatt
@author Harshal Patel
@author Siwon Kim
@author Abhiraam Manchiraju    

<a href="mailto:sahil.bhatt@ucalgary.ca"> sahil.bhatt@ucalgary.ca</a>
<a href="mailto:harshal.patel@ucalgary.ca"> harshal.patel@ucalgary.ca</a>
<a href="mailto:siwon.kim@ucalgary.ca"> siwon.kim@ucalgary.ca</a>
<a href="mailto:abhiraam.manchiraju@ucalgary.ca"> abhiraam.manchiraju@ucalgary.ca</a>

@version 2.3
@since 1.0
*/
package edu.ucalgary.ensf409;

import java.util.*;
/**
*This class will print the order form 
*/
public class Order {
    
    private ArrayList<Hamper> hampers = new ArrayList<Hamper>();
    private ArrayList<Food> availableFood = new ArrayList<Food>();

    /**
     * Constructor for the Order object
     * Will gather all the availible foods from the dataBase and put it it into an arrayList of Food Objects
     * @param none
    */
    public Order(){
        Database db = new Database();
        availableFood = db.getAvailableFood();
        db.close();
    }

    /**  
     * Method to add Hamper objects to the order
     * @param list An int array holding the information of the configurations of the desired hamper, index 0 for number of adult Males, index 1 for number of adult females,
     * index 2 for the numer of children over 8 and index 3 for the number of children under 8
    */
    public void addHamper(int[] list) throws NotEnoughFoodException{
        hampers.add(new Hamper(list, availableFood));
        ArrayList<ArrayList<String>> tempList = hampers.get(hampers.size() - 1).getInventory().getAllFood();
        removeFoodsLocal(tempList);
    }

    /**
     * Method to return the ArrayList of Hampers 
     * @param none
    */
    public ArrayList<Hamper> getHampers(){
        return this.hampers;
    }

    /**
     * Method to set hamper
     * @param hampers The new hampers list to replace 
    */
    public void setHampers(ArrayList<Hamper> hampers){
        this.hampers = hampers;
    }

    /** 
    *Method to get hamper at a specific index
    *@param index The index from the hamper arraylist that should be returned
    */
    public Hamper getHamper(int index){
        return this.hampers.get(index);    
    }

    /**
    *Method to remove food object from arraylist of availible foods locally after those food objects get added to hamper
    *@param foods The most recend hamper made from the program
    */
    public void removeFoodsLocal(ArrayList<ArrayList<String>> foods){
        for(int i = 0; i < foods.size(); i++){
            int key = Integer.parseInt(foods.get(i).get(1));
            for(int j = 0; j < this.availableFood.size(); j++){
                int curr = this.availableFood.get(j).getItemID();

                if(key == curr)
                    this.availableFood.remove(j);
            }
        }
    }
    
    /**
    * Method to remove food from the data base after the order is completed
    * @param none
    */
    public void removeFoodsDatabase(){
        Database db = new Database();

        //Loop that calls upon the deletion method to delete all the food items that were used
        for(int i = 0; i < hampers.size(); i++){
            ArrayList<ArrayList<String>> temp = hampers.get(i).getInventory().getAllFood();
            for(int j = 0; j < temp.size(); j++){
                db.deleteUsedFoods(Integer.parseInt(temp.get(j).get(1)));
            }
        }
    }
}
