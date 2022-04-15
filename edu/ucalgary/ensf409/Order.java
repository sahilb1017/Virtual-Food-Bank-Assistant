package edu.ucalgary.ensf409;

import java.util.*;

public class Order {
    
    private ArrayList<Hamper> hampers = new ArrayList<Hamper>();
    private ArrayList<Food> availableFood = new ArrayList<Food>();

    public Order(){
        Database db = new Database();
        availableFood = db.getAvailableFood();
        db.close();
    }

    public void addHamper(int[] list) throws ItemNotFoundException, NotEnoughFoodException{
        hampers.add(new Hamper(list, availableFood));
        ArrayList<ArrayList<String>> tempList = hampers.get(hampers.size() - 1).getInventory().getAllFood();
        removeFoodsLocal(tempList);
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

    public void removeFoodsLocal(ArrayList<ArrayList<String>> foods){
        for(int i = 0; i < foods.size(); i++){
            int key = Integer.parseInt(foods.get(i).get(1));
            for(int j = 0; j < this.availableFood.size(); j++){
                int curr = this.availableFood.get(j).getItemID();

                if(key == curr)
                    this.availableFood.remove(j);
            }
        }
    }
 
    public void removeFoodsDatabase(){
        Database db = new Database();

        for(int i = 0; i < hampers.size(); i++){
            ArrayList<ArrayList<String>> temp = hampers.get(i).getInventory().getAllFood();
            for(int j = 0; j < temp.size(); j++){
                db.deleteUsedFoods(Integer.parseInt(temp.get(j).get(1)));
            }
        }
    }
}
