/**
@author Sahil Bhatt
@author Harshal Patel
@author Siwon Kim
@author Abhiraam Manchiraju    

<a href="mailto:sahil.bhatt@ucalgary.ca"> sahil.bhatt@ucalgary.ca</a>
<a href="mailto:harshal.patel@ucalgary.ca"> harshal.patel@ucalgary.ca</a>
<a href="mailto:siwon.kim@ucalgary.ca"> siwon.kim@ucalgary.ca</a>
<a href="mailto:abhiraam.manchiraju@ucalgary.ca"> abhiraam.manchiraju@ucalgary.ca</a>

@version 1.3
@since 1.0
*/

package edu.ucalgary.ensf409;
/**
This class is used for finding the total nutritional requirements of each hamper in an order.
*/
public class Totals {
    private double totalGrains = 0;
    private double totalProteins = 0;
    private double totalFV = 0;
    private double totalOther = 0;
    private double totalCalories = 0;

    public Totals(){}

    /**
     * This method returns the total grain requirement needed for a hamper.
     * @param none
    */
    public double getTotalGrain(){
        return this.totalGrains;
    }


    /**
     * This method returns the total protein requirement needed for a hamper.
     * @param none
    */
    public double getTotalProtein(){
        return this.totalProteins;
    }


    /**
     * This method returns the total fruits and veggies requirement needed for a hamper.
     * @param none
    */
    public double getTotalFV(){
        return this.totalFV;
    }


    /**
     * This method returns the total requirement for other minor nutrients needed for a hamper.
     * @param none
    */
    public double getTotalOther(){
        return this.totalOther;
    }


    /**
     * This method returns the total calorie requirement needed for a hamper.
     * @param none
    */  
    public double getTotalCalories(){
        return this.totalCalories;
    }


    /**
     * This method adds to the total grain requirement for a hamper.
     * @param amount Amount of grain content being added to the total.
    */
    public void addToGrain(double amount){
        this.totalGrains+=amount;
    }


    /**
     * This method adds to the total protein requirement for a hamper.
     * @param amount Amount of protein content being added to the total.
    */
    public void addToProtein(double amount){
        this.totalProteins+=amount;
    }


    /**
     * This method adds to the total fruits and veggies requirement for a hamper.
     * @param amount Amount of fruits and veggies content being added to the total.
    */
    public void addToFV(double amount){
        this.totalFV+=amount;
    }


    /**
     * This method adds to the total requirement for other nutrients for a hamper.
     * @param amount Amount of other nutrional content being added to the total.
    */
    public void addToOther(double amount){
        this.totalOther+=amount;
    }


    /**
     * This method adds to the total calorie requirement for a hamper.
     * @param amount Amount of calorie content being added to the total.
    */
    public void addToCalories(double amount){
        this.totalCalories+=amount;
    }
}//End of Class Declaration
