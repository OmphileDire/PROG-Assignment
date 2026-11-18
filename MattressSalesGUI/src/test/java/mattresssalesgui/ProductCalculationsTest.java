/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package mattresssalesgui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Unit tests for the ProductCalculations class.
public class ProductCalculationsTest {

    // Test 1: Checks whether VAT is calculated correctly.
    @Test
    public void getVatWithValidDataReturnsCorrectValue() {

        // Create calculations using a product price of R3500.
        ProductCalculations calculations =
                new ProductCalculations(3500);

        // VAT should be 15% of R3500 = R525.
        assertEquals(525.0, calculations.getVat(), 0.01);
    }

    // Test 2: Checks whether the total sale is calculated correctly.
    @Test
    public void getTotalWithValidDataReturnsCorrectValue() {

        // Create calculations using a product price of R3500.
        ProductCalculations calculations =
                new ProductCalculations(3500);

        // Total = R3500 + R525 VAT + R175 commission.
        assertEquals(4200.0, calculations.getTotal(), 0.01);
    }
}

