/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mattresssalesgui;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Main graphical interface for the mattress sales application.
public class ProductForm extends JFrame {

    private JTextField customerNameField;
    private JComboBox<String> productComboBox;
    private JTextField priceField;
    private JButton processButton;
    private JButton clearButton;

    // Constructor creates the application window.
    public ProductForm() {

        setTitle("Product App");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the main panel.
        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(
                25, 25, 25, 25));

        // Customer name input.
        mainPanel.add(new JLabel("Customer Name:"));
        customerNameField = new JTextField();
        mainPanel.add(customerNameField);

        // Product selection dropdown.
        mainPanel.add(new JLabel("Select Product:"));

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        productComboBox = new JComboBox<>(products);
        mainPanel.add(productComboBox);

        // Product price input.
        mainPanel.add(new JLabel("Enter Price:"));
        priceField = new JTextField();
        mainPanel.add(priceField);

        // Create buttons.
        processButton = new JButton("PROCESS");
        clearButton = new JButton("CLEAR");

        mainPanel.add(processButton);
        mainPanel.add(clearButton);

        // Add the panel to the window.
        add(mainPanel);

        // Create the menu bar.
        createMenuBar();

        // Process button uses the calculation method.
        processButton.addActionListener(e -> processSale());

        // Clear button resets the form.
        clearButton.addActionListener(e -> clearForm());
    }

    // Creates the File and Tools menus.
    private void createMenuBar() {

        JMenuBar menuBar = new JMenuBar();

        // File menu.
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");

        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(exitItem);

        // Tools menu.
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        // Menu Process uses the same method as the Process button.
        processItem.addActionListener(e -> processSale());

        // Menu Clear uses the same method as the Clear button.
        clearItem.addActionListener(e -> clearForm());

        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        // Add menus to the menu bar.
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);
    }

    // Processes the customer's mattress sale.
    private void processSale() {

        String customerName = customerNameField.getText().trim();
        String selectedProduct =
                (String) productComboBox.getSelectedItem();

        // Check that the customer name is entered.
        if (customerName.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter the customer name.");
            return;
        }

        double productPrice;

        // Validate the entered product price.
        try {
            productPrice = Double.parseDouble(priceField.getText());

            if (productPrice <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a valid price greater than zero.");
                return;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid numeric price.");
            return;
        }

        // Create the calculations object.
        ProductCalculations calculations =
                new ProductCalculations(productPrice);

        // Calculate VAT, commission and total.
        double vat = calculations.getVat();
        double commission = calculations.getCommission();
        double total = calculations.getTotal();

        // Prepare the sales information.
        String message = String.format(
                "Customer Name: %s%n"
                + "Product: %s%n"
                + "VAT: R %.2f%n"
                + "COMMISSION: R %.2f%n"
                + "TOTAL: R %.2f",
                customerName,
                selectedProduct,
                vat,
                commission,
                total
        );

        // Display the calculation results.
        JOptionPane.showMessageDialog(this, message);

        // Save the sales information to data.txt.
        saveData(customerName, selectedProduct,
                vat, commission, total);
    }

    // Saves the processed sale to a text file.
    private void saveData(String customerName, String product,
            double vat, double commission, double total) {

        try (PrintWriter writer =
                new PrintWriter(new FileWriter("data.txt", true))) {

            writer.println("DATA LOG");
            writer.println("****************************");
            writer.println("Customer Name: " + customerName);
            writer.println("Product: " + product);
            writer.printf("VAT: R %.2f%n", vat);
            writer.printf("COMMISSION: R %.2f%n", commission);
            writer.printf("TOTAL: R %.2f%n", total);
            writer.println("****************************");
            writer.println();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error saving data: " + e.getMessage());
        }
    }

    // Clears the text fields and resets the product selection.
    private void clearForm() {

        customerNameField.setText("");
        priceField.setText("");

        // Set the first product as the default selection.
        productComboBox.setSelectedIndex(0);
    }
}
