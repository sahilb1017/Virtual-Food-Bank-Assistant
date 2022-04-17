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

/*
 * This class will find the most efficicent hamper of food items from the database while take into 
 * consideration the client's needs. Will also inform the client if not enough food are avalible to meet
 * their order's requirments.
*/
public class HamperInventory{
    private ArrayList<ArrayList<String>> allFood = new ArrayList<ArrayList<String>>();
    private Totals total;
    private ArrayList<Food> availableFoods;

    /**
     * Constructor for the Hamper Inventory object
     * @param totals, The object holding the nutrients requirments of the hamper
     * @param foods, the ArrayList of avalible food objects to put into the hamper
    */
    public HamperInventory(Totals total, ArrayList<Food> foods){
        this.total = total;
        this.availableFoods = foods;
    }


    /**
     * Method to find the Most efficient Food combination from the availible food list and add to the hamper while meeting the requriments.
     * @param none
    */
    public void determineFoodNeeded() throws NotEnoughFoodException {
        ArrayList<Food[]> hampers = new ArrayList<Food[]>();
        
        double requiredNutrient[] = new double[4];

        requiredNutrient[0] = this.total.getTotalGrain();
        requiredNutrient[1] = this.total.getTotalFV();
        requiredNutrient[2] =  this.total.getTotalProtein();
        requiredNutrient[3] = this.total.getTotalOther();

        int numberOfFood = this.availableFoods.size();
        Food[] finalHamper = new Food[numberOfFood];
        int max = 1 << this.availableFoods.size();
        Food[][] result = new Food[max][];

        //Find the powerset of food objects from the ArrayList Availible foods
        for (int i = 0; i < max; ++i){
            result[i] = new Food[Integer.bitCount(i)];
            for (int j = 0, b = i, k = 0; j < this.availableFoods.size(); ++j, b >>= 1){
                if ((b & 1) != 0){
                    result[i][k++] = this.availableFoods.get(j);
                }
            }
            //Set certain subsets of foods that do not meet the requirmeents null
            double currentGrain, currentFV, currentProtein, currentOther;
            currentGrain = currentFV = currentProtein = currentOther = 0;
            for(int m = 0; m < result[i].length;m++){
                currentGrain+=result[i][m].getWholeGrains();
                currentFV+=result[i][m].getFruitsVeggies();
                currentProtein+=result[i][m].getProteins();
                currentOther+=result[i][m].getOthers();
            }
            if(currentGrain < requiredNutrient[0] || currentFV < requiredNutrient[1] || currentProtein < requiredNutrient[2] ||
              currentOther < requiredNutrient[3]){
                result[i] = null;
            }
        }

        //All all remaining subsets that arn't null to a new Array List
        for(int z = 0; z <result.length; z++){
            if(result[z] != null && result[z].length !=0){
                hampers.add(result[z]);
            }
        }
        checkException(hampers);
        finalHamper = findHamper(hampers);
        formatHamper(finalHamper);
    }


    /**
     * Method to find the hamper with the least amount of calories(most efficient) from a list of possible Hampers
     * @param hampers List of possible Hampers that met the requirments
    */
    public Food[] findHamper(ArrayList<Food[]> hampers){
        int key = 0;
        double calories = 0;

        for(int j = 0; j< hampers.get(0).length;j++){
            calories += hampers.get(0)[j].getCalories();
        }

        double currentLeast = calories;
        for (int i = 1; i < hampers.size(); i++){ 
            calories = 0;
            for(int j = 0; j< hampers.get(i).length;j++){
                calories += hampers.get(i)[j].getCalories();
            }
            if(calories < currentLeast){
                currentLeast = calories;
                key = i;
            }
        }  
        return hampers.get(key);
    }


    /**
     * Method to format Hamper into double ArrayList with contating the FoodId and Food name for each Food object from the choosen hamper
     * @param hamper the chosen hamper 
    */
    public void formatHamper(Food[] hamper){
        for(int i = 0; i < hamper.length; i++){
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(0, Integer.toString((int)hamper[i].getItemID()));
            temp.add(0, hamper[i].getItemName());
            this.allFood.add(temp);
        }
    }
 

    /**
     * Method to check if there are enough foods from the avaliblefood arraylist to make the Hamper that meet the requirments
     * @param hampersList List of possible Hampers that met the requirments
    */
    private void checkException(ArrayList<Food[]> hampersList) throws NotEnoughFoodException{
        int counter = 0;
        for(int i = 0; i < hampersList.size(); i++){
            if(hampersList.get(i) == null)
                counter++; 
        }

        if(counter == hampersList.size())
            throw new NotEnoughFoodException();
    }


    /**
     * Method to return the choosen Hamper
     * @param none
    */
    public ArrayList<ArrayList<String>> getAllFood(){
        return this.allFood;
    }


    /**
     * Method to return the list of available foods
     * @param none
    */
    public ArrayList<Food> getAvailableFoods(){
        return this.availableFoods;
    }


    /**
     * Method to return Totals object
     * @param none
    */
    public Totals getTotals(){
        return this.total;
    }
}//End of class declaration
