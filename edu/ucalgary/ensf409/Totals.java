package edu.ucalgary.ensf409;

public class Totals {

    private double totalGrains = 0;

    private double totalProteins = 0;

    private double totalFV = 0;

    private double totalOther = 0;

    private double totalCalories = 0;

    public Totals(){

    }

    public double getTotalGrain(){

        return this.totalGrains;
    }
    public double getTotalProtein(){

        return this.totalProteins;
    }
    public double getTotalFV(){

        return this.totalFV;
    }
    public double getTotalOther(){

        return this.totalOther;
    }
    public double getTotalCalories(){

        return this.totalCalories;
    }

    public void addToGrain(double amount){
        this.totalGrains+=amount;
    }
    public void addToProtein(double amount){
        this.totalProteins+=amount;
    }

    public void addToFV(double amount){
        this.totalFV+=amount;
    }

    public void addToOther(double amount){
        this.totalOther+=amount;
    }

    public void addToCalories(double amount){
        this.totalCalories+=amount;
    }



    
    
}
