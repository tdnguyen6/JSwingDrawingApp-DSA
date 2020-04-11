/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa2020;

import javax.swing.*;

/**
 * @author LTSACH
 */
public class MainApp {
    public static void main(String[] args) {
        try {
            //            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        MainFrame mainFrame = new MainFrame("DSA-2020 Baseline App");
                        mainFrame.setVisible(true);
                    }
                });
    }
}
