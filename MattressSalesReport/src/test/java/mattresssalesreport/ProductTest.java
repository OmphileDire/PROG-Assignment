/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package mattresssalesreport;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 * @author omphi
 */

// Unit tests for the Product class.
public class ProductTest {

    // Test 1: Checks whether the total sales calculation is correct.
    @Test
    public void getTotalProductSalesWithValidDataReturnsCorrectValue() {

        String[] productNames = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        int[][] monthlySales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };

        // Create a Product object using test data.
        Product product = new Product(productNames, monthlySales);

        // Check whether the total sales equal 153.
        assertEquals(153, product.getTotalProductsSold());
    }

    // Test 2: Checks whether the average sales calculation is correct.
    @Test
    public void getAverageSalesWithValidDataReturnsCorrectValue() {

        String[] productNames = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        int[][] monthlySales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };

        // Create a Product object using test data.
        Product product = new Product(productNames, monthlySales);

        // Check whether the average sales equal 17.
        assertEquals(17.0, product.getAverageProductSold(), 0.01);
    }
}

