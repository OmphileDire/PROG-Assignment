/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package mattresssalesgui;

/**
 * 
 * @author omphi
 */

// Interface defining the required sales calculation methods.
public interface IProductCalculations {

    // Calculates VAT.
    double getVat();

    // Calculates commission.
    double getCommission();

    // Calculates the total sale amount.
    double getTotal();
}

