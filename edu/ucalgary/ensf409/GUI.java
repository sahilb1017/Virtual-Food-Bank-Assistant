/**
@author Sahil Bhatt
@author Harshal Patel
@author Siwon Kim
@author Abhiraam Manchiraju    

<a href="mailto:sahil.bhatt@ucalgary.ca"> sahil.bhatt@ucalgary.ca</a>
<a href="mailto:harshal.patel@ucalgary.ca"> harshal.patel@ucalgary.ca</a>
<a href="mailto:siwon.kim@ucalgary.ca"> siwon.kim@ucalgary.ca</a>
<a href="mailto:abhiraam.manchiraju@ucalgary.ca"> abhiraam.manchiraju@ucalgary.ca</a>

@version 2.3
@since 1.0
*/


package edu.ucalgary.ensf409;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.awt.event.ActionEvent;

/**
 * This class creates the graphical user interface that is used to input hamper and order information. The class will open a
 * request form where the user will input their configurations into a form.
*/
public class GUI extends JFrame implements ActionListener{
    private JLabel titleOne;
    private JLabel titleTwo;
    private JLabel subheading;
    private JPanel hamperOrderForm;
    private JPanel outerPanel;

    private JLabel maleText;
    private JLabel femaleText;
    private JLabel childrenOver8Text;
    private JLabel childrenUnder8Text;
    
    private JTextField maleInput;
    private JTextField femaleInput;
    private JTextField childrenOver8Input;
    private JTextField childrenUnder8Input;
    
    private JButton addHamperButton;
    private JButton clearHampersButton;
    private JButton clearInputButton;
    private JButton deleteHamperButton;
    private JButton submitOrderButton;
    private JScrollPane tableScrollPanel;
    private JTable hamperOrderTable;
    
    /**
     * The only construcutor for the GUI class that is responsible for titling the GUI window, and calls upon
     * initializeGUI() to display all the components which will be visible to the user.
     * @param none
    */
    public GUI() {
        super("Example Food Bank Hamper Request Form");
        initializeGUI();
    }


    /**
     * Method that is reponsible for displaying all of the components onto the GUI that the user will see and 
     * interact with. This includes labels, text fields, tables, and buttons. Additionally, this method will
     * add action listeners to the buttons in the GUI.
     * @param none
    */          
    private void initializeGUI() {
        /*
        Initializes the heading and subheading along with creating the 2 panels that will contain the components. The hamperOrderForm panel
        will contain the order form where the user fills in the numbers for each type of person. The hamperOrderForm panel will sit on top of
        the outerPanel which is what will contain the table representing all of the hamper requests in one order.
        */
        titleOne = new JLabel();
        titleTwo = new JLabel();
        subheading = new JLabel();
        hamperOrderForm = new JPanel();
        outerPanel = new JPanel();

        //Initializes the labels for each type of person
        maleText = new JLabel();
        femaleText = new JLabel();
        childrenOver8Text = new JLabel();
        childrenUnder8Text = new JLabel();

        //Initializes the text fields for each type of person
        maleInput = new JTextField();
        femaleInput = new JTextField();
        childrenOver8Input = new JTextField();
        childrenUnder8Input = new JTextField();

        //Initializes all of the buttons
        addHamperButton = new JButton();
        clearInputButton = new JButton();
        deleteHamperButton = new JButton();
        clearHampersButton = new JButton();
        submitOrderButton = new JButton();

        //Initializes the table that will contain all the orders, and the panel that the table will be on
        tableScrollPanel = new JScrollPane();
        hamperOrderTable = new JTable();

        //Allows the closing of the GUI window, and prevents the window from being resizable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 

        /*
        Sets the color of the two panels, where the outer panel is a lighter yellow and the hamperOrderForm is a darker
        shade of yellow 
        */
        outerPanel.setBackground(new Color(252, 255, 212));
        hamperOrderForm.setBackground(new Color(250, 252, 182));

        //Configuring the appearance of the scroll panel by changing the background color, adding a border, and preferred size
        tableScrollPanel.setViewportView(hamperOrderTable);
        tableScrollPanel.getViewport().setBackground(new Color(254, 253, 233));
        tableScrollPanel.setBorder(BorderFactory.createLineBorder(new Color(121, 103, 58), 3));
        tableScrollPanel.setPreferredSize(new Dimension(452, 403));
        
        /*
        Configuring the appearance of the table on the scroll panel by changing the background color, adding a border, 
        and setting a font
        */
        hamperOrderTable.setBackground(new Color(254, 253, 233));
        hamperOrderTable.setForeground(new Color(123, 106, 62));
        hamperOrderTable.setFont(new Font("Myanmar Text", 1, 15)); 
        
        //Creating a the cells in the table and setting the column headings
        hamperOrderTable.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"     Adult Males", "   Adult Females", " Children Over 8", "Children Under 8"}
        ) 
        //Setting the editting permissions for the table and cells
        {boolean[] canEdit = new boolean [] {false, false, false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex){return canEdit [columnIndex];}
        });

        //Setting the row height for the table to be 30 pixels
        hamperOrderTable.setRowHeight(30);

        //Preventing the columns from being ordered or changed by the user
        hamperOrderTable.getTableHeader().setReorderingAllowed(false);
        hamperOrderTable.getColumnModel().getColumn(0).setResizable(false);
        hamperOrderTable.getColumnModel().getColumn(1).setResizable(false);
        hamperOrderTable.getColumnModel().getColumn(2).setResizable(false);
        hamperOrderTable.getColumnModel().getColumn(3).setResizable(false);
        
        //Only display the horizontal lines on the table
        hamperOrderTable.setShowHorizontalLines(true);

        //Setting the color of the horizontal lines on the table
        hamperOrderTable.setGridColor(new Color(121, 103, 58));

        //Setting the color of the row when it has been clickedon
        hamperOrderTable.setSelectionBackground(new Color(121, 103, 58));

        //Setting the background color of the table header
        DefaultTableCellRenderer head_render = new DefaultTableCellRenderer(); 
        head_render.setBackground(new Color(230,211,163));

        //Center aligning the text of the table header
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        //Center aligning the text of the table header
        for (int i = 0; i < hamperOrderTable.getModel().getColumnCount(); i++) {
            hamperOrderTable.getColumnModel().getColumn(i).setHeaderRenderer(head_render);
            hamperOrderTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        //Setting the font and color for all the text labels on the hamper order form
        titleOne.setFont(new Font("Corbel Light", 1, 36)); 
        titleOne.setForeground(new Color(190, 164, 98));
        titleOne.setText("HAMPER ORDER ");

        titleTwo.setFont(new Font("Corbel Light", 1, 36)); 
        titleTwo.setForeground(new Color(190, 164, 98));
        titleTwo.setText("FORM");

        subheading.setFont(new Font("Myanmar Text", 1, 18)); 
        subheading.setForeground(new Color(123, 106, 62));
        subheading.setText("ENTER HAMPER INFORMATION");

        maleText.setFont(new Font("Myanmar Text", 0, 14)); 
        maleText.setForeground(new Color(119, 120, 103));
        maleText.setText("NUMBER OF MALE ADULTS");

        femaleText.setFont(new Font("Myanmar Text", 0, 14)); 
        femaleText.setForeground(new Color(119, 120, 103));
        femaleText.setText("NUMBER OF FEMALE ADULTS");

        childrenOver8Text.setFont(new Font("Myanmar Text", 0, 14)); 
        childrenOver8Text.setForeground(new Color(119, 120, 103));
        childrenOver8Text.setText("NUMBER OF CHILDREN OVER 8");

        childrenUnder8Text.setFont(new Font("Myanmar Text", 0, 14)); 
        childrenUnder8Text.setForeground(new Color(119, 120, 103));
        childrenUnder8Text.setText("NUMBER OF CHILDREN UNDER 8");

        //Setting the fonts and color for all the text fields on the hamper order form
        maleInput.setBackground(new Color(230, 211, 163));
        maleInput.setFont(new Font("Myanmar Text", 1, 15)); 
        maleInput.setForeground(new Color(123, 106, 62));
        maleInput.setPreferredSize(new Dimension(70, 29));
        maleInput.setHorizontalAlignment(JTextField.CENTER);
        maleInput.setBorder(BorderFactory.createLineBorder(new Color(190, 171, 123),2));
 
        femaleInput.setBackground(new Color(230, 211, 163));
        femaleInput.setFont(new Font("Myanmar Text", 1, 15)); 
        femaleInput.setForeground(new Color(123, 106, 62));
        femaleInput.setPreferredSize(new Dimension(70, 29));
        femaleInput.setHorizontalAlignment(JTextField.CENTER);
        femaleInput.setBorder(BorderFactory.createLineBorder(new Color(190, 171, 123),2));

        childrenOver8Input.setBackground(new Color(230, 211, 163));
        childrenOver8Input.setFont(new Font("Myanmar Text", 1, 15)); 
        childrenOver8Input.setForeground(new Color(123, 106, 62));
        childrenOver8Input.setPreferredSize(new Dimension(70, 29));
        childrenOver8Input.setHorizontalAlignment(JTextField.CENTER);
        childrenOver8Input.setBorder(BorderFactory.createLineBorder(new Color(190, 171, 123),2));

        childrenUnder8Input.setBackground(new Color(230, 211, 163));
        childrenUnder8Input.setFont(new Font("Myanmar Text", 1, 15));
        childrenUnder8Input.setForeground(new Color(123, 106, 62));
        childrenUnder8Input.setPreferredSize(new Dimension(70, 29));
        childrenUnder8Input.setHorizontalAlignment(JTextField.CENTER);
        childrenUnder8Input.setBorder(BorderFactory.createLineBorder(new Color(190, 171, 123),2));

        //Setting the colors, text and size for all of the buttons
        addHamperButton.setBackground(new Color(123, 106, 62));
        addHamperButton.setFont(new Font("Myanmar Text", 1, 14)); 
        addHamperButton.setForeground(new Color(255, 255, 255));
        addHamperButton.setText("ADD HAMPER CONFIGURATION");
        addHamperButton.setPreferredSize(new Dimension(194, 29));
        addHamperButton.setBorder(BorderFactory.createLineBorder(new Color(178, 161, 117),4));

        clearInputButton.setBackground(new Color(255, 102, 102));
        clearInputButton.setFont(new Font("Myanmar Text", 1, 14)); 
        clearInputButton.setForeground(new Color(255, 255, 255));
        clearInputButton.setText("CLEAR INPUTS");
        clearInputButton.setBorder(BorderFactory.createLineBorder(new Color(255, 122, 122),4));

        deleteHamperButton.setBackground(new Color(255, 102, 102));
        deleteHamperButton.setFont(new Font("Myanmar Text", 1, 14)); 
        deleteHamperButton.setForeground(new Color(255, 255, 255));
        deleteHamperButton.setText("DELETE HAMPER(S)");
        deleteHamperButton.setBorder(BorderFactory.createLineBorder(new Color(255, 122, 122),4));

        clearHampersButton.setBackground(new Color(255, 102, 102));
        clearHampersButton.setFont(new Font("Myanmar Text", 1, 14)); 
        clearHampersButton.setForeground(new Color(255, 255, 255));
        clearHampersButton.setText("CLEAR ALL HAMPERS");
        clearHampersButton.setBorder(BorderFactory.createLineBorder(new Color(255, 122, 122),4));

        submitOrderButton.setBackground(new Color(115, 203, 107));
        submitOrderButton.setFont(new Font("Myanmar Text", 1, 24)); 
        submitOrderButton.setForeground(new Color(255, 255, 255));
        submitOrderButton.setText("SUBMIT ORDER");
        submitOrderButton.setBorder(BorderFactory.createLineBorder(new Color(165, 253, 157),4));
        
        //Adding action listeners to all of the buttons
        addHamperButton.addActionListener(this);
        clearInputButton.addActionListener(this);
        deleteHamperButton.addActionListener(this);
        clearHampersButton.addActionListener(this);
        submitOrderButton.addActionListener(this);

        //Creating a grouplayout for the hampeOrderForm panel
        GroupLayout hamperOrderFormLayout = new GroupLayout(hamperOrderForm);
        hamperOrderForm.setLayout(hamperOrderFormLayout);
        
        //Setting the horizontal layout for the hampeOrderForm panel
        hamperOrderFormLayout.setHorizontalGroup(
            hamperOrderFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(hamperOrderFormLayout.createSequentialGroup()
                .addGroup(hamperOrderFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(hamperOrderFormLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.LEADING, hamperOrderFormLayout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(hamperOrderFormLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(titleOne)
                                .addComponent(subheading)))
                        .addGroup(hamperOrderFormLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(hamperOrderFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(childrenOver8Text)
                                .addComponent(childrenUnder8Text)
                                .addComponent(femaleText)
                                .addComponent(maleText))
                            .addGap(18, 18, 18)
                            .addGroup(hamperOrderFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(maleInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(femaleInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(childrenUnder8Input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(childrenOver8Input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(hamperOrderFormLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(titleTwo))
                    .addGroup(hamperOrderFormLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(addHamperButton, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
                    .addGroup(hamperOrderFormLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(clearInputButton)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        //Setting the vertical layout for the hampeOrderForm panel
        hamperOrderFormLayout.setVerticalGroup(
            hamperOrderFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(hamperOrderFormLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(titleOne)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleTwo)
                .addGap(46, 46, 46)
                .addComponent(subheading)
                .addGap(39, 39, 39)
                .addGroup(hamperOrderFormLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(maleText)
                    .addComponent(maleInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(hamperOrderFormLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(femaleText)
                    .addComponent(femaleInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(hamperOrderFormLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(childrenOver8Input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(childrenOver8Text))
                .addGap(18, 18, 18)
                .addGroup(hamperOrderFormLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(childrenUnder8Input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(childrenUnder8Text))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clearInputButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addHamperButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        //Creating a grouplayout for the outerPanel which contains the table
        GroupLayout outerPanelLayout = new GroupLayout(outerPanel);
        outerPanel.setLayout(outerPanelLayout);

        //Setting the horizantal layout for the outerPanel
        outerPanelLayout.setHorizontalGroup(
            outerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(outerPanelLayout.createSequentialGroup()
                .addComponent(hamperOrderForm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(outerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(outerPanelLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(tableScrollPanel, GroupLayout.PREFERRED_SIZE, 519, GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(outerPanelLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(outerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(clearHampersButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteHamperButton, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(submitOrderButton, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        //Setting the vertical layout for the outerPanel
        outerPanelLayout.setVerticalGroup(
            outerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(hamperOrderForm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(outerPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(tableScrollPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(outerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(outerPanelLayout.createSequentialGroup()
                        .addComponent(deleteHamperButton)
                        .addGap(18, 18, 18)
                        .addComponent(clearHampersButton))
                    .addComponent(submitOrderButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        //Creating a group layout to place the outerPanel
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(outerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(outerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        /*
        Method that allows all the components to be set as their preffered size and will allow 
        it to fit within the window
        */
        pack();
    }   


    /**
     * Method that determines what button is pressed, and calls its corresponding method that deals with 
     * that button's functionality
     * @param e ActionEvent object that represents the action performed on a certain button
    */ 
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(addHamperButton))
            addHamperButtonPressed(e);
        
        if(e.getSource().equals(clearInputButton))
            clearInputButtonPressed(e);

        if(e.getSource().equals(deleteHamperButton))
            deleteHamperButtonPressed(e);

        if(e.getSource().equals(clearHampersButton))
            clearHampersButtonPressed(e);
        
        if(e.getSource().equals(submitOrderButton))
            submitOrderButtonPressed(e);
    }


    /**
     * Method deals with the functionality of the "Clear All Hampers" button.
     * @param e ActionEvent object that represents the action performed on the "Clear All Hampers" button
    */                                            
    private void clearHampersButtonPressed(ActionEvent e) {                                                   
        DefaultTableModel table = (DefaultTableModel)hamperOrderTable.getModel();
        
        //Display error message when there are no hampers that need to be cleared
        if(table.getRowCount() == 0){
              JOptionPane.showMessageDialog(this, "There are no hampers to be cleared!", "Error!", JOptionPane.ERROR_MESSAGE);
        }

        //Removing all the row in the table, which cleaer all the hampers
        table.setRowCount(0);
    }   


    /**
     * Method deals with the functionality of the "Add Hamper Configuration" button.
     * @param e ActionEvent object that represents the action performed on the "Add Hamper Configuration" button
    */                                         
    private void addHamperButtonPressed(ActionEvent e) {                                                
        //Retrieve the user inputted values from all of the text fields
        String males = maleInput.getText();
        String females = femaleInput.getText();
        String childrenOv8 = childrenOver8Input.getText();
        String childrenUn8 = childrenUnder8Input.getText();
        
        //Initializing the variables for each person
        int malesInt;
        int femalesInt;
        int childrenOv8Int;        
        int childrenUn8Int;

        //Preventing additional hampers from being added if there are already 12 hampers in one order
        if(hamperOrderTable.getRowCount() == 12){
            JOptionPane.showMessageDialog(this, "No more than 12 hampers per order can be requested!","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Display an error message if any of the text fields are kept empty 
        try{
            if(males.isEmpty() || females.isEmpty() || childrenOv8.isEmpty() || childrenUn8.isEmpty())
                throw new IllegalArgumentException();
        }catch(IllegalArgumentException er){
            JOptionPane.showMessageDialog(this, "Please make sure all fields are filled!","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Display an error message is user inputs non-numerical values into the text fields, or a negetive numerical value
        try{
            malesInt = Integer.parseInt(males);
            femalesInt = Integer.parseInt(females);
            childrenOv8Int = Integer.parseInt(childrenOv8);
            childrenUn8Int = Integer.parseInt(childrenUn8);
            
            if(malesInt < 0 || femalesInt < 0 || childrenOv8Int < 0 || childrenUn8Int < 0)
                throw new IllegalArgumentException();
        }catch(Exception er){
            JOptionPane.showMessageDialog(this, "Please make sure all fields contain only a POSITIVE whole number!","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Adds row to the hamperOrderTable if the user inputs are valid
        DefaultTableModel table = (DefaultTableModel)hamperOrderTable.getModel();
        table.addRow(new Object[]{malesInt, femalesInt, childrenOv8Int, childrenUn8Int});
        
        //Clears the text in the text fields once those values have been added to the table
        maleInput.setText("");
        femaleInput.setText("");
        childrenOver8Input.setText("");
        childrenUnder8Input.setText("");
    }
    

    /**
     * Method deals with the functionality of the "Delete Hamper(s)" button.
     * @param e ActionEvent object that represents the action performed on the "Delete Hamper(s)" button
    */ 

    private void deleteHamperButtonPressed(ActionEvent e) {                                                   
        //Gets the row of the first selected row in the column
        int row = hamperOrderTable.getSelectedRow();
        DefaultTableModel table = (DefaultTableModel)hamperOrderTable.getModel();
        
        //Error message is shown if no row is selected, and the "Delete Hamper(s)" button is selected
        if(row < 0){
            JOptionPane.showMessageDialog(this, "No hampers are selected. Please select AT LEAST ONE hamper to delete it!","Error!", JOptionPane.ERROR_MESSAGE);
        }  
        else{
            //While loop that removes every row that has been selected 
            while(row != -1){
                table.removeRow(row);
                row = hamperOrderTable.getSelectedRow();
            }
        }
    } 
    
    
    /**
     * Method deals with the functionality of the "Clear Input" button.
     * @param e ActionEvent object that represents the action performed on the  "Clear Input" button
    */ 
    private void clearInputButtonPressed(ActionEvent e) {
        //Clears all of the text fields when the "Clear Input" button is selected                                                 
        maleInput.setText("");
        femaleInput.setText("");
        childrenOver8Input.setText("");
        childrenUnder8Input.setText("");
    }    
    
    /**
     * Method deals with the functionality of the "Submit Order" button.
     * @param e ActionEvent object that represents the action performed on the "Submit Order" button
    */ 
    private void submitOrderButtonPressed(ActionEvent e) {    
        DefaultTableModel table = (DefaultTableModel)hamperOrderTable.getModel();

        //If user enters no hampers, show error message and allow them to reinput data
        if(table.getRowCount() == 0){
            JOptionPane.showMessageDialog(this, "Please add at least one hamper before submitting your request!","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Method that will retrieve the contents of the table
        Vector<Vector> tableData = table.getDataVector();
        
        //Creating a double array that will store the contents of the table and send it to 
        int[][] userData = new int[tableData.size()][4];
        
        //Create an order object
        Order order = new Order();
        order.useDatabase();

        //Loop that stores all of the contents from the table into userData
        for(int i = 0; i < tableData.size(); i++){
            for(int j = 0; j < tableData.get(i).size(); j++)
                userData[i][j] = (int)tableData.get(i).get(j);
        } 

        //Add the hamper configuration to the order object if it can be found.
        try{
            for(int i = 0; i < userData.length; i++){
                order.addHamper(userData[i]);
                order.calculateTotals();
                order.determineFoodNeeded();
                order.removeFoodsLocal(order.getHamper(order.getHampers().size() - 1).getInventory().getAllFood());  
            }
        }
        //If a hamper configuration cannot be found with the existing foods in the database, then an error message will pop up
        catch(Exception er){
            JOptionPane.showMessageDialog(this, "There are no hampers to fulfill your requirements. Please check back later!","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }


         //Write order to text file
        PrintOrder print = new PrintOrder(order);

        //Get message to be displayed on confirmation
        String msg = getConfirmationMsg(order);

        //Display success message is order goes through
        JOptionPane.showMessageDialog(this, msg);

        //Remove all used foods in order from database
        order.removeFoodsDatabase();

        //Reset table cells
        table.setRowCount(0);
    }  
    

    /**
     * Method that produces a confirmation to be displayed to the user upon a successful order completion
     * @param order Order object that contains the relavent hampers requested by the user
    */ 
    private String getConfirmationMsg(Order order){
        int counter = 1;
        String msg = "Order Successful!" + '\n' + '\n';

        //Loop through the order object
        for(Hamper hmp: order.getHampers()){

            //Write the hamper number
            msg += ("Hamper "+ Integer.toString(counter++) +" Items"+"\n");
            
            //Create an iterator to iterate through the Arraylist of food iterms
            Iterator<ArrayList<String>> iter = hmp.getInventory().getAllFood().iterator();
            
            //Loop through the foods for a certain hamper
            while(iter.hasNext()){
                ArrayList<String> current = iter.next();

                //Add each food item to msg string
                msg += (current.get(1) + "   " + current.get(0) + "\n" );
            }
            msg += '\n';    
        }
        return msg.trim();
    } 
}//End of class declaration