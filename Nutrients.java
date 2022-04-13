package edu.ucalgary.ensf409;

public abstract class Nutrients {
    private int WholeGrain;
    private int FruitVeggies;
    private int Proteins;
    private int Others;
    private int Calories;

    public Nutrients(){

    }

    public int getWholeGrains(){
        return this.WholeGrain;
    }

    public int getFruitsVeggies(){
        return this.FruitVeggies;
    }

    public int getProteins(){
        return this.Proteins;
    }

    public int getOthers(){
        return this.Others;
    }

    public int getCalories(){
        return this.Calories;
    }

    abstract protected void findInfoFromDataBase();

}

