/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mattresssalesreport;

/**
 *
 * @author omphi
 */

// This class is responsible for printing the sales report.
public class PrintProduct {

    // Displays the total number of products sold.
    public void printTotalSales(Product product) {

        System.out.println("TOTAL PRODUCT SALES: "
                + product.getTotalProductsSold());
    }

    // Displays the average number of products sold.
    public void printAverageSales(Product product) {

        System.out.printf("AVERAGE PRODUCT SALES: %.0f%n",
                product.getAverageProductSold());
    }

    // Displays the most popular product.
    public void printMostPopularProduct(Product product) {

        System.out.println("MOST POPULAR PRODUCT: "
                + product.getMostPopularProduct());
    }

    // Prints the complete sales report.
    public void printSalesReport(Product product) {

        System.out.println();
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("================================");

        printTotalSales(product);
        printAverageSales(product);
        printMostPopularProduct(product);

        System.out.println("================================");
    }
}

