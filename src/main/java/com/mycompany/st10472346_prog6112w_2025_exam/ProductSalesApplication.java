/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10472346_prog6112w_2025_exam;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author RC_Student_Lab
 */
public class ProductSalesApplication extends JFrame {

    private JButton loadProd;                                                   //-Button to display prouct data 
    private JButton saveProd;                                                   //-Button to save prouct data 
    private JMenuBar menuBar;                                                   //-Top menu bar
    private JMenu fileMenu, toolsMenu;                                          //-Menu labels
    private JMenuItem exitMenuItem;                                             //-Menu options
    private JMenuItem loadProdMenuItem, saveProdMenuItem, clearMenuItem;        //-Menu options
    private String[] year = {"Sales for Year 1", "Sales for Year 1"};
    private double[][] sales = { //-2D array storing sales figures, Row = years | Columns = prod type
        {300, 150, 700}, //-Sales for years 1
        {250, 200, 600} //-Sales for year 2        
    };
    private final String FILE_NAME = "C:\\Users\\RC_Student_Lab\\Documents\\NetBeansProjects\\ST10472346_PROG6112w_2025_EXAM\\data.txt";
    private JTextArea display;
    private DefaultListModel<String> productListModel;

    public ProductSalesApplication() {

//-STEP 1: BUILD THE FRAME WINDOW 
        //-1.1. Set the JFrame Layout
        setTitle("PRODUCT SALES");
        setSize(420, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                         //-Closes the frame when X is clicked
        setLocationRelativeTo(null);

        //-1.2. Set Gridlayout for Dynamic alignment
        setLayout(new GridBagLayout());                                         //-Tells JFrame to use a GridBagLayout as its layout manager
        GridBagConstraints consObj = new GridBagConstraints();                  //-Creates a new constraints object that tells the layout how to position each component
        consObj.insets = new Insets(10, 10, 10, 10);                            //-Spacing/Padding between components
        consObj.anchor = GridBagConstraints.WEST;

        //-1.3. Create Menu Bar and Menus
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        toolsMenu = new JMenu("Tools");
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        exitMenuItem = new JMenuItem("Exit");                                                              //-Menu items under File
        fileMenu.add(exitMenuItem);

        loadProdMenuItem = new JMenuItem("Load Product Data");                                                     //-Menu items under Tools
        saveProdMenuItem = new JMenuItem("Save Product Data");
        clearMenuItem = new JMenuItem("Clear");
        toolsMenu.add(loadProdMenuItem);
        toolsMenu.add(saveProdMenuItem);
        toolsMenu.add(clearMenuItem);

        setJMenuBar(menuBar);

        //-1.4. Create buttons and Text Area
        loadProd = new JButton("Load Product Data");
        saveProd = new JButton("Save Product Data");
        display = new JTextArea(10, 40);

        //-1.5. Set the Items in the Layout
        consObj.gridx = 0;
        consObj.gridy = 0;
        add(loadProd, consObj);

        consObj.gridx = 0;
        consObj.gridy = 1;
        add(saveProd, consObj);

        consObj.gridx = 0;
        consObj.gridy = 1;
        consObj.gridheight = 3;
        consObj.gridwidth = 3;
        consObj.weightx = 1.0;
        consObj.weighty = 1.0;
        add(display, consObj);

        //-STEP 2: ADD LOGIC TO THE SUBMIT BUTTON    
        loadProd.addActionListener(e -> loadProductsFromFile());
        exitMenuItem.addActionListener(e -> System.exit(0));                    //-"Exit" closes the application
        loadProdMenuItem.addActionListener(e -> loadProductsFromFile());
        saveProd.addActionListener(e -> saveProductToFile()); 
        clearMenuItem.addActionListener(e -> clearItems());                                 
    }

    /**
     *
     */
    private void loadProductsFromFile() 
    {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String productDetails = parts[0] + " | " + parts[1] + " | " + parts[2] + " sec | " + parts[3] + "L | " + parts[4];
                    productListModel.addElement(productDetails);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading from file: " + ex.getMessage());
        }
    }
    
    private void saveProductToFile()
    {
        System.out.println("Item saved to File...");
    }
    
    private void clearItems()
    {
        System.out.println("Items cleared");
    }
}
