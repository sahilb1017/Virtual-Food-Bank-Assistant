/**
@author Sahil Bhatt
@author Harshal Patel
@author Siwon Kim
@author Abhiraam Manchiraju    

<a href="mailto:sahil.bhatt@ucalgary.ca"> sahil.bhatt@ucalgary.ca</a>
<a href="mailto:harshal.patel@ucalgary.ca"> harshal.patel@ucalgary.ca</a>
<a href="mailto:siwon.kim@ucalgary.ca"> siwon.kim@ucalgary.ca</a>
<a href="mailto:abhiraam.manchiraju@ucalgary.ca"> abhiraam.manchiraju@ucalgary.ca</a>

@version 1.9
@since 1.0
*/

package edu.ucalgary.ensf409;

import java.awt.*;
import javax.swing.*;
 
public class EFBRequestForm {

    /**
     * The main method that calls GUI.java, which loads up the GUI for users to request
     * hampers
     * @param args There
    */
    public static void main(String[] args) {
        /*
        Loads up the nimbus library, which is used for styling purposes in the GUI. Exception is handled
        if the libaray cannot be loaded
        */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
        } 

        //Calls the GUI class, and set the visibility to true which allows user to see the GUI window
        EventQueue.invokeLater(() -> {
                new GUI().setVisible(true);
        });
    }
}//End of Class Declaration
