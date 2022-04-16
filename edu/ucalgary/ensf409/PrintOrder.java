/**
@author Sahil Bhatt
@author Harshal Patel
@author Siwon Kim
@author Abhiraam Manchiraju    

<a href="mailto:sahil.bhatt@ucalgary.ca"> sahil.bhatt@ucalgary.ca</a>
<a href="mailto:harshal.patel@ucalgary.ca"> harshal.patel@ucalgary.ca</a>
<a href="mailto:siwon.kim@ucalgary.ca"> siwon.kim@ucalgary.ca</a>
<a href="mailto:abhiraam.manchiraju@ucalgary.ca"> abhiraam.manchiraju@ucalgary.ca</a>

@version 1.3
@since 1.0
*/

package edu.ucalgary.ensf409;
import java.util.*;
import java.io.*;
/**
*This class will print the order form 
*/
public class PrintOrder {
    FileWriter myWriter;

    /**
     * The constructor that initializes the URL of the file that will be written to. Calls 
     * hamperRequestInfo that writes out the information of the hampers that were
     * requested
     * @param value Order object that contains the hampers
    */
    public PrintOrder(Order value){
        try{
            myWriter = new FileWriter("OrderForm.txt");
        }catch(IOException e){}
        hamperRequestInfo(value);
    }


    /**
    * This method prints out the title and general information of the hamper form, along
    * with all the hamper requests that were made in the form.
    * @param value Order object that contains the hampers 
    */
    public void hamperRequestInfo(Order value){
        try{
            int counter = 1;

            //Write general information about order form
            myWriter.write("Hamper Order Form"+"\n");
            myWriter.write("\n");
            myWriter.write("Name:"+"\n");
            myWriter.write("Date:"+"\n");
            myWriter.write("\n");
            myWriter.write("Original Request"+ "\n");
    
            //Loop through each hamper request in the order
            for(Hamper hmp: value.getHampers()){
                
                String temp = "";
                temp += "Hamper " + Integer.toString(counter++) + ": ";

                //Write the number of males for a requested hamper
                if(hmp.getNumMaleAdults()!=0){
                    temp += Integer.toString(hmp.getNumMaleAdults())+ " Adult Male, ";
                }
                
                //Write the number of females for a requested hamper
                if(hmp.getNumFemaleAdults()!=0){
                    temp+= Integer.toString(hmp.getNumFemaleAdults())+ " Adult Female, ";
                }

                //Write the number of children under 8 for a requested hamper
                if(hmp.getNumChildOver8()!=0){
                    temp += Integer.toString(hmp.getNumChildOver8())+ " Child over 8, ";
                }

                //Write the number of children over 8 for a requested hamper
                if(hmp.getNumChildUnder8()!=0){
                    temp += Integer.toString(hmp.getNumChildUnder8())+ " Child under 8, ";
                }

                //Removes extra comma
                temp = temp.replaceAll(", $", "");
                temp+= "\n";
                
                //Write entire string to the order form
                myWriter.write(temp);
            }
            myWriter.write("\n");
            
            //Call orderForm() which will write out all the foods found for a requested hamper
            orderForm(value);
        }catch(IOException e){}
    }

    
    /**
     * This method will loop through the order object, and write all of the foods that have been
     * retrieved for a particular hamper to the text file
     * @param value Order object that contains the hampers
    */
    public void orderForm(Order value){
        try{
            int counter = 1;

            //Loop through the order object
            for(Hamper hmp: value.getHampers()){

                //Write the hamper number
                myWriter.write("Hamper "+ Integer.toString(counter++) +" Items"+"\n");
                
                //Create an iterator to iterate through the Arraylist of food iterms
                Iterator<ArrayList<String>> iter = hmp.getInventory().getAllFood().iterator();
                
                //Loop through the foods for a certain hamper
                while(iter.hasNext()){
                    ArrayList<String> current = iter.next();

                    //Write the food item to text file
                    myWriter.write(current.get(1)+"\t\t"+ current.get(0) + "\n" );
                }
                myWriter.write("\n");    
            }
            myWriter.close();
        }catch(IOException e){}
    }
}//End of Class Declaration
