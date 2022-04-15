package edu.ucalgary.ensf409;
import java.util.ArrayList;

public class Hamper {
    
    private int numOfMaleAdults;
    private int numOfFemaleAdults;
    private int numOfChildOver8;
    private int numOfChildUnder8;

    private Totals total = new Totals();
    private HamperInventory inventory;

    public Hamper(int[] list, ArrayList<Food> foods) throws ItemNotFoundException, NotEnoughFoodException{
        this.numOfMaleAdults=list[0];
        this.numOfFemaleAdults=list[1];
        this.numOfChildOver8 = list[2];
        this.numOfChildUnder8 = list[3];
        calculateTotals();
        inventory = new HamperInventory(this.total, foods);
        inventory.determineFoodNeeded();
    }

    public int getNumMaleAdults(){
        return this.numOfMaleAdults;
    }

    public int getNumFemaleAdults(){
        return this.numOfFemaleAdults;
    }

    public int getNumChildOver8(){
        return this.numOfChildOver8;
    }

    public int getNumChildUnder8(){
        return this.numOfChildUnder8;
    }

    public HamperInventory getInventory(){
        return this.inventory;
    }

    public Totals getTotals(){
        return this.total;
    }

    private void calculateTotals(){
        MaleAdultNutrients maleAdult = new MaleAdultNutrients(this.numOfMaleAdults);
        FemaleAdultNutrients femaleAdult = new FemaleAdultNutrients(this.numOfFemaleAdults);
        ChildOver8Nutrients childOver8 = new ChildOver8Nutrients(this.numOfChildOver8);
        ChildUnder8Nutrients childUnder8 = new ChildUnder8Nutrients(this.numOfChildUnder8);

        this.total.addToGrain(maleAdult.getWholeGrains());
        this.total.addToGrain(femaleAdult.getWholeGrains());
        this.total.addToGrain(childOver8.getWholeGrains());
        this.total.addToGrain(childUnder8.getWholeGrains());
        System.out.println(this.total.getTotalGrain());

        this.total.addToProtein(maleAdult.getProteins());
        this.total.addToProtein(femaleAdult.getProteins());
        this.total.addToProtein(childOver8.getProteins());
        this.total.addToProtein(childUnder8.getProteins());
        System.out.println(this.total.getTotalProtein());

        this.total.addToFV(maleAdult.getFruitsVeggies());
        this.total.addToFV(femaleAdult.getFruitsVeggies());
        this.total.addToFV(childOver8.getFruitsVeggies());
        this.total.addToFV(childUnder8.getFruitsVeggies());
        System.out.println(this.total.getTotalFV());

        this.total.addToOther(maleAdult.getOthers());
        this.total.addToOther(femaleAdult.getOthers());
        this.total.addToOther(childOver8.getOthers());
        this.total.addToOther(childUnder8.getOthers());
        System.out.println(this.total.getTotalOther());
    }
}
