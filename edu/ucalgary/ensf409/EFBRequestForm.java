package edu.ucalgary.ensf409;

import java.awt.*;
import javax.swing.*;
 
public class EFBRequestForm {
    public static void main(String[] args) {
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
