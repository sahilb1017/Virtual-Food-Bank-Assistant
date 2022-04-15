package edu.ucalgary.ensf409;
import java.util.*;
public class HamperInventory{
    private ArrayList<ArrayList<String>> allFood = new ArrayList<ArrayList<String>>();
    private Totals total;
    private ArrayList<Food> availableFoods;

    public HamperInventory(Totals total, ArrayList<Food> foods){
        this.total = total;
        this.availableFoods = foods;
    }

    public void determineFoodNeeded() throws NotEnoughFoodException {
        ArrayList<Food[]> hampers = new ArrayList<Food[]>();
        
        double requiredNutrient[] = new double[4];

        requiredNutrient[0] = this.total.getTotalGrain();
        requiredNutrient[1] = this.total.getTotalFV();
        requiredNutrient[2] =  this.total.getTotalProtein();
        requiredNutrient[3] = this.total.getTotalOther();

        int numberOfFood = this.availableFoods.size();
        Food[] finalHamper = new Food[numberOfFood];
        // data base stuff;
        int max = 1 << this.availableFoods.size();
        Food[][] result = new Food[max][];

        for (int i = 0; i < max; ++i){
            result[i] = new Food[Integer.bitCount(i)];
            //Power set thing
            for (int j = 0, b = i, k = 0; j < this.availableFoods.size(); ++j, b >>= 1){
                if ((b & 1) != 0){
                    result[i][k++] = this.availableFoods.get(j);
                }
            }
            //This part sets certain values to null
            double currentGrain, currentFV, currentProtein, currentOther;
            currentGrain = currentFV = currentProtein = currentOther = 0;
            for(int m = 0; m < result[i].length;m++){
                currentGrain+=result[i][m].getWholeGrains();
                currentFV+=result[i][m].getFruitsVeggies();
                currentProtein+=result[i][m].getProteins();
                currentOther+=result[i][m].getOthers();
            }
            //This part sets certain parts to null that are irrelevant
            if(currentGrain < requiredNutrient[0] || currentFV < requiredNutrient[1] || currentProtein < requiredNutrient[2] ||
              currentOther < requiredNutrient[3]){
                result[i] = null;
            }
        }

        //This part gets rid of the null values and the empty set from the array list because we don't care about them.
        for(int z = 0; z <result.length; z++){
            if(result[z] != null && result[z].length !=0){
                hampers.add(result[z]);
            }
        }
        checkException(hampers);
        finalHamper = findHamper(hampers);
        formatHamper(finalHamper);
    }

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


    public void formatHamper(Food[] hamper){
        for(int i = 0; i < hamper.length; i++){
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(0, Integer.toString((int)hamper[i].getItemID()));
            temp.add(0, hamper[i].getItemName());
            this.allFood.add(temp);
        }
    }

        
    private void checkException(ArrayList<Food[]> hampersList) throws NotEnoughFoodException{
        int counter = 0;
        for(int i = 0; i < hampersList.size(); i++){
            if(hampersList.get(i) == null)
                counter++; 
        }

        if(counter == hampersList.size())
            throw new NotEnoughFoodException();
    }

    public ArrayList<ArrayList<String>> getAllFood(){
        return this.allFood;
    }
}
