/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package mattresssalesgui;

// Starts the mattress sales GUI application.
public class Main {

    public static void main(String[] args) {

        // Launch the application on the Swing event thread.
        javax.swing.SwingUtilities.invokeLater(() -> {

            ProductForm form = new ProductForm();
            form.setVisible(true);

        });
    }
}
