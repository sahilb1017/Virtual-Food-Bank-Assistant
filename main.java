package edu.ucalgary.ensf409;

public class main {

    public static void main(String args[]) throws NotEnoughFoodException, ItemNotFoundException{



        
        int[]list = {1,1,1,4};
        int[]list2 = {1,2,2,4};
        Order order = new Order();

        order.addHamper(list);
        order.addHamper(list2);

        PrintOrder print = new PrintOrder(order);

        



       

}











}
