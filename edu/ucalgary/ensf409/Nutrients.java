/**
@author Sahil Bhatt
@author Harshal Patel
@author Siwon Kim
@author Abhiraam Manchiraju    

<a href="mailto:sahil.bhatt@ucalgary.ca"> sahil.bhatt@ucalgary.ca</a>
<a href="mailto:harshal.patel@ucalgary.ca"> harshal.patel@ucalgary.ca</a>
<a href="mailto:siwon.kim@ucalgary.ca"> siwon.kim@ucalgary.ca</a>
<a href="mailto:abhiraam.manchiraju@ucalgary.ca"> abhiraam.manchiraju@ucalgary.ca</a>

@version 1.4
@since 1.0
*/

package edu.ucalgary.ensf409;
/**
This class is an abstract class used for retrieving the nutrients and nutrional 
requirements of the clients and the items in the database. It is 
extended by each of the individual client type classes FemaleAdultNutrients.etc
*/
public abstract class Nutrients {
    private double wholeGrains;
    private double fruitsVeggies;
    private double proteins;
    private double others;
    private double calories;
    private Database db = new Database();

    /**
     * Default constructor
     * @param none
    */
    public Nutrients(){}


    /**
     * This method returns the grain content/requirement for a cerain item/client type.
     * @param none
    */
    public double getWholeGrains(){
        return this.wholeGrains;
    }


    /**
     * This method returns the fruits and veggies content/requirement for a cerain item/client type.
    */
    public double getFruitsVeggies(){
        return this.fruitsVeggies;
    }


    /**
     * This method returns the protein content/requirement for a cerain item/client type.
     * @param none
    */
    public double getProteins(){
        return this.proteins;
    }


    /**
     * This method returns the content/requirement for other nutrients for a cerain item/client type.
     * @param none
    */
    public double getOthers(){
        return this.others;
    }


    /**
     * This method returns the calories content/requirement for a cerain item/client type.
     * @param none
    */
    public double getCalories(){
        return this.calories;
    }


    /**
     * This method sets a value for the grain content/requirements for a certain item/client type.
     * @param grain - The grain content/requirement for the item/client type. 
    */
    public void setWholeGrain(double grain){
        this.wholeGrains = grain;
    }


    /**
     * This method sets a value for the fruits and veggies content/requirements for a certain item/client type.
     * @param fruitsVeggies - The fruits and veggies content/requirement for the item/client type. 
    */
    public void setFruitsVeggies(double fruitsVeggies){
        this.fruitsVeggies = fruitsVeggies;
    }


    /**
     * This method sets a value for the protein content/requirements for a certain item/client type.
     * @param protein - The protein content/requirement for the item/client type in terms of calorie percentage. 
    */
    public void setProtein(double protein){
        this.proteins = protein;
    }

    /**
     * This method sets a value for the other nutrient content/requirements for a certain item/client type.
     * @param other - The other nutrient content/requirement for the item/client type. 
    */
    public void setOther(double other){
        this.others = other;
    }


    /**
     * This method sets a value for the calories content/requirements for a certain item/client type.
     * @param calories - The calorie content/requirement for the item/client type. 
    */
    public void setCalories(double calories){
        this.calories = calories;
    }


    /**
     * This method returns the database consisting of the nutritional requirements for a certain client type or
     * the nutritional content of a certain food.
     * @param none
    */
    public Database getDB(){
        return this.db;
    }
    
    //abstract method to be inherited by other classes and overweitten if needed
    abstract protected void findInfoFromDataBase();
}//End of Class Declaration

