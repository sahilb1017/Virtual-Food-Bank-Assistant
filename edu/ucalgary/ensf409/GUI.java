package edu.ucalgary.ensf409;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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


    public GUI() {
        super("Example Food Bank Hamper Request Form");
        initComponents();
    }
                   
    private void initComponents() {
        titleOne = new JLabel();
        titleTwo = new JLabel();
        subheading = new JLabel();
        hamperOrderForm = new JPanel();
        outerPanel = new JPanel();

        maleText = new JLabel();
        femaleText = new JLabel();
        childrenOver8Text = new JLabel();
        childrenUnder8Text = new JLabel();

        maleInput = new JTextField();
        femaleInput = new JTextField();
        childrenOver8Input = new JTextField();
        childrenUnder8Input = new JTextField();

        addHamperButton = new JButton();
        clearInputButton = new JButton();
        deleteHamperButton = new JButton();
        clearHampersButton = new JButton();
        submitOrderButton = new JButton();
        tableScrollPanel = new JScrollPane();
        hamperOrderTable = new JTable();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 

        outerPanel.setBackground(new Color(252, 255, 212));
        hamperOrderForm.setBackground(new Color(250, 252, 182));

        tableScrollPanel.setViewportView(hamperOrderTable);
        tableScrollPanel.getViewport().setBackground(new Color(254, 253, 233));
        tableScrollPanel.setBorder(BorderFactory.createLineBorder(new Color(121, 103, 58), 3));
        tableScrollPanel.setPreferredSize(new Dimension(452, 403));

        hamperOrderTable.setBackground(new Color(254, 253, 233));
        hamperOrderTable.setForeground(new Color(123, 106, 62));
        hamperOrderTable.setFont(new Font("Myanmar Text", 1, 15)); 
        hamperOrderTable.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"     Adult Males", "   Adult Females", " Children Over 8", "Children Under 8"}
        ) 
        {boolean[] canEdit = new boolean [] {false, false, false, false};
            public boolean isCellEditable(int rowIndex, int columnIndex){return canEdit [columnIndex];}
        });

        hamperOrderTable.setRowHeight(30);
        hamperOrderTable.getTableHeader().setReorderingAllowed(false);
        hamperOrderTable.getColumnModel().getColumn(0).setResizable(false);
        hamperOrderTable.getColumnModel().getColumn(1).setResizable(false);
        hamperOrderTable.getColumnModel().getColumn(2).setResizable(false);
        hamperOrderTable.getColumnModel().getColumn(3).setResizable(false);
        hamperOrderTable.setShowHorizontalLines(true);
        hamperOrderTable.setGridColor(new Color(121, 103, 58));
        hamperOrderTable.setSelectionBackground(new Color(121, 103, 58));

        DefaultTableCellRenderer head_render = new DefaultTableCellRenderer(); 
        head_render.setBackground(new Color(230,211,163));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < hamperOrderTable.getModel().getColumnCount(); i++) {
            hamperOrderTable.getColumnModel().getColumn(i).setHeaderRenderer(head_render);
            hamperOrderTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

    
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

        addHamperButton.setBackground(new Color(123, 106, 62));
        addHamperButton.setFont(new Font("Myanmar Text", 1, 14)); 
        addHamperButton.setForeground(new Color(255, 255, 255));
        addHamperButton.setText("ADD HAMPER CONFIGURATION");
        addHamperButton.setPreferredSize(new Dimension(194, 29));
        addHamperButton.addActionListener(this);
        addHamperButton.setBorder(BorderFactory.createLineBorder(new Color(178, 161, 117),4));

        clearInputButton.setBackground(new Color(255, 102, 102));
        clearInputButton.setFont(new Font("Myanmar Text", 1, 14)); 
        clearInputButton.setForeground(new Color(255, 255, 255));
        clearInputButton.setText("CLEAR INPUTS");
        clearInputButton.addActionListener(this);
        clearInputButton.setBorder(BorderFactory.createLineBorder(new Color(255, 122, 122),4));

        deleteHamperButton.setBackground(new Color(255, 102, 102));
        deleteHamperButton.setFont(new Font("Myanmar Text", 1, 14)); 
        deleteHamperButton.setForeground(new Color(255, 255, 255));
        deleteHamperButton.setText("DELETE HAMPER(S)");
        deleteHamperButton.addActionListener(this);
        deleteHamperButton.setBorder(BorderFactory.createLineBorder(new Color(255, 122, 122),4));

        clearHampersButton.setBackground(new Color(255, 102, 102));
        clearHampersButton.setFont(new Font("Myanmar Text", 1, 14)); 
        clearHampersButton.setForeground(new Color(255, 255, 255));
        clearHampersButton.setText("CLEAR ALL HAMPERS");
        clearHampersButton.addActionListener(this);
        clearHampersButton.setBorder(BorderFactory.createLineBorder(new Color(255, 122, 122),4));

        submitOrderButton.setBackground(new Color(115, 203, 107));
        submitOrderButton.setFont(new Font("Myanmar Text", 1, 24)); 
        submitOrderButton.setForeground(new Color(255, 255, 255));
        submitOrderButton.setText("SUBMIT ORDER");
        submitOrderButton.addActionListener(this);
        submitOrderButton.setBorder(BorderFactory.createLineBorder(new Color(165, 253, 157),4));

        GroupLayout hamperOrderFormLayout = new GroupLayout(hamperOrderForm);
        hamperOrderForm.setLayout(hamperOrderFormLayout);
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

        GroupLayout outerPanelLayout = new GroupLayout(outerPanel);
        outerPanel.setLayout(outerPanelLayout);
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

        pack();
    }   
    
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

                                               
    private void clearHampersButtonPressed(ActionEvent e) {                                                   
        DefaultTableModel table = (DefaultTableModel)hamperOrderTable.getModel();
        if(table.getRowCount() == 0){
              JOptionPane.showMessageDialog(this, "There are no hampers to be cleared!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        table.setRowCount(0);
    }                                                  

                                            
    private void addHamperButtonPressed(ActionEvent e) {                                                
        String males = maleInput.getText();
        String females = femaleInput.getText();
        String childrenOv8 = childrenOver8Input.getText();
        String childrenUn8 = childrenUnder8Input.getText();
        
        int malesInt;
        int femalesInt;
        int childrenOv8Int;        
        int childrenUn8Int;

        if(hamperOrderTable.getRowCount() == 12){
            JOptionPane.showMessageDialog(this, "No more than 12 hampers per order can be requested!","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try{
            if(males.isEmpty() || females.isEmpty() || childrenOv8.isEmpty() || childrenUn8.isEmpty())
                throw new IllegalArgumentException();
        }catch(IllegalArgumentException er){
            JOptionPane.showMessageDialog(this, "Please make sure all fields are filled!","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try{
            malesInt = Integer.parseInt(males);
            femalesInt = Integer.parseInt(females);
            childrenOv8Int = Integer.parseInt(childrenOv8);
            childrenUn8Int = Integer.parseInt(childrenUn8);
            
            if(malesInt < 0 || femalesInt < 0 || childrenOv8Int < 0 || childrenUn8Int < 0)
                throw new IllegalArgumentException();
        }catch(Exception er){
            JOptionPane.showMessageDialog(this, "Please make sure all fields contain only a POSITIVE numerical value!","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        DefaultTableModel table = (DefaultTableModel)hamperOrderTable.getModel();
        table.addRow(new Object[]{malesInt, femalesInt, childrenOv8Int, childrenUn8Int});
        
        maleInput.setText("");
        femaleInput.setText("");
        childrenOver8Input.setText("");
        childrenUnder8Input.setText("");
    }                                               

    private void deleteHamperButtonPressed(ActionEvent e) {                                                   
        int row = hamperOrderTable.getSelectedRow();
        DefaultTableModel table = (DefaultTableModel)hamperOrderTable.getModel();
    
        if(row < 0){
            JOptionPane.showMessageDialog(this, "No hampers are selected. Please select AT LEAST ONE hamper to delete it!","Error!", JOptionPane.ERROR_MESSAGE);
        }  
        else{
            while(row != -1){
                table.removeRow(row);
                row = hamperOrderTable.getSelectedRow();
            }
        }
    }                                                  

    private void clearInputButtonPressed(ActionEvent e) {                                                 
        maleInput.setText("");
        femaleInput.setText("");
        childrenOver8Input.setText("");
        childrenUnder8Input.setText("");
    }    
    
    private void submitOrderButtonPressed(ActionEvent e) {                                                  
    }   


    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
        } 

        EventQueue.invokeLater(() -> {
                new GUI().setVisible(true);
        });
    }             
}