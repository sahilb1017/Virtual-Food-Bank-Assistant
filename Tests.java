package edu.ucalgary.ensf409;

import org.hamcrest.core.IsInstanceOf;
import org.junit.*;
import org.junit.runner.OrderWithValidator;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

// ******NOTE*****
//NotEnoughFoodException cannot be tested easily within this suite, this requires the database to be empty, and thus must
//be tested separatley after all other tests are ran. This test will not be included within this suite and will instead
//be tested sepearatley

/* *********** Tests for All Classes *********** */
public class Tests{
    /*
     * This method tests the creation of a Hamper object with invalid data. 
     * Order.addHamper(int[]) should cause an exception to be thrown
    */
    @Test
    public void testOrderBadInputThrowsException(){
        //Test Data, last element of array indicates bad data (No negative people)
        int[] invalidInput = {0,2,3,-1};

        //Status Variable
        boolean exceptionThrown = true;

        //Create Order object, add Hamper using invalid data
        Order test = new Order();
        try{
            test.addHamper(invalidInput);
            exceptionThrown = false;
        }
        catch(Exception e){
        }

        //Test if exception is thrown
        assertTrue("InvalidArgumentException was incorrectly thrown when addHamper() was given valid data", exceptionThrown);
    }


    /*
     * This method tests the creation of a Hamper object with valid data. 
     * Order.addHamper(int[]) should NOT cause an exception to be thrown
    */
    @Test
    public void testOrderGoodInputNoException(){
        //Test Data with all valid inputs that must be recognized
        int[] validInput = {0,2,3,3};

        //Status Variable
        boolean exceptionThrown = false;

        //Create Order object, add Hamper using valid data
        Order test = new Order();
        try{
            test.addHamper(validInput);
        }
        catch(Exception e){
            exceptionThrown = true;
        }

        //Test if exception is thrown
        assertFalse("InvalidArgumentException was incorrectly thrown when addHamper() was given valid data", exceptionThrown);
    }


    /*
     * This method tests for the correct return type when the getHampers() method is called from an Order Object
     * Order.addHamper(int[]) is called with valid data and should NOT cause an exception to be thrown
     * Order.getHampers() must return correct type (ArrayList<Hampers>)
    */
    @Test
    public void testOrderReturnTypeGetHampers(){
        //Test Data with all valid inputs that must be recognized
        int[] validInput = {1,1,2,2};

        //Status Variable
        boolean exceptionThrown = false;

        //Create Order object, add Hamper using valid data
        Order test = new Order();
        try{
            test.addHamper(validInput);
        }
        catch(Exception e){
            exceptionThrown = true;
        }

        //Test if exception is thrown
        assertFalse("InvalidArgumentException was incorrectly thrown when addHamper() was given valid data", exceptionThrown);

        //Check if return type is correct
        assertThat("Incorrect type returned from getHampers() method in Order class", new ArrayList<Hamper>, instanceOf(test.getHampers));
    }


    /*
     * This method tests if a Hamper object was correctly created and added to the ArrayList of Hampers in Order
     * Order.addHamper(int[]) is called with valid data and should NOT cause an exception to be thrown
     * Order.getHamper must return the correct Hamper object
    */   
    @Test
    public void testOrderAddHamper(){
        //Test Data with all valid inputs that must be recognized
        int[] correctInput = {1,1,1,1};
        
        //Status Variable
        boolean exceptionThrown = false;

        //Create Order object, add Hamper using valid data
        Hamper expectedHamper;
        Order testObject1 = new Order();
        try{
            testObject1.AddHamper(correctInput);
            expectedHamper = new Hamper(correctInput);
        } catch (Exception e) {
            exceptionThrown = true;
        }

        Hamper actualHamper = testObject1.getHamper(0);

        assertFalse("InvalidArgumentException was incorrectly thrown when addHamper() was given valid data", exceptionThrown);
        assertEquals("Hamper not added correctly", expectedHamper, actualHamper);
    }


    /*
     * This method tests the creation of multiple Hampers in the Order Object and checks that each Hamper
     * added to the ArrayList is correct
     * Order.addHamper(int[]) is called with sets of valid data and should not cause an exception to be thrown
     * Order.getHamper at each index must return the correctHamper object
    */  
    @Test
    public void testOrderGetHampers(){
        //Test Data with all valid inputs that must be recognized
        int[] correctInput1 = {1,2,3,4};
        int[] correctInput2 = {2,2,2,2};
        int[] correctInput3 = {2,1,4,3};

        //Status Variable
        boolean exceptionThrown = false;

        //Create Order object, add Hampers using valid data to Order
        //Create ArrayList of expected hampers for comparison
        Order testOrder = new Order();
        Hamper hamper1;
        Hamper hamper2;
        Hamper hamper3;
        try{
            hamper1 = new Hamper(correctInput1);
            hamper2 = new Hamper(correctInput2);         
            hamper3 = new Hamper(correctInput3);

            testOrder.addHamper(correctInput1);
            testOrder.addHamper(correctInput2);
            testOrder.addHamper(correctInput3);
        }catch(Exception e){
            exceptionThrown = true;
        }

        //Retrieve ArrayList of Hampers and get each specifc Hamper
        ArrayList<Hamper> actualHampers = testOrder.getHampers();

        Hamper actualHamper1 = actualHampers.get(0);
        Hamper actualHamper2 = actualHampers.get(1);
        Hamper actualHamper3 = actualHampers.get(2);

        //Compare Hampers with expected ones
        assertFalse("InvalidArgumentException was incorrectly thrown when addHamper() was given valid data", exceptionThrown);
        assertEquals("The correct hampers were not obtained from the Order object", actualHamper1, hamper1);
        assertEquals("The correct hampers were not obtained from the Order object", actualHamper2, hamper2);
        assertEquals("The correct hampers were not obtained from the Order object", actualHamper3, hamper3);
    }


    /*
     * This method tests whether the Hamper Object contains the correct number of each type of client.
     * Order.addHamper(int[]) is called with valid data and should NOT cause an exception to be thrown
     * Values passed through must be correctly returned in the created hamper object
    */
    @Test
    public void testOrderHamperCorrectNumberOfClients(){
        //Test Data with all valid inputs that must be recognized
        int[] validInput = {1,2,3,4};

        //Status Variable
        boolean exceptionThrown = false;

        //Create Order object, add Hamper using valid data
        Order test = new Order();
        try{
            test.addHamper(validInput);
        }
        catch(Exception e){
            exceptionThrown = true;
        }

        //Get number of each client from the created Order and Hamper Objects
        int numMale = test.getHamper(0).getNumMaleAdults();
        int numFemale = test.getHamper(0).getNumFemaleAdults();
        int numChildOver8 = test.getHamper(0).getNumChildOver();
        int numChildUnder8 = test.getHamper(0).getNumUnderOver();

        //Test actual values with expected ones
        assertFalse("InvalidArgumentException was incorrectly thrown when addHamper() was given valid data", exceptionThrown);
        assertEquals("Incorrect Number of Adult Males retrieved from Hamper. Expected Value: 1", test.getHamper(0).getNumMaleAdults(), validInput[0]);
        assertEquals("Incorrect Number of Adult Females retrieved from Hamper. Expected Value: 2", test.getHamper(0).getNumFemaleAdults(), validInput[1]);
        assertEquals("Incorrect Number of Children Over 8 retrieved from Hamper. Expected Value: 3", test.getHamper(0).getNumChildOver(), validInput[2]);
        assertEquals("Incorrect Number of Children Under 8 retrieved from Hamper. Expected Value: 4", numChildUnder8, validInput[3]);
    }


    /*
     * Order() is initiliazed
     * Order.addHamper(int[]) is called with sets of valid data and should not cause an exception to be thrown
     * HamperInventory object inside of Hamper object should return the correct type ArrayList<String[][]>
    */  
    @Test
    public void testHamperInventoryReturnsCorrectType(){
        //Test Data with all valid inputs that must be recognized
        int[][] validInput = {{1,1,2,2}, {1,2,2,3}};
        
        //Status Variable
        boolean exceptionThrown = false;

        //Create Order object, add Hampers using valid data to Order
        Order test = new Order();
        try{
            test.addHamper(validInput[0]);
            test.addHamper(validInput[1]);
        }
        catch(Exception e){
            exceptionThrown = true;
        }

        //Test return type
        assertFalse("InvalidArgumentException was incorrectly thrown when addHamper() was given valid data", exceptionThrown);
        assertThat("Incorrect type returned from getHampers() method in Order class", new ArrayList<String[][]>(), instanceOf(test.getHamper(0).getInventory().getAllFoods()));
    }


    /** 
     * This test compares a manual calculation of nutritional requirements versus the calculateTotal() 
     * method for the nutritional requirements of a 4-person family.
     * Order.addHamper(int[]) is called with valid data and should NOT cause an exception to be thrown
     * Values are tested using the Totals Object stored in the created Hamper that exists in Order
    */
    @Test
    public void testCorrectValuesInTotalsObject(){
        //Test Data with all valid inputs that must be recognized
        int[] input = {1,1,1,1}; //Data contains information for 1 Adult Male, 1 Adult Female, 1 Child Over 8, 1 Child Under 8

        //Status Variable, Expected Values
        boolean exceptionThrown = false;
        int expectedWholeGrain = 74;
        int expectedFruitsVeggies = 122;
        int expectedProtein = 114;
        int expectedOther = 90;
        int expectedCalories = 8100;
        
        //Create Order object, add Hamper using valid data to Order
        Order testObject1 = new Order();
        try{
            testObject1.addHamper(input);
        }
        catch(Exception e){
            exceptionThrown = true;
        }
            
        //Test each getter for Totals object
        Totals totalObject = Order.getHamper(0).getTotals();

        assertFalse("InvalidArgumentException was incorrectly thrown when addHamper() was given valid data", exceptionThrown);
        assertEquals("The tested Whole Grain total does not match the expected value. Expected: 74", expectedWholeGrain, totalObject.getTotalGrain());
        assertEquals("The tested Fruits and Veggies total does not match the expected value. Expected: 122", expectedFruitsVeggies, totalObject.getTotalFV());
        assertEquals("The tested Protein total does not match the expected value. Expected: 144", expectedProtein, totalObject.getTotalProtien());
        assertEquals("The tested Other total does not match the expected value. Expected: 90", expectedCalories, totalObject.getTotalOther());
        assertEquals("The tested Calories total does not match the expected value. Expected: 8100", expectedOther, totalObject.getTotalCalories());
    }


    /**
     * This test compares the listed nutritional values for an item in the database and 
     * then compares to the values stored in the Food object corresponding to that item.
     * Utilizes a Food object which stores the information of any particular food item from the database
    */
    @Test
    public void testFoodValuesFromDatabase(){
        //Test Data with valid inputs that must be recognized
        int inputID = 54;
        String input = "Soy protein, 1 kg";
        
        //Status Variable and Expected Values
        boolean exceptionThrown = false;
        int expectedWholeGrain = 0;
        int expectedFruitsVeggies = 0;
        int expectedProtein = 88;
        int expectedOther = 12;
        int expectedCalories = 3350;

        //Create Food object
        Food testObject1;
        try{
            testObject1 = new Food(input);
            //Note: the food constructor will call on the getInfoFromDataBase method, which is why it is not indicated here.
        }
        catch(Exception e){
            exceptionThrown = true;
        }
           
        //Test each getter for Food object
        assertFalse("ItemNotFoundException was incorrectly thrown when the Food constructor was given valid data", exceptionThrown);
        assertEquals("The tested Whole Grain total does not match the expected value. Expected: 0", expectedWholeGrain, testObject1.getWholeGrains());
        assertEquals("The tested Fruits and Veggies total does not match the expected value. Expected: 0", expectedFruitsVeggies, testObject1.getFruitVeggies());
        assertEquals("The tested Protein total does not match the expected value. Expected: 88", expectedProtein, testObject1.getProtein());
        assertEquals("The tested Other total does not match the expected value. Expected: 12", expectedCalories, testObject1.getCalories());
        assertEquals("The tested Calories total does not match the expected value. Expected: 3350", expectedOther,testObject1.getOther());
        assertEquals("The tested Item Name does not match the expected value. Expected: Soy protein, 1 kg", expectedOther,testObject1.getName());
    }


    /**
     * This test attempts to create a Food object with an invalid itemID 
     * Constructor must cause ItemNotFoundException to be thrown
    */
    @Test
    public void testItemNotFoundExceptionWithInvalidData(){
        //Test Data with invalid information (Item does not exist in database)
        int invalidItemID = -23;

        //Status Variable
        boolean exceptionThrown = false;

        //Create Food object
        Food invalidFood;
        try{
            invalidFood = new Food(invalidItemID);
        }
        catch(ItemNotFoundException e){
            exceptionThrown = true;
        }
        assertTrue("ItemNotFoundException was not thrown when the Food constructor was given an invalid input", exceptionThrown);
    }


    /**
     * This test attempts to create a Food object with a valid itemID 
     * Constructor must NOT cause ItemNotFoundException to be thrown
    */
    @Test
    public void testFoodNoExceptionThrownGoodData(){
        //Test Data with valid information (Exists in database)
        int validItemID = 34;

        //Status Variable
        boolean exceptionThrown = true;
        
        //Create Food object
        Food validFood;
        try{
            validFood = new Food(34);
            exceptionThrown = false;
        }
        catch(ItemNotFoundException e){
        }
        assertFalse("ItemNotFoundExceptin was incorrectly thrown when the Food constructor was given a valid input", exceptionThrown);
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

        //Create various client objects for testing
        MaleAdultNutrients maleClientObj = new MaleAdultNutrients(1);
        FemaleAdultNutrients femaleClientObj = new FemaleAdultNutrients(1);
        ChildOver8Nutrients childUnder8Obj = new ChildOver8Nutrients(1);
        ChildUnder8Nutrients childOver8Obj = new ChildUnder8Nutrients(1);
        
        //Test ClientId getter getter in the various client classes
        assertEquals("Incorrect CLIENTID for a Male Adult, Expected: 1", expectedMaleClientID, maleClientObj.getClientId());
        assertEquals("Incorrect CLIENTID for a Female Adult, Expected: 2", exceptedFemaleClientID, femaleClientObj.getClientId());
        assertEquals("Incorrect CLIENTID for a Child Over 8, Expected: 3", expectedChildOverID, childUnder8Obj.getClientId());
        assertEquals("Incorrect CLIENTID for a Child Under 8, Expected: 4", expectedChildUnderID, childOver8Obj.getClientId());
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
        assertEquals("Incorrect Number of Female Adults", expectedNumberOfFemales, femaleClientObj.getFemMales());
        assertEquals("Incorrect Number of Children Over 8", expectedNumberOfChildrenOver8, childUnder8Obj.getNumChild());
        assertEquals("Incorrect Number for a Children Under 8", expectedNumberOfChildrenUnder8, childOver8Obj.getNumChild());
    }
}
    