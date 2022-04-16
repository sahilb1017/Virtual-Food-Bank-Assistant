/**
@author Sahil Bhatt
@author Harshal Patel
@author Siwon Kim
@author Abhiraam Manchiraju    

<a href="mailto:sahil.bhatt@ucalgary.ca"> sahil.bhatt@ucalgary.ca</a>
<a href="mailto:harshal.patel@ucalgary.ca"> harshal.patel@ucalgary.ca</a>
<a href="mailto:siwon.kim@ucalgary.ca"> siwon.kim@ucalgary.ca</a>
<a href="mailto:abhiraam.manchiraju@ucalgary.ca"> abhiraam.manchiraju@ucalgary.ca</a>

@version 1.8
@since 1.0
*/

package edu.ucalgary.ensf409;
/**
This class extends the abstract Nutrients class and retreives the nutrional requirment info for an average
female adult from the database. The data is then also manipulated to accomdate the number of female adults in a
certain hamper.
*/
public class FemaleAdultNutrients extends Nutrients{
    private final static int CLIENTID = 2;
    private int numFemales;
    
    /**
     * This constructor takes an input of the amount of female adults in an hamper, and then sets the total nutrional requirements
     * for the adult females in that hamper.
     * @param amount The number of adult females in a hamper.
    */
    public FemaleAdultNutrients(int amount){
        this.numFemales = amount;
        findInfoFromDataBase();
    }


    /**
     * This method returns the number of adult females in a hamper.
     * @param none
    */
    public int getNumFemale(){
        return this.numFemales;
    }


    /**
     * This method sets the number of adult females in a hamper, which is then used to find the total nutrional requirements for all the 
     * adult females in a hamper.
     * @param amount The amount of adult females in a hamper.
    */
    public void setNumFemale(int amount){
        this.numFemales = amount;
    }


    /**
     * This method returns the client ID corresponding to the client type of an adult female.
     * @param none
    */
    public int getClientId(){
        return FemaleAdultNutrients.CLIENTID;
    }

    
    /**
     * This method retreives the nutrional info for an adult female through the database, and sets the nutrional requirements for a hamper based
     * on the number of adult females in the hamper. The methods used are extensions of the Nutrients class.
     * @param none
    */
    protected void findInfoFromDataBase(){
        Database db = this.getDB();
        int[] values = db.getClientNeeds(FemaleAdultNutrients.CLIENTID);

        //Performing the calculations for the needed nutrients in one week
        this.setWholeGrain(((double)values[0] / 100) * values[4]* numFemales * 7);
        this.setFruitsVeggies(((double)values[1] / 100) * values[4]* numFemales * 7);
        this.setProtein(((double)values[2] / 100) * values[4]* numFemales * 7);
        this.setOther(((double)values[3] / 100) * values[4]* numFemales * 7);
        this.setCalories((double)values[4]);
        db.close();
    }
}//End of Class Declaration

