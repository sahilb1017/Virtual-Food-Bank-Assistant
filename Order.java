package edu.ucalgary.ensf409;

import java.io.*;
import java.util.*;

public class Order {
    
    private ArrayList<Hamper> hampers = new ArrayList<Hamper>();

    public Order(){

    }

    public void addHamper(int List[]) throws ItemNotFoundException, NotEnoughFoodException{

        
        hampers.add(new Hamper(List));
        
    }

    public ArrayList<Hamper> getHampers(){
        return this.hampers;
    }

    public void setHampers(ArrayList<Hamper> hampers){
        this.hampers = hampers;
    }

    public Hamper getHamper(int index){
        return this.hampers.get(index);
    }



}
