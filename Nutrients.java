package edu.ucalgary.ensf409;

public abstract class Nutrients {
    private double WholeGrain;
    private double FruitVeggies;
    private double Proteins;
    private double Others;
    private double Calories;

    public Nutrients(){

    }

    public double getWholeGrains(){
        return this.WholeGrain;
    }

    public double getFruitsVeggies(){
        return this.FruitVeggies;
    }

    public double getProteins(){
        return this.Proteins;
    }

    public double getOthers(){
        return this.Others;
    }

    public double getCalories(){
        return this.Calories;
    }


    public void setWholeGrain(double Grain){
        this.WholeGrain = Grain;
    }


    public void setFV(double FV){
        this.FruitVeggies = FV;
    }

    public void setProtein(double pr){
        this.Proteins = pr;
    }


    public void setother(double other){
        this.Others = other;
    }

    public void setCalories(double cal){
        this.Calories = cal;
    }





    abstract protected void findInfoFromDataBase();

}

