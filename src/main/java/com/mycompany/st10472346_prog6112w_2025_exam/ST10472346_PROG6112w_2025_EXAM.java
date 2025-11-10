/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.st10472346_prog6112w_2025_exam;


/**
 *
 * @author RC_Student_Lab
 */
public class ST10472346_PROG6112w_2025_EXAM 
{

    public static void main(String[] args) 
    {
        //String [] quaters = {"QUARTER 1", "QUARTER 2","QUARTER 3"};
        String [] years = {"Year 1", "Year 2"};
        
        int [][] sales = {
                            {300, 150, 700},    //Year 1
                            {250, 200, 600}     //Year 2 
        };
        
        System.out.println("***********************************************");
        System.out.println("PRODUCT SALES REPORST - 2025");
        System.out.println("***********************************************");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(" \t\t\tQUARTER 1\tQUARTER 2\tQUARTER 3");
        System.out.println("-----------------------------------------------------------------------");

        for (int i = 0; i < years.length; i++)                                                                //-Loop through each course and its corresponding registration figures
        {
            System.out.print(years[i] + "\t\t\t");                                                              //-Print the course name followed by its three registration numbers

            for (int j = 0; j < sales[i].length; j++)                                                   //-Inner loop: prints all registration figures for one course
            {
                System.out.print(sales[i][j] + "\t\t");
            }
            System.out.println();                                                                               //-Move to the next line after printing one course's data
        }
        
        int highest = sales[0][0];                                                                              //-Variables to track highest and lowest fines
        int lowest = sales[0][0];

        for (int i = 0; i < sales.length; i++)                                                                  //-Print fines and calculate statistics
        {
            System.out.print(years[i] + "\t\t\t");                                                             //-Prints city name
            for (int j = 0; j < sales[i].length; j++) 
            {
                System.out.print(sales[i][j] + "\t");                                                           //-Prints the fine
                if (sales[i][j] > highest) highest = sales[i][j];                                               //-Check highest
                if (sales[i][j] < lowest) lowest = sales[i][j];                                                 //-Check lowest
            }
            System.out.println();
        }
        
        System.out.println("***********************************************");
        System.out.println("SALES STATISTICS");
        System.out.println("***********************************************");
        System.out.println("Maximum sales: " + highest);
        System.out.println("Minimum sales: " + lowest);
        System.out.println("***********************************************"); 
        
        
        ProductSalesApplication app = new ProductSalesApplication();
        app.setVisible(true);
    }
}
