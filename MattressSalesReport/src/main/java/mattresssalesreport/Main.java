/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mattresssalesreport;
import java.util.Scanner;

/**
 *
 * @author omphi
 */
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Single-dimensional array containing mattress names.
        String[] productNames = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        // Two-dimensional array storing sales for three months.
        int[][] monthlySales = new int[3][3];

        String[] months = {"1", "2", "3"};

        // Collect sales information for every product.
        for (int i = 0; i < productNames.length; i++) {

            for (int j = 0; j < monthlySales[i].length; j++) {

                System.out.print("Enter number of sales for month "
                        + months[j] + " for " + productNames[i]
                        + " mattress: ");

                monthlySales[i][j] = input.nextInt();
            }

            System.out.println();
        }

        // Create a Product object using the collected information.
        Product product = new Product(productNames, monthlySales);

        // Create a PrintProduct object to display the report.
        PrintProduct printer = new PrintProduct();

        // Display the final sales report.
        printer.printSalesReport(product);

        input.close();
    }
}

