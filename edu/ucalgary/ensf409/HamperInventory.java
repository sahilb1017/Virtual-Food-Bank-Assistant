package edu.ucalgary.ensf409;

import java.util.*;


public class HamperInventory{
    
    private ArrayList<ArrayList<String>> allFood = new ArrayList<ArrayList<String>>();

    private Totals total;
    private Food[] availibleFoods = new Food[10];

    public HamperInventory(Totals total){
        this.total = total;

        Food cock1 = new Food(8, "food1");
        cock1.setWholeGrain(500);
        cock1.setFV( 100);
        cock1.setProtein(123);
        cock1.setother(40);
        cock1.setCalories(763);


    Food cock2 = new Food( 12, "food2");
        cock2.setWholeGrain(70);
        cock2.setFV( 170);
        cock2.setProtein(130);
        cock2.setother(90);
        cock2.setCalories(460);


    Food cock3 = new Food(34,"food3");
        cock3.setWholeGrain(400);
        cock3.setFV(107);
        cock3.setProtein(150);
        cock3.setother(44);
        cock3.setCalories(701);


    Food cock4 = new Food(23, "food4");
        cock4.setWholeGrain(200);
        cock4.setFV(0);
        cock4.setProtein(123);
        cock4.setother(234);
        cock4.setCalories(557);


    Food cock5 = new Food(56,"food5");
        cock5.setWholeGrain(10);
        cock5.setFV(230);
        cock5.setProtein(213);
        cock5.setother(0);
        cock5.setCalories(443);

    Food cock6 = new Food(87,"food6");
        cock6.setWholeGrain( 100);
        cock6.setFV(400);
        cock6.setProtein( 340);
        cock6.setother( 630);
        cock6.setCalories( 1470);


    Food cock7 = new Food( 56,  "food7");
        cock7.setWholeGrain( 380);
        cock7.setFV( 106);
        cock7.setProtein( 200);
        cock7.setother(300);
        cock7.setCalories( 986);


    Food cock8 = new Food(3,"food8");
        cock8.setWholeGrain( 1700);
        cock8.setFV(4000);
        cock8.setProtein(8300);
        cock8.setother(2400);
        cock8.setCalories(16400);

    Food cock9 = new Food(57, "food9");
        cock9.setWholeGrain( 75);
        cock9.setFV( 33);
        cock9.setProtein( 78);
        cock9.setother(6);
        cock9.setCalories( 192);


    Food cock10 = new Food( 64, "food10");
        cock10.setWholeGrain( 44);
        cock10.setFV( 91);
        cock10.setProtein( 83);
        cock10.setother(54);
        cock10.setCalories( 272);


        availibleFoods[0] = cock1;
        availibleFoods[1] = cock2;
        availibleFoods[2] = cock3;
        availibleFoods[3] = cock4;
        availibleFoods[4] = cock5;
        availibleFoods[5] = cock6;
        availibleFoods[6] = cock7;
        availibleFoods[7] = cock8;
        availibleFoods[8] = cock9;
        availibleFoods[9] = cock10;


    }

    public void determineFoodNeeded() throws NotEnoughFoodException {

        ArrayList<Food[]> Hampers = new ArrayList<Food[]>();
        

        double requiredNutrient[] = new double[4];

        requiredNutrient[0] = total.getTotalGrain();
        requiredNutrient[1] = total.getTotalFV();
        requiredNutrient[2] =  total.getTotalProtein();
        requiredNutrient[3] = total.getTotalOther();


        int numberOfFood = 30;
        Food[] finalHamper = new Food[numberOfFood];
        // data base stuff;

        int max = 1 << availibleFoods.length;
        Food[][] result = new Food[max][];

        for (int i = 0; i < max; ++i){
            result[i] = new Food[Integer.bitCount(i)];
            //Power set thing
            for (int j = 0, b = i, k = 0; j < availibleFoods.length; ++j, b >>= 1){
                if ((b & 1) != 0){
                    result[i][k++] = availibleFoods[j];
                }
            }
            //This part sets certain values to null
            double currentGrain,currentFV,currentProtein,currentOther;
            currentGrain = currentFV = currentProtein = currentOther = 0;
            for(int m = 0; m < result[i].length;m++){
                currentGrain+=result[i][m].getWholeGrains();
                currentFV+=result[i][m].getFruitsVeggies();
                currentProtein+=result[i][m].getProteins();
                currentOther+=result[i][m].getOthers();
            }
            //This part sets certain parts to null that are irrelevant
            if(currentGrain<requiredNutrient[0]||currentFV<requiredNutrient[1]||currentProtein<requiredNutrient[2]||currentOther<requiredNutrient[3]){
                result[i] = null;
            }
        }

        //This part gets rid of the null values and the empty set from the array list because we don't care about them.
        for(int z = 0;z<result.length;z++){
            if(result[z]!=null&& result[z].length!=0){
                Hampers.add(result[z]);
            }
        }

        

        CheckException(Hampers);

        finalHamper = FindHamper(Hampers);

        formatHamper(finalHamper);


        }

        public Food[] FindHamper(ArrayList<Food[]> hampers){

            int key = 0;
            double Calories = 0;


            for(int j = 0; j< hampers.get(0).length;j++){

                Calories += hampers.get(0)[j].getCalories();

            }

            double CurrentLeast = Calories;

            for (int i = 1; i < hampers.size(); i++){ 

                Calories = 0;

                
                for(int j = 0; j< hampers.get(i).length;j++){

                    Calories += hampers.get(i)[j].getCalories();

                }

                if(Calories < CurrentLeast){
                    CurrentLeast = Calories;
                    key = i;

                }

     
             }  
             
             return hampers.get(key);

        }


        public void formatHamper(Food[]Hamper){
            for(int i =0; i<Hamper.length;i++){
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(0, Integer.toString((int)Hamper[i].getItemID()));
            temp.add(0, Hamper[i].getItemName());
            allFood.add(temp);

            }

        }

        
        private void CheckException(ArrayList<Food[]> HampersList) throws NotEnoughFoodException{

           
            int counter = 0;

            for(int i =0; i<HampersList.size();i++){

                if(HampersList.get(i) == null){
                    counter++;
                }
            }

            if(counter == HampersList.size()){
                throw new NotEnoughFoodException();
            }

        }

        
    public ArrayList<ArrayList<String>> getAllFood(){

        return this.allFood;
    }




}
