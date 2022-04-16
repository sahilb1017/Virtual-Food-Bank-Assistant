/**
@author Sahil Bhatt
@author Harshal Patel
@author Siwon Kim
@author Abhiraam Manchiraju    

<a href="mailto:sahil.bhatt@ucalgary.ca"> sahil.bhatt@ucalgary.ca</a>
<a href="mailto:harshal.patel@ucalgary.ca"> harshal.patel@ucalgary.ca</a>
<a href="mailto:siwon.kim@ucalgary.ca"> siwon.kim@ucalgary.ca</a>
<a href="mailto:abhiraam.manchiraju@ucalgary.ca"> abhiraam.manchiraju@ucalgary.ca</a>

@version 1.6
@since 1.0
*/

package edu.ucalgary.ensf409;
import java.util.ArrayList;

public class Hamper {
    private int numOfMaleAdults;
    private int numOfFemaleAdults;
    private int numOfChildOver8;
    private int numOfChildUnder8;

    private Totals total = new Totals();
    private HamperInventory inventory;

    /**
     * Method to create Hamper object
     * @param list an int array holding the information of the confiuerations of the desired Hamper,index 0 for number of adultMales, 
     * index 1 for number of adult females, index 2 for the numer of children over 8 and index 3 for the number of children under 8
     * @param foods, The ArrayList of Food objects availible to be added to the Hampers
    */
    public Hamper(int[] list, ArrayList<Food> foods) throws NotEnoughFoodException{
        this.numOfMaleAdults=list[0];
        this.numOfFemaleAdults=list[1];
        this.numOfChildOver8 = list[2];
        this.numOfChildUnder8 = list[3];
        calculateTotals();
        inventory = new HamperInventory(this.total, foods);
        inventory.determineFoodNeeded();
    }

    
    /**  
     * Method returns the number of MaleAdults registered from the User
     * @param none
    */
    public int getNumMaleAdults(){
        return this.numOfMaleAdults;
    }


    /**    
     * Method returns the number of FemaleAdults registered from the User
     * @param none
    */
    public int getNumFemaleAdults(){
        return this.numOfFemaleAdults;
    }


     /**    
      * Method returns the number of Children over 8 registered from the User
      * @param none
    */
    public int getNumChildOver8(){
        return this.numOfChildOver8;
    }


    /**   
     * Method returns the number of Children under 8 registered from the User
     * @param none
    */
    public int getNumChildUnder8(){
        return this.numOfChildUnder8;
    }


    /**    
     * Method returns the HamperIventory object
     * @param none
    */
    public HamperInventory getInventory(){
        return this.inventory;
    }


    /**    
     * Method returns the Total objects
     * @param none
    */
    public Totals getTotals(){
        return this.total;
    }

    /**    
     * Method to calculate the required nutrient feilds of the Hamper derived from the User input.
     * @param none
    */
    private void calculateTotals(){
        MaleAdultNutrients maleAdult = new MaleAdultNutrients(this.numOfMaleAdults);
        FemaleAdultNutrients femaleAdult = new FemaleAdultNutrients(this.numOfFemaleAdults);
        ChildOver8Nutrients childOver8 = new ChildOver8Nutrients(this.numOfChildOver8);
        ChildUnder8Nutrients childUnder8 = new ChildUnder8Nutrients(this.numOfChildUnder8);
 
        this.total.addToGrain(maleAdult.getWholeGrains());
        this.total.addToGrain(femaleAdult.getWholeGrains());
        this.total.addToGrain(childOver8.getWholeGrains());
        this.total.addToGrain(childUnder8.getWholeGrains());

        this.total.addToProtein(maleAdult.getProteins());
        this.total.addToProtein(femaleAdult.getProteins());
        this.total.addToProtein(childOver8.getProteins());
        this.total.addToProtein(childUnder8.getProteins());

        this.total.addToFV(maleAdult.getFruitsVeggies());  
        this.total.addToFV(femaleAdult.getFruitsVeggies());
        this.total.addToFV(childOver8.getFruitsVeggies());
        this.total.addToFV(childUnder8.getFruitsVeggies());

        this.total.addToOther(maleAdult.getOthers());        
        this.total.addToOther(femaleAdult.getOthers());
        this.total.addToOther(childOver8.getOthers());
        this.total.addToOther(childUnder8.getOthers());

        this.total.addToCalories(maleAdult.getCalories());        
        this.total.addToCalories(femaleAdult.getCalories());
        this.total.addToCalories(childOver8.getCalories());
        this.total.addToCalories(childUnder8.getCalories());
    }
}//End of class declaration
