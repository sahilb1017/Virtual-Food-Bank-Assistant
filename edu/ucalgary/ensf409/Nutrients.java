package edu.ucalgary.ensf409;

public abstract class Nutrients {
    private double wholeGrains;
    private double fruitsVeggies;
    private double proteins;
    private double others;
    private double calories;
    private Database db = new Database();

    public Nutrients(){}

    public double getWholeGrains(){
        return this.wholeGrains;
    }

    public double getFruitsVeggies(){
        return this.fruitsVeggies;
    }

    public double getProteins(){
        return this.proteins;
    }

    public double getOthers(){
        return this.others;
    }

    public double getCalories(){
        return this.calories;
    }

    public void setWholeGrain(double grain){
        this.wholeGrains = grain;
    }

    public void setFruitsVeggies(double fruitsVeggies){
        this.fruitsVeggies = fruitsVeggies;
    }

    public void setProtein(double protein){
        this.proteins = protein;
    }

    public void setOther(double other){
        this.others = other;
    }

    public void setCalories(double calories){
        this.calories = calories;
    }

    public Database getDB(){
        return this.db;
    }
    
    abstract protected void findInfoFromDataBase();
}

