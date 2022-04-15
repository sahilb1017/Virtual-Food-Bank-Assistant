package edu.ucalgary.ensf409;
import java.util.*;
import java.io.*;

public class PrintOrder {

    public PrintOrder(Order value){

        try{
        
        int counter = 1;

        FileWriter myWriter = new FileWriter("edu/ucalgary/ensf409/OrderForm.txt");
        myWriter.write("Hamper Order Form"+"\n");
        myWriter.write("\n");
        myWriter.write("Name:"+"\n");
        myWriter.write("Date:"+"\n");
        myWriter.write("\n");
        myWriter.write("Original Request"+ "\n");

        
        for(Hamper hmp: value.getHampers()){

            
            String temp = "";
            temp += "Hamper " + Integer.toString(counter++) + ": ";

            if(hmp.getNumMaleAdults()!=0){
                temp += Integer.toString(hmp.getNumMaleAdults())+ " Adult Male, ";
            }

            if(hmp.getNumFemaleAdults()!=0){
                temp+= Integer.toString(hmp.getNumFemaleAdults())+ " Adult Female, ";
            }

            if(hmp.getNumChildOver8()!=0){
                temp += Integer.toString(hmp.getNumChildOver8())+ " Child over 8, ";
            }

            if(hmp.getNumChildUnder8()!=0){
                temp += Integer.toString(hmp.getNumChildUnder8())+ " Child under 8, ";
            }

            temp = temp.replaceAll(", $", "");

            temp+= "\n";

            myWriter.write(temp);


        }

        myWriter.write("\n");
        counter = 1;

        for(Hamper hmp: value.getHampers()){

            

            myWriter.write("Hamper "+ Integer.toString(counter++) +" Items"+"\n");
            

            Iterator<ArrayList<String>> iter = hmp.getInventory().getAllFood().iterator();
            
            while(iter.hasNext()){
                ArrayList<String> current = iter.next();
                myWriter.write(current.get(1)+"\t\t"+ current.get(0) + "\n" );
            }
            
            myWriter.write("\n");

            
        }
        myWriter.close();


        }catch(IOException e){}
    }
    
}
