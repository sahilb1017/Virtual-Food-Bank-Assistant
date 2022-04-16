/**
@author Sahil Bhatt
@author Harshal Patel
@author Siwon Kim
@author Abhiraam Manchiraju    

<a href="mailto:sahil.bhatt@ucalgary.ca"> sahil.bhatt@ucalgary.ca</a>
<a href="mailto:harshal.patel@ucalgary.ca"> harshal.patel@ucalgary.ca</a>
<a href="mailto:siwon.kim@ucalgary.ca"> siwon.kim@ucalgary.ca</a>
<a href="mailto:abhiraam.manchiraju@ucalgary.ca"> abhiraam.manchiraju@ucalgary.ca</a>

@version 1.4
@since 1.0
*/


package edu.ucalgary.ensf409;
import java.sql.*;
import java.util.ArrayList;
public class Database {
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;    
    
    private Connection dbConnect;
    private ResultSet results;

    /**
     * The constructor that sets the URL of the database, along with setting the username and password
     * of the database. Calls initializeConnection() which sets up a connection to the database
     * @param none
    */
    
    public Database(){
        // Database URL
        this.DBURL = "jdbc:mysql://localhost/food_inventory";
        //  Database credentials
        this.USERNAME = "student";
        this.PASSWORD = "ensf";

        initializeConnection();
    }

    /**
     * This method initializes the connection to the database with variables set in the class
     * @param none
    */
    public void initializeConnection(){
        try{
            //Establish connection with database with class variables
            dbConnect = DriverManager.getConnection(this.DBURL , this.USERNAME,this.PASSWORD);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * This method initializes the connection to the database with variables set in the class
     * @param clientID Integer from 1-4 that represents the type of client
    */

    public int[] getClientNeeds(int clientID){
        int[] values = new int[5];
        String[] types = {"WholeGrains", "FruitVeggies", "Protein", "Other", "Calories"};

        //Create a query for the database
        String query = "SELECT WholeGrains, FruitVeggies, Protein, Other, Calories from DAILY_CLIENT_NEEDS WHERE ClientID = " + Integer.toString(clientID);

        try{
            Statement myStmt = dbConnect.createStatement();
            //Execute SQL query
            results = myStmt.executeQuery(query);
            results.next();

            //Loop through the "types" list to get caloric counts for all the categories for a type of client
            for(int i = 0; i < 5; i++){
                values[i] = results.getInt(types[i]);
            }

            //Close query
            myStmt.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return values;
    }

    /**
     * This method accesses the database and obtains all of the food from the "AVAILABLE_FOOD"
     * table. A food object is created for every food in the database, and then stored in
     * an arraylist.
     * @param none
    */
    public ArrayList<Food> getAvailableFood(){
        //Initialize the arraylist of food objects
        ArrayList<Food> allFoods = new ArrayList<Food>();

        //Create query to select foods from the "AVAILABLE_FOOD" table
        String query = "SELECT * FROM AVAILABLE_FOOD";

        try{
            Statement myStmt = dbConnect.createStatement();
            //Execute SQL query
            results = myStmt.executeQuery(query);
            
            //loop through all foods in the table, obtain their information 
            while(results.next()){
                int itemID = results.getInt("ItemID");
                String name = results.getString("Name");
                int grain = results.getInt("GrainContent");
                int fv = results.getInt("FVContent");
                int protein = results.getInt("ProContent");
                int other = results.getInt("Other");
                int calories = results.getInt("Calories");

                //Store obtained information into a food object and append to arraylist
                allFoods.add(new Food(itemID, name, (double)grain, (double)fv, (double)protein, (double)other, (double)calories));
            }
            myStmt.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return allFoods;
    }

    /**
     * This method takes in an itemID, finds the food that matches that ID, and removes that
     * food from the database
     * @param itemID The id of the food item that will be deleted
    */
    public void deleteUsedFoods(int itemID){
        //Generate query for removing foood iterm
        String query = "DELETE FROM AVAILABLE_FOOD where ItemID = ?";

        try{
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            
            //Remove food from database, and update database
            myStmt.setString(1, Integer.toString(itemID));
            myStmt.executeUpdate();
            myStmt.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    /**
     * This method closes the connection to the database
     * @param none
    */
    public void close() {
        try{
            results.close(); //close resultset
            dbConnect.close(); //close connection
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    } 
}
