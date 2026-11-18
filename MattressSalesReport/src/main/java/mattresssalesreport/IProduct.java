/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package mattresssalesreport;

/**
 *
 * @author omphi
 */

// Interface containing the methods required for product sales calculations.
public interface IProduct {

    // Returns the total number of products sold.
    int getTotalProductsSold();

    // Returns the average number of products sold.
    double getAverageProductSold();

    // Returns the name of the most popular product.
    String getMostPopularProduct();
}

