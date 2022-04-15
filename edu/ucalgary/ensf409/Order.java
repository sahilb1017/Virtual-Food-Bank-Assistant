package edu.ucalgary.ensf409;

import java.util.*;

public class Order {
    
    private ArrayList<Hamper> hampers = new ArrayList<Hamper>();
    private ArrayList<Food> availableFood = new ArrayList<Food>();

    public Order(){
        //READ ALL FOODS FROM DATABASE AND STORE INTO availableFood;
        Food cock1 = new Food(8, "food1");
        cock1.setWholeGrain(250);
        cock1.setFruitsVeggies( 250);
        cock1.setProtein(250);
        cock1.setother(250);
        cock1.setCalories(1000);


    Food cock2 = new Food( 12, "food2");
        cock2.setWholeGrain(70);
        cock2.setFruitsVeggies( 170);
        cock2.setProtein(130);
        cock2.setother(90);
        cock2.setCalories(460);


    Food cock3 = new Food(34,"food3");
        cock3.setWholeGrain(400);
        cock3.setFruitsVeggies(107);
        cock3.setProtein(150);
        cock3.setother(44);
        cock3.setCalories(701);


    Food cock4 = new Food(23, "food4");
        cock4.setWholeGrain(200);
        cock4.setFruitsVeggies(0);
        cock4.setProtein(123);
        cock4.setother(234);
        cock4.setCalories(557);


    Food cock5 = new Food(56,"food5");
        cock5.setWholeGrain(10);
        cock5.setFruitsVeggies(230);
        cock5.setProtein(213);
        cock5.setother(0);
        cock5.setCalories(443);

    Food cock6 = new Food(87,"food6");
        cock6.setWholeGrain( 100);
        cock6.setFruitsVeggies(400);
        cock6.setProtein( 340);
        cock6.setother( 630);
        cock6.setCalories( 1470);


    Food cock7 = new Food( 56,  "food7");
        cock7.setWholeGrain( 380);
        cock7.setFruitsVeggies( 106);
        cock7.setProtein( 200);
        cock7.setother(300);
        cock7.setCalories( 986);


    Food cock8 = new Food(3,"food8");
        cock8.setWholeGrain( 1700);
        cock8.setFruitsVeggies(4000);
        cock8.setProtein(8300);
        cock8.setother(2400);
        cock8.setCalories(16400);

    Food cock9 = new Food(57, "food9");
        cock9.setWholeGrain( 75);
        cock9.setFruitsVeggies( 33);
        cock9.setProtein( 78);
        cock9.setother(6);
        cock9.setCalories( 192);


    Food cock10 = new Food( 64, "food10");
        cock10.setWholeGrain( 44);
        cock10.setFruitsVeggies( 91);
        cock10.setProtein( 83);
        cock10.setother(54);
        cock10.setCalories( 272);

        availableFood.add(cock1);
        availableFood.add(cock2);
        availableFood.add(cock3);
        availableFood.add(cock4);
        availableFood.add(cock5);
        availableFood.add(cock6);
        availableFood.add(cock7);
        availableFood.add(cock8);
        availableFood.add(cock9);
        availableFood.add(cock10);
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
