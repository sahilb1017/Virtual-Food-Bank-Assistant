package edu.ucalgary.ensf409;

import java.util.*;

public class Order {
    
    private ArrayList<Hamper> hampers = new ArrayList<Hamper>();
    private ArrayList<Food> availableFood = new ArrayList<Food>();

    public Order(){
        //READ ALL FOODS FROM DATABASE AND STORE INTO availableFood;
        Food food1 = new Food(8, "food1");
        food1.setWholeGrain(250);
        food1.setFruitsVeggies( 250);
        food1.setProtein(250);
        food1.setother(250);
        food1.setCalories(1000);


    Food food2 = new Food( 12, "food2");
        food2.setWholeGrain(70);
        food2.setFruitsVeggies( 170);
        food2.setProtein(130);
        food2.setother(90);
        food2.setCalories(460);


    Food food3 = new Food(34,"food3");
        food3.setWholeGrain(400);
        food3.setFruitsVeggies(107);
        food3.setProtein(150);
        food3.setother(44);
        food3.setCalories(701);


    Food food4 = new Food(23, "food4");
        food4.setWholeGrain(200);
        food4.setFruitsVeggies(0);
        food4.setProtein(123);
        food4.setother(234);
        food4.setCalories(557);


    Food food5 = new Food(56,"food5");
        food5.setWholeGrain(10);
        food5.setFruitsVeggies(230);
        food5.setProtein(213);
        food5.setother(0);
        food5.setCalories(443);

    Food food6 = new Food(87,"food6");
        food6.setWholeGrain( 100);
        food6.setFruitsVeggies(400);
        food6.setProtein( 340);
        food6.setother( 630);
        food6.setCalories( 1470);


    Food food7 = new Food( 56,  "food7");
        food7.setWholeGrain( 380);
        food7.setFruitsVeggies( 106);
        food7.setProtein( 200);
        food7.setother(300);
        food7.setCalories( 986);


    Food food8 = new Food(3,"food8");
        food8.setWholeGrain( 1700);
        food8.setFruitsVeggies(4000);
        food8.setProtein(8300);
        food8.setother(2400);
        food8.setCalories(16400);

    Food food9 = new Food(57, "food9");
        food9.setWholeGrain( 75);
        food9.setFruitsVeggies( 33);
        food9.setProtein( 78);
        food9.setother(6);
        food9.setCalories( 192);


    Food food10 = new Food( 64, "food10");
        food10.setWholeGrain( 44);
        food10.setFruitsVeggies( 91);
        food10.setProtein( 83);
        food10.setother(54);
        food10.setCalories( 272);

        availableFood.add(food1);
        availableFood.add(food2);
        availableFood.add(food3);
        availableFood.add(food4);
        availableFood.add(food5);
        availableFood.add(food6);
        availableFood.add(food7);
        availableFood.add(food8);
        availableFood.add(food9);
        availableFood.add(food10);
    }

    public void addHamper(int[] list) throws ItemNotFoundException, NotEnoughFoodException{
        hampers.add(new Hamper(list, availableFood));
        ArrayList<ArrayList<String>> tempList = hampers.get(hampers.size() - 1).getInventory().getAllFood();
        removeFoods(tempList);
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

    public void removeFoods(ArrayList<ArrayList<String>> foods){
        for(int i = 0; i < foods.size(); i++){
            int key = Integer.parseInt(foods.get(i).get(1));
            for(int j = 0; j < this.availableFood.size(); j++){
                int curr = this.availableFood.get(j).getItemID();

                if(key == curr)
                    this.availableFood.remove(j);
            }
        }
    }
}
