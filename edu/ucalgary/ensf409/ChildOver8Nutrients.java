/**
@author Sahil Bhatt
@author Harshal Patel
@author Siwon Kim
@author Abhiraam Manchiraju    

<a href="mailto:sahil.bhatt@ucalgary.ca"> sahil.bhatt@ucalgary.ca</a>
<a href="mailto:harshal.patel@ucalgary.ca"> harshal.patel@ucalgary.ca</a>
<a href="mailto:siwon.kim@ucalgary.ca"> siwon.kim@ucalgary.ca</a>
<a href="mailto:abhiraam.manchiraju@ucalgary.ca"> abhiraam.manchiraju@ucalgary.ca</a>

@version 1.9
@since 1.0
*/

package edu.ucalgary.ensf409;
/**
 * This class extends the abstract Nutrients class and retreives the nutrional requirment info for an average
 * child over 8 from the database. The data is then also manipulated to accomdate the number of over 8 children in a
 * certain hamper.
*/
public class ChildOver8Nutrients extends Nutrients{
    private final static int CLIENTID = 3;
    private int numChildOver8;
    
    /**
     * This constructor takes an input of the amount of children over 8 in an hamper, and then sets the total nutrional requirements
     * for the over 8 children in that hamper.
     * @param amount The number of over 8 children in a hamper.
    */
    public ChildOver8Nutrients(int amount){
        this.numChildOver8 = amount;
    }


    /**
     * This method returns the number of chidren over 8 in a hamper.
     * @param none
    */
    public int getNumChildOver8(){
        return this.numChildOver8;
    }


    /**
     * This method sets the number of children over 8 in a hamper, which is then used to find the total nutrional requirements for all the 
     * over 8 chidren in a hamper.
     * @param amount The amount of children over 8 in a hamper.
    */  
    public void setNumChildOver8(int amount){
        this.numChildOver8 = amount;
    }


    /**
     * This method returns the client ID corresponding to the client type of a child over 8.
     * @param none
    */
    public static int getClientId(){
        return ChildOver8Nutrients.CLIENTID;
    }

    
    /**
     * This method retreives the nutrional info for a child over 8 through the database, and sets the nutrional requirements for a hamper based
     * on the number of over 8 children in the hamper. The methods used are extensions of the Nutrients class.
     * @param none
    */
    protected void findInfoFromDataBase(){
        Database db = this.establishDB();
        int[] values = db.getClientNeeds(ChildOver8Nutrients.CLIENTID);

        //Performing the calculations for the needed nutrients in one week
        this.setWholeGrain(((double)values[0] / 100) * values[4]* numChildOver8 * 7);
        this.setFruitsVeggies(((double)values[1] / 100) * values[4]* numChildOver8 * 7);
        this.setProtein(((double)values[2] / 100) * values[4]* numChildOver8 * 7);
        this.setOther(((double)values[3] / 100) * values[4]* numChildOver8 * 7);
        this.setCalories(values[4]);
        db.close();
    }
}//End of Class Declaration