package edu.ucalgary.ensf409;

public class Hamper {
    
    private int numOfMaleAdults;
    private int numOfFemaleAdults;
    private int numOfChildOver8;
    private int numOfChildUnder8;
    

    private Totals total = new Totals();

    private HamperInventory inventory;

    public Hamper(int[] list){
        this.numOfMaleAdults=list[0];
        this.numOfFemaleAdults=list[1];
        this.numOfChildOver8 = list[2];
        this.numOfChildUnder8 = list[3];
        calculateTotals();
        inventory = new HamperInventory(total);
    }

    public int getNumMaleAdults(){
        return this.numOfMaleAdults;
    }

    public int getNumFemaleAdults(){
        return this.numOfFemaleAdults;
    }

    public int getNumofChildOver8(){
        return this.numOfChildOver8;
    }

    public int getNumofChildUnder8(){
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

        total.addToCalories(maleAdult.getCalories()*numOfMaleAdults);
        total.addToCalories(femaleAdult.getCalories()*numOfFemaleAdults);
        total.addToCalories(childOver8.getCalories()*numOfChildOver8);
        total.addToCalories(childUnder8.getCalories()*numOfChildUnder8);

        total.addToGrain(maleAdult.getWholeGrains()*numOfMaleAdults);
        total.addToGrain(femaleAdult.getWholeGrains()*numOfFemaleAdults);
        total.addToGrain(childOver8.getWholeGrains()*numOfChildOver8);
        total.addToGrain(childUnder8.getWholeGrains()*numOfChildUnder8);


        total.addToProtein(maleAdult.getProteins()*numOfMaleAdults);
        total.addToProtein(femaleAdult.getProteins()*numOfFemaleAdults);
        total.addToProtein(childOver8.getProteins()*numOfChildOver8);
        total.addToProtein(childUnder8.getProteins()*numOfChildUnder8);

        total.addToFV(maleAdult.getFruitsVeggies()*numOfMaleAdults);
        total.addToFV(femaleAdult.getFruitsVeggies()*numOfFemaleAdults);
        total.addToFV(childOver8.getFruitsVeggies()*numOfChildOver8);
        total.addToFV(childUnder8.getFruitsVeggies()*numOfChildUnder8);


        total.addToOther(maleAdult.getOthers()*numOfMaleAdults);
        total.addToOther(femaleAdult.getOthers()*numOfFemaleAdults);
        total.addToOther(childOver8.getOthers()*numOfChildOver8);
        total.addToOther(childUnder8.getOthers()*numOfChildUnder8);



        

    }



}
