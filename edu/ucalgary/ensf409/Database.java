package edu.ucalgary.ensf409;
import java.sql.*;
import java.util.ArrayList;
public class Database {
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;    
    
    private Connection dbConnect;
    private ResultSet results;
    
    public Database(){
        // Database URL
        this.DBURL = "jdbc:mysql://localhost/food_inventory";
        //  Database credentials
        this.USERNAME = "student";
        this.PASSWORD = "ensf";

        initializeConnection();
    }

    public void initializeConnection(){
        try{
            //Establish connection with database with class variables
            dbConnect = DriverManager.getConnection(this.DBURL , this.USERNAME,this.PASSWORD);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int[] getClientNeeds(int clientID){
        int[] values = new int[5];
        String[] types = {"WholeGrains", "FruitVeggies", "Protein", "Other", "Calories"};
        String query = "SELECT WholeGrains, FruitVeggies, Protein, Other, Calories from DAILY_CLIENT_NEEDS WHERE ClientID = " + Integer.toString(clientID);

        try{
            Statement myStmt = dbConnect.createStatement();
            //Execute SQL query
            results = myStmt.executeQuery(query);
            results.next();

            for(int i = 0; i < 5; i++){
                values[i] = results.getInt(types[i]);
            }

            myStmt.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return values;
    }

    
    public ArrayList<Food> getAvailableFood(){
        ArrayList<Food> allFoods = new ArrayList<Food>();
        String query = "SELECT * FROM AVAILABLE_FOOD";

        try{
            Statement myStmt = dbConnect.createStatement();
            //Execute SQL query
            results = myStmt.executeQuery(query);
            
            while(results.next()){
                int itemID = results.getInt("ItemID");
                String name = results.getString("Name");
                int grain = results.getInt("GrainContent");
                int fv = results.getInt("FVContent");
                int protein = results.getInt("ProContent");
                int other = results.getInt("Other");
                int calories = results.getInt("Calories");

                allFoods.add(new Food(itemID, name, (double)grain, (double)fv, (double)protein, (double)other, (double)calories));
            }
            myStmt.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return allFoods;
    }

    public void deleteUsedFoods(int itemID){
        String query = "DELETE FROM AVAILABLE_FOOD where ItemID = ?";

        try{
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setString(1, Integer.toString(itemID));
            myStmt.executeUpdate();
            myStmt.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }


    public void close() {
        try{
            results.close(); //close resultset
            dbConnect.close(); //close connection
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    } 
}
