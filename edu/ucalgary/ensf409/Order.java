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

public class Order {
    
    private ArrayList<Hamper> hampers = new ArrayList<Hamper>();
    private ArrayList<Food> availableFood = new ArrayList<Food>();

    /*
    Constructor for the Order object
    Will gather all the availible foods from the dataBase and put it it into an arrayList of Food Objects
    */

    public Order(){
        Database db = new Database();
        availableFood = db.getAvailableFood();
        db.close();
    }
    /*    
    Method to add Hamper objects to the order
    @params list , an int array holding the information of the confiuerations of the desired Hamper,index 0 for number of adul tMales, index 1 for number of adult females,
    index 2 for the numer of children over 8 and index 3 for the number of children under 8
    */
    public void addHamper(int[] list) throws ItemNotFoundException, NotEnoughFoodException{
        hampers.add(new Hamper(list, availableFood));
        ArrayList<ArrayList<String>> tempList = hampers.get(hampers.size() - 1).getInventory().getAllFood();
        removeFoodsLocal(tempList);
    }

    /**
    Method to return the ArrayList of Hampers 
    */
    
    public ArrayList<Hamper> getHampers(){
        return this.hampers;
    }

    /*
    Method to set hamper
    @ArrayList<Hamper>, the new hampers list to replace 
    */
 
    public void setHampers(ArrayList<Hamper> hampers){
        this.hampers = hampers;
    }


    /*
    *Method to get hamper
    *@int index, the index from the hamper arraylist that should be returned
    */

    public Hamper getHamper(int index){
        return this.hampers.get(index);    
    }


    /*
    *Method to remove food object from arraylist of availible foods locally after those food objects get added to hamper
    *@ArrayList<ArrayList<String>>, the most recend hamper made from the program
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
    *Method to remove food from the data base after the order is compleated
    */
    public void removeFoodsDatabase(){
        Database db = new Database();

        for(int i = 0; i < hampers.size(); i++){
            ArrayList<ArrayList<String>> temp = hampers.get(i).getInventory().getAllFood();
            for(int j = 0; j < temp.size(); j++){
                db.deleteUsedFoods(Integer.parseInt(temp.get(j).get(1)));
            }
        }
    }
}
