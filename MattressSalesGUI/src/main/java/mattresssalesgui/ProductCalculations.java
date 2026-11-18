/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mattresssalesgui;

/**
 * 
 * @author omphi
 */

// This class performs all product sales calculations.
public class ProductCalculations implements IProductCalculations {

    private double productPrice;

    // Constructor receives the product price.
    public ProductCalculations(double productPrice) {
        this.productPrice = productPrice;
    }

    // Calculates 15% VAT on the product price.
    @Override
    public double getVat() {
        return productPrice * 0.15;
    }

    // Calculates 5% commission on the product price.
    @Override
    public double getCommission() {
        return productPrice * 0.05;
    }

    // Calculates the total price including VAT and commission.
    @Override
    public double getTotal() {
        return productPrice + getVat() + getCommission();
    }
}

