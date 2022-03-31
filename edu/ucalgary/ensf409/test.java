package edu.ucalgary.ensf409;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class test {
    
    

    @Test
    public void testAddHamper(){
        
        boolean exceptionThrown = false;
        correctInput = {1,1,1,1};

        try{
        public Order testObject1 = new Order();
        public Hamper expectedHamper = new Hamper(correctInput);
        } catch (Exception e) {
            exceptionThrown = true;
        }

        testObject1.AddHamper(correctInput);
        Hamper actualHamper = testObject1.getHamper(0);

        assertFalse("InvalidArgumentException was incorrectly thrown when the Order constructor was given valid data", exceptionThrown);
        assertEquals("Hamper not added correctly", testHamper, actualHamper);
    }

    @Test
    public void testGetHampers(){

        boolean exceptionThrown = false;
        correctInput1 = {1,2,3,4};
        correctInput2 = {2,2,2,2};
        correctInput3 = {2,1,4,3};
        ArrayList<Hamper> expectedHampers = new ArrayList<Hamper>();

        try{

            
            public Hamper hamper1 = new Hamper(correctInput1);
            public Hamper hamper2 = new Hamper(correctInput2);
            public Hamper hamper3 = new Hamper(correctInput3);

            expectedHamper.add(hamper1);
            expectedHamper.add(hamper2);
            expectedHamper.add(hamper3);

            public Order = testOrder = new Order();

            testOrder.addHamper(correctInput1);
            testOrder.addHamper(correctInput2);
            testOrder.addHamper(correctInput3);


        }catch(Exception e){
            exceptionThrown = true;
        }

        ArrayList<Hamper> actualHampers = testOrder.getHampers();

        assertThat("The correct hampers were not obtained", expectedHampers, is(equalTo(actualHampers)));
        
    }
}
