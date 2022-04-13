package edu.ucalgary.ensf409;

import java.util.*;

public class HamperInventory {
    
    private ArrayList<ArrayList<String>> allFood = new ArrayList<ArrayList<String>>();

    private Totals total;

    public HamperInventory(Totals total){
        this.total = total;
    }

    public void determineFoodNeeded(){

        ArrayList<Double[]> Hamper = new ArrayList<Double[]>();

        ArrayList<Double[]> foodBank = new ArrayList<Double[]>();

        double requiredNutrient[] = new double[4];

        requiredNutrient[0] = total.getTotalGrain();
        requiredNutrient[1] = total.getTotalFV();
        requiredNutrient[2] =  total.getTotalProtein();
        requiredNutrient[3] = total.getTotalOther();

        for(int i  = 0; i<4; i++){
            
           
            
                
            }




        }


      


    

    public ArrayList<ArrayList<String>> getAllFood(){

        return this.allFood;
    }

}
