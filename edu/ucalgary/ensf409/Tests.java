/**
@author Sahil Bhatt
@author Harshal Patel
@author Siwon Kim
@author Abhiraam Manchiraju    

<a href="mailto:sahil.bhatt@ucalgary.ca"> sahil.bhatt@ucalgary.ca</a>
<a href="mailto:harshal.patel@ucalgary.ca"> harshal.patel@ucalgary.ca</a>
<a href="mailto:siwon.kim@ucalgary.ca"> siwon.kim@ucalgary.ca</a>
<a href="mailto:abhiraam.manchiraju@ucalgary.ca"> abhiraam.manchiraju@ucalgary.ca</a>

@version 1.6
@since 1.0
*/

package edu.ucalgary.ensf409;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import static org.junit.Assert.assertEquals;

/**
 * **************NOTES****************
 * 
 * 1. IllegalArgumentException and NumberFormatException are exceptions that are thrown by the GUI relating to thus, 
 *    will not be tested here either. 
 *      - In the GUI, if the user attempts to add a hamper without filling in the required text fields, IllegalArgumentException is thrown
 *      - In the GUI, if the user enters negative numbers IllegalArgumentException is thrown
 *      - In the GUI, if the user enters non numerical characters or values with decimals NumberFormatException is thrown
 * 
 * 2. calculateTotals() method within the Hamper class cannot be tested as it relies on the database
 * 
 * 3. PrintOrder class cannot be tested as it requires a fully realized Order object which would require database access
 * 
 * 4. An empty Order class will not be tested as the GUI prevents the user submitting an order without any hamper information 
 */

/* *********** Tests for All Classes *********** */
public class Tests{
    /*
     * This method tests for the correct return type when the getHampers() method is called from an Order Object
     * Order.addHamper() is called with valid data
    */
    @Test
    public void testOrderReturnTypeGetHampers(){
        //Test Data with all valid inputs that must be recognized
        int[] validInput = {1,1,2,2};
        //Empty list of Food Objects because only return type is tested
        ArrayList<Food> testFood = new ArrayList<Food>();

        //Status variables
        boolean match = false;

        //Create Order object, add Hamper using valid data
        Order test = new Order();
        test.setAvailableFoods(testFood);
        test.addHamper(validInput);

        match = test.getHampers() instanceof ArrayList<?>;
        
        //Check if return type is correct
        assertTrue("Incorrect type returned from getHampers() method in Order class", match);
    }


    /*
     * This method tests if a Hamper object was correctly created and added to the ArrayList of Hampers in Order
     * Order.addHamper(). Order.getHamper must return the correct Hamper object
    */   
    @Test
    public void testOrderAddHamper(){
        //Test Data with all valid inputs that must be recognized
        int[] correctInput = {1,1,1,1};
        ArrayList<Food> testFood = new ArrayList<Food>();
        
        //Status Variable
        boolean match = true;

        //Create Order object, add Hamper using valid data
        Order test = new Order();

        test.addHamper(correctInput);
        test.setAvailableFoods(testFood);
        Hamper expectedHamper = new Hamper(correctInput, testFood);
        Hamper actualHamper = test.getHamper(0);

        //Testing
        if(expectedHamper.getNumMaleAdults() != actualHamper.getNumMaleAdults())
            match = false;
        if(expectedHamper.getNumFemaleAdults() != actualHamper.getNumFemaleAdults())
            match = false;    
        if(expectedHamper.getNumChildOver8() != actualHamper.getNumChildOver8())
            match = false;
        if(expectedHamper.getNumChildUnder8() != actualHamper.getNumChildUnder8())
            match = false;

        assertTrue("Hamper not added correctly", match);
    }


    /*
     * This method tests the creation of multiple Hampers in the Order Object and checks that each Hamper
     * added to the ArrayList is correct
     * Order.addHamper() is called with sets of valid data 
     * Order.getHamper at each index must return the correctHamper object. Paramters of each hamper are tested
    */  
    @Test
    public void testOrderGetHampers(){
        //Test Data with all valid inputs that must be recognized
        int[] correctInput1 = {1,2,3,4};
        int[] correctInput2 = {2,1,4,3};
        ArrayList<Food> testFood = new ArrayList<Food>();

        //Status Variable
        boolean match1 = true;
        boolean match2 = true;

        //Create Order object, add Hampers,  create expected Hampers
        Order test = new Order();
        test.setAvailableFoods(testFood);
        test.addHamper(correctInput1);
        test.addHamper(correctInput2);
        Hamper expected1 = new Hamper(correctInput1, testFood);
        Hamper expected2 = new Hamper(correctInput2, testFood);

        //Retrieve ArrayList of Hampers and get each specifc Hamper
        ArrayList<Hamper> actualHampers = test.getHampers();
        Hamper actual1 = actualHampers.get(0);
        Hamper actual2 = actualHampers.get(1);

        //Test for first hamper
        if(expected1.getNumMaleAdults() != actual1.getNumMaleAdults())
            match1 = false;
        if(expected1.getNumFemaleAdults() != actual1.getNumFemaleAdults())
            match1 = false;    
        if(expected1.getNumChildOver8() != actual1.getNumChildOver8())
            match1 = false;
        if(expected1.getNumChildUnder8() != actual1.getNumChildUnder8())
            match1 = false;    

        //Test for second hamper
        if(expected2.getNumMaleAdults() != actual2.getNumMaleAdults())
            match2 = false;
        if(expected2.getNumFemaleAdults() != actual2.getNumFemaleAdults())
            match2 = false;    
        if(expected2.getNumChildOver8() != actual2.getNumChildOver8())
            match2 = false;
        if(expected2.getNumChildUnder8() != actual2.getNumChildUnder8())
            match1 = false;    

        //Compare Hampers with expected ones
        assertTrue("The correct hampers were not obtained from the Order object", match1);
        assertTrue("The correct hampers were not obtained from the Order object", match2);
    }


    /*
     * This method tests whether the Hamper Object contains the correct number of each type of client.
     * Order.addHamper() is called with valid data
     * Values passed through must be correctly returned in the created hamper object
    */
    @Test
    public void testOrderHamperCorrectNumberOfClients(){
        //Test Data with all valid inputs that must be recognized
        int[] validInput = {1,2,3,4};
        ArrayList<Food> testFood = new ArrayList<Food>();

        //Create Order object, add Hamper using valid data
        Order test = new Order();
        test.setAvailableFoods(testFood);
        test.addHamper(validInput);

        //Get number of each client from the created Order and Hamper Objects
        int numMale = test.getHamper(0).getNumMaleAdults();
        int numFemale = test.getHamper(0).getNumFemaleAdults();
        int numChildOver8 = test.getHamper(0).getNumChildOver8();
        int numChildUnder8 = test.getHamper(0).getNumChildUnder8();

        //Test actual values with expected ones
        assertEquals("Incorrect Number of Adult Males retrieved from Hamper stored in Order.", numMale, validInput[0]);
        assertEquals("Incorrect Number of Adult Females retrieved from Hamper stored in Order.", numFemale, validInput[1]);
        assertEquals("Incorrect Number of Children Over 8 retrieved from Hamper stored in Order.", numChildOver8, validInput[2]);
        assertEquals("Incorrect Number of Children Under 8 retrieved from Hamper stored in Order.", numChildUnder8, validInput[3]);
    }

    /**
     * Tests if a particular food object has been removed from the local storage of foods
     */
    @Test
    public void testRemoveLocalFoods(){
       //Creating food objects
        Food food1  = new Food(2, "Potato", 3,4,5,6,7);
        Food food2 = new Food(4, "Tomato", 0,0,5,6,7);
        Food food3 = new Food(8, "Chocolate", 0,0,0,0,10);

        //Status Variable
        boolean found = false;

        //Adding the food objects to an array representing the local database of foods
        ArrayList<Food> arrOfFoods = new ArrayList<Food>();
        arrOfFoods.add(food1);
        arrOfFoods.add(food2);
        arrOfFoods.add(food3);

        //Create an order object and set the available foods
        Order test = new Order();
        test.setAvailableFoods(arrOfFoods);


        //Placing the information of the tomato into the arraylist that will be passed to the remove method
        ArrayList<String> tomato = new ArrayList<String>();
        tomato.add(0, "Tomato");
        tomato.add(1, "2");

        ArrayList<ArrayList<String>> food = new ArrayList<ArrayList<String>>();
        food.add(tomato);
   
        //Remove the "tomato" food object
        test.removeFoodsLocal(food);
        
        //Check if the "tomato" food object has been removed
        for(Food i : arrOfFoods){
            if (i.getItemID() == 2){
                found = true;
            }
        }
        assertFalse("Food was not correctly removed from the removeLocalFoods() method", found);
    }

    /**
     * Tests for Hamper constructor to contain the correct values and types
     */
    @Test
    public void testHamperConstructor(){
        //Test data with all valid inputs
        int[] validInput = {1,2,3,4};
        ArrayList<Food> testFood = new ArrayList<Food>();
        //Expected Values / Status Variables
        int expectedMale = 1;
        int expectedFemale = 2;
        int expectedChildOver8 = 3;
        int expectedChildUnder8 = 4;
        boolean match = false;

        Hamper test = new Hamper(validInput, testFood);

        //Test availableFood type
        match = test.getAvailableFoods() instanceof ArrayList<?>;

        //test Values
        assertEquals("Incorrect Number of Adult Males retrieved from Hamper. Expected Value: 1", test.getNumMaleAdults(), expectedMale);
        assertEquals("Incorrect Number of Adult Females retrieved from Hamper. Expected Value: 2", test.getNumFemaleAdults(), expectedFemale);
        assertEquals("Incorrect Number of Children Over 8 retrieved from Hamper. Expected Value: 3", test.getNumChildOver8(), expectedChildOver8);
        assertEquals("Incorrect Number of Children Under 8 retrieved from Hamper. Expected Value: 4", test.getNumChildUnder8(), expectedChildUnder8);
        assertTrue("ArrayList of available foods was not correctly set", match);
    }

    /**
     * Tests to ensure that Hamper setters work as intended
     */
    @Test
    public void testHamperSetClientParameters(){
        //Test Data with all valid inputs that must be recognized
        int[] validInput = {1,2,3,4};
        ArrayList<Food> testFood = new ArrayList<Food>();
        int expectedMale = 3;
        int expectedFemale = 3;
        int expectedChildOver8 = 1;
        int expectedChildUnder8 = 0;

        //Create Hamper object
        Hamper test = new Hamper(validInput, testFood);

        //Use setters to change values
        test.setNumOfMaleAdults(expectedMale);
        test.setNumOfFemaleAdults(expectedFemale);
        test.setNumOfChildOver8(expectedChildOver8);
        test.setNumOfChildUnder8(expectedChildUnder8);

        //Test values
        assertEquals("Incorrect Number of Adult Males retrieved from Hamper. Expected Value: 1", test.getNumMaleAdults(), expectedMale);
        assertEquals("Incorrect Number of Adult Females retrieved from Hamper. Expected Value: 2", test.getNumFemaleAdults(), expectedFemale);
        assertEquals("Incorrect Number of Children Over 8 retrieved from Hamper. Expected Value: 3", test.getNumChildOver8(), expectedChildOver8);
        assertEquals("Incorrect Number of Children Under 8 retrieved from Hamper. Expected Value: 4", test.getNumChildUnder8(), expectedChildUnder8);
    }


    /**
     * Tests to see if the ArrayList of Hamper objects within Order is set properly
     * Parameters in each set Hamper are compared
     */
    @Test
    public void testSetHampers(){
        //Creating a hamper object
        ArrayList<Food> testFood = new ArrayList<Food>();
        //Status / Expected values
        int expectedNumMales = 1;
        int expectedNumFemales = 1;
        int expectedNumChildOver8 = 1;
        int expectedNumChildUnder8 = 1;
         
        int[] clientType = new int[]{expectedNumMales,expectedNumFemales,expectedNumChildOver8,expectedNumChildUnder8};
        Hamper hamper1 = new Hamper(clientType, testFood);

        //Creating an arraylist of hamper objects
        ArrayList<Hamper> hamperArrayList = new ArrayList<Hamper>();
        hamperArrayList.add(hamper1);

        //Create order object
        Order test = new Order();

        //Attempt to set the hamper array list
        test.setHampers(hamperArrayList);

        boolean match = true;
        
        //Getting the hampers that were just set
        ArrayList<Hamper> actualHampers = test.getHampers();

        //Testing if the retrieved hampers match the expected values
        if (actualHampers.get(0).getNumMaleAdults() != expectedNumMales)
            match = false;

        if (actualHampers.get(0).getNumFemaleAdults() != expectedNumFemales)
            match = false;

        if (actualHampers.get(0).getNumChildOver8() != expectedNumChildOver8)
            match = false;

        if (actualHampers.get(0).getNumChildUnder8() != expectedNumChildUnder8)
            match = false;

        assertTrue("The hampers in the order class were not set correctly", match);
    }


    /** 
     * This test compares a manual calculation of nutrional requirements of a hamper configuration
     * to the values stored in a Totals Object. Getters in Totals must return the correct amount of
     * each nutritional requirement
    */
    @Test
    public void testCorrectValuesInTotalsObject(){
        //Test Data with all valid inputs that must be recognized
        int[] input = {1,0,0,1}; //Data contains information for 1 Adult Male, 0 Adult Female, 0 Child Over 8, 1 Child Under 8

        //Status Variable, Expected Values
        double expectedWholeGrain = 4858;
        double expectedFruitsVeggies = 8134;
        double expectedProtein = 7588;
        double expectedOther = 6720;
        double expectedCalories = 27300;
        
        //Create total object, add to each nutrient field (THESE FUNCTION AS SETTERS)
        Totals total = new Totals();

        total.addToGrain(7*2500*0.16*input[0]);
        total.addToFV(7*2500*0.28*input[0]);
        total.addToProtein(7*2500*0.26*input[0]);
        total.addToOther(7*2500*0.30*input[0]);
        total.addToCalories(7 * 2500 * input[0]);

        total.addToGrain(7*2000*0.16*input[1]);
        total.addToFV(7*2000*0.28*input[1]);
        total.addToProtein(7*2000*0.26*input[1]);
        total.addToOther(7*2000*0.30*input[1]);
        total.addToCalories(7 * 2000 * input[1]);

        total.addToGrain(7*2200*0.21*input[2]);
        total.addToFV(7*2200*0.33*input[2]);
        total.addToProtein(7*2200*0.31*input[2]);
        total.addToOther(7*2200*0.15*input[2]);
        total.addToCalories(7 * 2200 * input[2]);

        total.addToGrain(7*1400*0.21*input[3]);
        total.addToFV(7*1400*0.33*input[3]);
        total.addToProtein(7*1400*0.31*input[3]);
        total.addToOther(7*1400*0.15*input[3]);
        total.addToCalories(7*1400 * input[3]);

        //Test values
        assertEquals("The tested Whole Grain total does not match the expected value. Expected: 74", expectedWholeGrain, total.getTotalGrain(),0.1);
        assertEquals("The tested Fruits and Veggies total does not match the expected value. Expected: 122", expectedFruitsVeggies, total.getTotalFV(),0.1);
        assertEquals("The tested Protein total does not match the expected value. Expected: 144", expectedProtein, total.getTotalProtein(),0.1);
        assertEquals("The tested Other total does not match the expected value. Expected: 90", expectedOther, total.getTotalOther(),0.1);
        assertEquals("The tested Calories total does not match the expected value. Expected: 8100", expectedCalories, total.getTotalCalories(),0.1);
    }


    /**
     * This method tests that the CLIENTID is properly correlated with the right type of client. 
     * Adult male should be 1, adult female should be 2, child over eight should be 3, and child
     * under eight should be 4.
    */
    @Test
    public void testCorrectClientID(){
        //Expected Values
        int expectedMaleClientID = 1;
        int exceptedFemaleClientID = 2;
        int expectedChildOverID = 3;
        int expectedChildUnderID = 4;
      
        //Test ClientId getter getter in the various client classes
        assertEquals("Incorrect CLIENTID for a Male Adult, Expected: 1", expectedMaleClientID, MaleAdultNutrients.getClientId());
        assertEquals("Incorrect CLIENTID for a Female Adult, Expected: 2", exceptedFemaleClientID, FemaleAdultNutrients.getClientId());
        assertEquals("Incorrect CLIENTID for a Child Over 8, Expected: 3", expectedChildOverID, ChildOver8Nutrients.getClientId());
        assertEquals("Incorrect CLIENTID for a Child Under 8, Expected: 4", expectedChildUnderID, ChildUnder8Nutrients.getClientId());
    }



    /**
     * This method tests that the number of each client is correct within each client class with a given input 
    */
    @Test
    public void getNumberofClientsfromNutrients(){
        //Expected Values
        int expectedNumberOfMales = 1;
        int expectedNumberOfFemales = 2;
        int expectedNumberOfChildrenOver8 = 2;
        int expectedNumberOfChildrenUnder8 = 1;

        //Create various client objects for testing
        MaleAdultNutrients maleClientObj = new MaleAdultNutrients(1);
        FemaleAdultNutrients femaleClientObj = new FemaleAdultNutrients(2);
        ChildOver8Nutrients childUnder8Obj = new ChildOver8Nutrients(2);
        ChildUnder8Nutrients childOver8Obj = new ChildUnder8Nutrients(1);
        
        //Test each getter in the various client classes
        assertEquals("Incorrect Number of Males Adults", expectedNumberOfMales, maleClientObj.getNumMales());
        assertEquals("Incorrect Number of Female Adults", expectedNumberOfFemales, femaleClientObj.getNumFemale());
        assertEquals("Incorrect Number of Children Over 8", expectedNumberOfChildrenOver8, childUnder8Obj.getNumChildOver8());
        assertEquals("Incorrect Number for a Children Under 8", expectedNumberOfChildrenUnder8, childOver8Obj.getNumChildUnder8());
    }


    /**
     * This method tests that the number of each client is correct within each client class with a given input 
    */
    @Test
    public void testCorrectParametersInFood(){
        //Testing variables
        int ItemID = 23;
        String name = "test food";
        double grain = 10;
        double fv = 10;
        double protein = 10;
        double other = 10;
        double calories = 40;

        Food test = new Food(ItemID, name, grain, fv, protein, other, calories);

        assertEquals("Food Object does not contain expected ItemID", ItemID, test.getItemID());
        assertEquals("Food Object does not contain expected name", name, test.getItemName());
        assertEquals("Food Object does not contain expected grain content", 4, test.getWholeGrains(), 0);
        assertEquals("Food Object does not contain expected FV content", 4, test.getFruitsVeggies(), 0);
        assertEquals("Food Object does not contain expected protein content", 4, test.getProteins(), 0);
        assertEquals("Food Object does not contain expected other content", 4, test.getOthers(), 0);
        assertEquals("Food Object does not contain expected calories", calories, test.getCalories(), 0);
    }


    /**
     * Test to ensure values and types are correctly set by the HamperInventory constructor
     */
    @Test
    public void testHamperInventoryConstructor(){
        //Testing variables
        Totals total = new Totals();
        ArrayList<Food> testFood = new ArrayList<Food>();

        //Status Variables
        boolean match1 = false;
        boolean match2 = false;

        //Create HamperInventory Object
        HamperInventory test = new HamperInventory(total, testFood);

        match1 = test.getTotals() instanceof Totals;
        match2 = test.getAvailableFoods() instanceof ArrayList<?>;

        assertTrue("Totals object was incorrectly set in the HamperInventory constructor", match1);
        assertTrue("List of available foods was incorrectly set in the HamperInventory constructor", match2);
    }


    /**
     *This method tests if the algorithem returned the most efficient Hamper based of the requirements
    */
    @Test 
    public void testCalculateMostEfficientHamper(){
        boolean expected = true;
        //Create total object, add to each nutrient field
        Totals total = new Totals();
        total.addToGrain(5);
        total.addToFV(5);
        total.addToProtein(7);
        total.addToOther(3);

        //Create Food objects to add to availible Foods ArrayList
        Food food1 = new Food(1, "food1",3,4,5,6,25);
        Food food2 = new Food(2, "food2",2,3,4,1,10);
        Food food3 = new Food(3, "food3",3,2,3,2,10);
        ArrayList<Food> availableFood =  new ArrayList<Food>();
        availableFood.add(food1);
        availableFood.add(food2);
        availableFood.add(food3);


        //Create ArrayList expectedHamper which holds the correct Foods 
        ArrayList<ArrayList<String>> expectedHamper = new ArrayList<ArrayList<String>>();
        ArrayList<String> fd2= new ArrayList<String>();
        ArrayList<String> fd3= new ArrayList<String>();
        fd2.add(food2.getItemName());
        fd2.add(Integer.toString(food2.getItemID()));
        fd3.add(food3.getItemName());
        fd3.add(Integer.toString(food3.getItemID()));

        expectedHamper.add(fd2);
        expectedHamper.add(fd3);
        
        HamperInventory inventory = new HamperInventory(total, availableFood);

        //Create Iterator to iterate through  inventory and retrieve most efficient hamper 
        try{
        inventory.determineFoodNeeded();
        Iterator<ArrayList<String>> iter = inventory.getAllFood().iterator();
            int counter = 0;
            while(iter.hasNext()){
                ArrayList<String> current = iter.next();
                //Check if actual hampers match expected hampers
                if(current.get(0).equals(expectedHamper.get(0).get(0))&& current.get(1).equals(expectedHamper.get(0).get(1))){
                   counter++;
                }
                if(current.get(0).equals(expectedHamper.get(1).get(0))&& current.get(1).equals(expectedHamper.get(1).get(1))){
                    counter++;
                }
            }
            //If there is not 2 hampers, set to false
            if (counter != 2){
                expected = false;
            }
        }catch(Exception e){}
        //test
        assertTrue("The expected hamper and the calculated hamper were not the same", expected);
    }


    /**
     * This method tests if the NotEnoughFoodException was correctly thrown when there was not enough food available 
    */
    @Test 
    public void testNotEnoughFoodExceptionBadData(){
        //Status Variable
        boolean expected = false;
        //Create total object, add to each nutrient field
        Totals total = new Totals();
        total.addToGrain(100);
        total.addToFV(100);
        total.addToProtein(100);
        total.addToOther(100);

        //Create Food objects to add to availible Foods ArrayList
        Food food1 = new Food(1, "food1",3,4,5,6,25);
        Food food2 = new Food(2, "food2",2,3,4,1,10);
        Food food3 = new Food(3, "food3",3,2,3,2,10);

        //Add test foods to available food list
        ArrayList<Food> availableFood =  new ArrayList<Food>();
        availableFood.add(food1);
        availableFood.add(food2);
        availableFood.add(food3);

        //Test for exception thrown
        try{
            HamperInventory inventory = new HamperInventory(total, availableFood);
            inventory.determineFoodNeeded();
        }
        catch(NotEnoughFoodException e){
            expected = true;
        }
        assertTrue("NotEnoughFoodException was not thrown when not enough food was available", expected);
    }


    /**
     *This method tests if the NotEnoughFoodException not thrown when there was enough food available 
    */
    @Test 
    public void testNotEnoughFoodExceptionGoodData(){
        //Status Variables
        boolean expected = true;
        //Create total object, add to each nutrient field
        Totals total = new Totals();
        total.addToGrain(0);
        total.addToFV(0);
        total.addToProtein(0);
        total.addToOther(0);

        //Create Food objects to add to availible Foods ArrayList
        Food food1 = new Food(1, "food1",3,4,5,6,25);
        Food food2 = new Food(2, "food2",2,3,4,1,10);
        Food food3 = new Food(3, "food3",3,2,3,2,10);

        //Add foods to available foods list
        ArrayList<Food> availableFood =  new ArrayList<Food>();
        availableFood.add(food1);
        availableFood.add(food2);
        availableFood.add(food3);

        //Test for exception
        try{
            HamperInventory inventory = new HamperInventory(total, availableFood);
            inventory.determineFoodNeeded();
        }
        catch(NotEnoughFoodException e){
            expected = false;
        }

        assertTrue("NotEnoughFoodException was incorrectly thrown when there was enough food available", expected);

    }
}
    