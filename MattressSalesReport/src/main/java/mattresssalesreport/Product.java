/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mattresssalesreport;

/**
 *
 * @author omphi
 */

// Product implements the IProduct interface.
public class Product implements IProduct {

    // Single-dimensional array containing product names.
    private String[] productNames;

    // Two-dimensional array containing sales for three months.
    private int[][] monthlySales;

    // Constructor to initialise the product names and sales data.
    public Product(String[] productNames, int[][] monthlySales) {
        this.productNames = productNames;
        this.monthlySales = monthlySales;
    }

    // Calculates the total number of products sold.
    @Override
    public int getTotalProductsSold() {

        int totalSales = 0;

        // Loop through each product.
        for (int i = 0; i < monthlySales.length; i++) {

            // Loop through each month's sales.
            for (int j = 0; j < monthlySales[i].length; j++) {
                totalSales += monthlySales[i][j];
            }
        }

        return totalSales;
    }

    // Calculates the average number of products sold.
    @Override
    public double getAverageProductSold() {

        int totalSales = getTotalProductsSold();
        int numberOfSales = 0;

        // Count the number of sales entries.
        for (int i = 0; i < monthlySales.length; i++) {
            numberOfSales += monthlySales[i].length;
        }

        // Calculate and return the average.
        return (double) totalSales / numberOfSales;
    }

    // Finds the product with the highest total sales.
    @Override
    public String getMostPopularProduct() {

        int highestSales = 0;
        int popularProductIndex = 0;

        // Calculate total sales for each product.
        for (int i = 0; i < monthlySales.length; i++) {

            int productTotal = 0;

            for (int j = 0; j < monthlySales[i].length; j++) {
                productTotal += monthlySales[i][j];
            }

            // Check whether this product has the highest sales.
            if (productTotal > highestSales) {
                highestSales = productTotal;
                popularProductIndex = i;
            }
        }

        // Return the product name and its total sales.
        return productNames[popularProductIndex]
                + " (" + highestSales + ")";
    }
}

